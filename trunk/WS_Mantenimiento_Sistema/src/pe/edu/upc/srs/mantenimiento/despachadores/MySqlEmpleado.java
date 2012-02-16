/**
 * @author Elías García
 */

package pe.edu.upc.srs.mantenimiento.despachadores;

import java.sql.SQLException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public class MySqlEmpleado extends SqlMapDaoTemplate implements IDespachadorEmpleado{
	
	public MySqlEmpleado(DaoManager daoManager) {
		super(daoManager);
	}

	@Override
	public int registrarEmpleado(EmpleadoDTO empleado) {
		int resultado = 0;
		try {
			getSqlMapExecutor().insert("sp_registrar_empleado", empleado);
			resultado = 1;
		} catch (SQLException excepcion){
			System.out.println("Error - " + this.getClass().getName() + ".registrarEmpleado(): " + excepcion.getMessage());
			excepcion.printStackTrace();
            resultado = -1;
		}
		return resultado;
	}

	@Override
	public int asociarServicio(EmpleadoServicioDTO[] empserv) {
		int resultado = 0;
		
		try {
			for(EmpleadoServicioDTO es : empserv){
				getSqlMapExecutor().insert("sp_registrar_empleadoservicio", es);
			}
			resultado = 1;
		} catch (SQLException excepcion){
			System.out.println("Error - " + this.getClass().getName() + ".registrarEmpleado(): " + excepcion.getMessage());
			excepcion.printStackTrace();
            resultado = -1;
		}
		
		return resultado;
	}

	@Override
	public EmpleadoDTO obtenerEmpleado(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
