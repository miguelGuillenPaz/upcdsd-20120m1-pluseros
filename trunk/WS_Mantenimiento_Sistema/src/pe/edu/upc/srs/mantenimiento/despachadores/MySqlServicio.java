/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public class MySqlServicio extends SqlMapDaoTemplate implements IDespachadorServicio {
	
	public MySqlServicio(DaoManager daoManager) {
		super(daoManager);
	}

	@Override
	public int registrarServicio(ServicioDTO servicio) {
		int resultado = 0;
    	
    	try {
    		System.out.println("INICIO");
    		System.out.println("id del servicio: "+servicio.getId());
    		getSqlMapExecutor().insert("sp_registrar_servicio", servicio);
			resultado = 1;
			System.out.println("fin de la ejecucipon");
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".registrarServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;
	}

	@Override
	public int modificarServicio(ServicioDTO servicio) {
		int resultado = 0;
    	
    	try {
    		System.out.println("INICIO");
    		System.out.println("id del servicio: "+servicio.getId());
			getSqlMapExecutor().update("sp_modificar_servicio", servicio);
			resultado = 1;
			System.out.println("fin de la ejecucipon");
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".modificarServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;

	}

	@Override
	public int eliminarServicio(int codigo) {
		int resultado = 0;
    	
    	try {
			getSqlMapExecutor().delete("sp_eliminar_servicio", codigo);
			resultado = 1;
    	} catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".eliminarServicio(): " + e.getMessage());
			e.printStackTrace();
			resultado = -1;
		}
    	
    	return resultado;

	}

	@Override
	public ServicioDTO buscarServicio(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ServicioDTO> obtenerServicios() {
		
        ArrayList<ServicioDTO> servicio = new ArrayList<ServicioDTO>();

        try {
            servicio = (ArrayList<ServicioDTO>) queryForList("sp_obtenerservicios_servicio","");
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerServicios(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return servicio;
	}
	

}
