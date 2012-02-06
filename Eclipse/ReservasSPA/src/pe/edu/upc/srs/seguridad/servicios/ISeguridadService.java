package pe.edu.upc.srs.seguridad.servicios;

import pe.edu.upc.srs.seguridad.bean.UsuarioDTO;

public interface ISeguridadService {

	public UsuarioDTO autenticarCliente(String strUsuario,String strClave);
	
}
