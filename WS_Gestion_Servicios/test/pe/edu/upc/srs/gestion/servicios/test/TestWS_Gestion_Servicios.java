package pe.edu.upc.srs.gestion.servicios.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.upc.srs.gestion.servicios.beans.ReservaDTO;
import pe.edu.upc.srs.gestion.servicios.servicios.IGestionServicios;
import pe.edu.upc.srs.gestion.servicios.servicios.ImplGestionServicios;
import pe.edu.upc.srs.gestion.servicios.utilitarios.UtilWebService;

public class TestWS_Gestion_Servicios {

	@Test
	public void testBuscarReserva() {
		/* Se cargan la información del servicio web */
		UtilWebService.cargarWebServices();
		
		/* Datos de prueba - Código de la Reserva */
		String codigo = "R0000001";
		
		IGestionServicios servicio = new ImplGestionServicios();
		ReservaDTO reservaRecuperada = servicio.buscarReserva(codigo);

		/* Prueba Recuperación de Reserva */
        assertTrue(reservaRecuperada != null);
        /* Prueba Reserva Habilitada */
        assertTrue(reservaRecuperada.getId() == 1);
	}

}
