/**
 * 
 *@author miguel
 */


package pe.edu.upc.srs.mantenimiento.despachadores;

import java.sql.SQLException;


import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;


public class MySqlCliente extends SqlMapDaoTemplate implements IDespachadorCliente {

	public MySqlCliente(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		int resultado=0;
		
		try{
			getSqlMapExecutor().insert("sp_registrar_cliente", cliente);
			resultado = 1;
		}catch (SQLException e) {
			System.out.println("Error - " + this.getClass().getName() + ".registrarCliente(): " + e.getMessage() );
			e.printStackTrace();
			resultado =-1;
		}
	
		return resultado;
	}

}
