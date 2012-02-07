/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.seguridad.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.upc.srs.seguridad.bean.UsuarioDTO;
import pe.edu.upc.srs.seguridad.servicios.ISeguridadService;
import pe.edu.upc.srs.seguridad.servicios.ImplSeguridadService;
import pe.edu.upc.srs.util.UtilWebServiceSPA;

public class TestReservasSPA {

	@Test
	public void testAutenticarCliente() {
		/* Se cargan la información del servicio web */
		UtilWebServiceSPA.cargarWebServices();
		
		/* Datos de prueba */
		String usuario = "aroncalla";
		String clave = "aroncalla";

		ISeguridadService servicio = new ImplSeguridadService();
		UsuarioDTO usuarioRecuperado = servicio.autenticarCliente(usuario, clave);

		/* Prueba Recuperación de Usuario */
        assertTrue(usuarioRecuperado != null);
        /* Prueba Usuario Habilitado */
        assertTrue(usuarioRecuperado.getEstado() == 1);
	}

}
