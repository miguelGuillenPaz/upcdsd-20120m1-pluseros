package pe.edu.upc.srs.seguridad.servicios;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;

public interface ISeguridadService {

	public ClienteDTO autenticarCliente(String strUsuario,String strClave);
	
}
