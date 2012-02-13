/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pe.edu.upc.srs.reserva.beans.EmpleadoDTO;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorEmpleado extends SqlMapDaoTemplate implements IDespachadorEmpleado {

    public MySqlDespachadorEmpleado(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
	@Override
    public ArrayList<EmpleadoDTO> obtenerEmpleadosDisponibles(int idServicio, String dia, String mes, String anio, String horaInicio, String horaFin) {
        ArrayList<EmpleadoDTO> empleadosDisponibles = new ArrayList<EmpleadoDTO>();
        Map<String, Object> datosConsulta = new HashMap<String, Object>();

        datosConsulta.put("idServicio", new Integer(idServicio));
        datosConsulta.put("dia", new String(dia));
        datosConsulta.put("mes", new String(mes));
        datosConsulta.put("anio", new String(anio));
        datosConsulta.put("horaInicio", new String(horaInicio));
        datosConsulta.put("horaFin", new String(horaFin));

        try {
            empleadosDisponibles = (ArrayList<EmpleadoDTO>) queryForList("sp_obtener_empleados_disponibles", datosConsulta);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerEmpleadosDisponibles(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return empleadosDisponibles;
    }
}