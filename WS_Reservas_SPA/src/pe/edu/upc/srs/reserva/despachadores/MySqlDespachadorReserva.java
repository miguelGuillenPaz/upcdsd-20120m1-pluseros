/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.beans.Servicio;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorReserva extends SqlMapDaoTemplate implements IDespachadorReserva {

    public MySqlDespachadorReserva(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
	@Override
    public ArrayList<Personal> obtenerEmpleadosPorServicio(Servicio servicio) {
        ArrayList<Personal> empleados = new ArrayList<Personal>();
        empleados = (ArrayList<Personal>) queryForList("obtenerEmpleadosPorServicio", servicio.getId());

        return empleados;
    }

    @Override
    public int registrarReserva(Reserva reserva) {
        int resultado = 0;
    	
    	try {
			getSqlMapExecutor().insert("sp_registrar_reserva", reserva);
			resultado = 1;
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".registrarReserva(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;
    }

    @Override
    public int anularReserva(Reserva reserva) {
    // TODO Auto-generated method stub
        return 0;
    }
}