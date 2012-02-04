package pe.edu.upc.srs.mantenimiento.servicios;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.IDespachadorCliente;
import pe.edu.upc.srs.mantenimiento.utilitarios.UtilDaoConfig;

public class ImplCliente implements IServicioCliente {
	
	DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
	IDespachadorCliente despachadorCliente= (IDespachadorCliente) fabrica.getDao(IDespachadorCliente.class);

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		return despachadorCliente.registrarCliente(cliente);
		
	}

}
