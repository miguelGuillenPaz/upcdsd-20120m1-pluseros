/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.gestion.servicios.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.edu.upc.srs.gestion.servicios.utilitarios.UtilWebService;

public class AplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-- Inicio Servicio Web WS_Gestion_Servicios --");
		UtilWebService.cargarWebServices();
		System.out.println("-- Fin Servicio Web WS_Gestion_Servicios --");
	}
		
}
