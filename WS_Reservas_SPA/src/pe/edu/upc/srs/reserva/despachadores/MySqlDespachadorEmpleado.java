/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.PersonalDTO;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorEmpleado extends SqlMapDaoTemplate implements IDespachadorEmpleado {

    public MySqlDespachadorEmpleado(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
	@Override
    public ArrayList<PersonalDTO> obtenerEmpleadosPorServicio(int servicio) {
        ArrayList<PersonalDTO> empleados = null;

        try {
            empleados = new ArrayList<PersonalDTO>();
            empleados = (ArrayList<PersonalDTO>) queryForList("obtenerEmpleadosPorServicio", servicio);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerEmpleadosPorServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }
        

        return empleados;
    }
}