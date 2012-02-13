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
		int existeUsuario = 0;
		
		if(!"".equals(cliente.getUsuario()) && !"".equals(cliente.getClave())){
			existeUsuario = despachadorCliente.validarUsuario(cliente.getUsuario());
		}
		
		if(existeUsuario == 0){
			return despachadorCliente.registrarCliente(cliente);
		}else{
			return -2;//El usuario ya existe
		}

		
	}

}
