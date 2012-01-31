/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public class MySqlEmpleadoServicio extends SqlMapDaoTemplate implements IDespachadorEmpleadoServicio {

	public MySqlEmpleadoServicio(DaoManager daoManager) {
		super(daoManager);
	}

	@Override
	public int RegistrarEmpleadoServicio(EmpleadoServicioDTO empserv) {
		int resultado = 0;
    	
    	try {
			getSqlMapExecutor().insert("sp_registrar_empleadoservicio", empserv);
			resultado = 1;
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".registrarEmpleadoServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;
	}

	@Override
	public int ModificarEmpleadoServicio(EmpleadoServicioDTO empserv) {
		int resultado = 0;
    	
    	try {
			getSqlMapExecutor().update("sp_modificar_empleadoservicio", empserv);
			resultado = 1;
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".modificarEmpleadoServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;
	}

	@Override
	public int EliminarEmpleadoServicio(int emp, int serv) {
		int resultado = 0;
    	
    	try {
			getSqlMapExecutor().delete("sp_eliminar_empleadoservicio", emp);
			resultado = 1;
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".eliminarEmpleadoServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;
	}

	@Override
	public EmpleadoServicioDTO buscarEmpleadosxServicio(int servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoServicioDTO buscarServiciosxEmpleados(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmpleadoServicioDTO> obtenerEmpleadoServicios() {
		// TODO Auto-generated method stub
		return null;
	}


}
