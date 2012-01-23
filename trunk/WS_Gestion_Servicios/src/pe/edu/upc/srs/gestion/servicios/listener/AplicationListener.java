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
		System.out.println("-- Inicio carga de los servicios web --");
		UtilWebService.cargarWebServices();
		System.out.println("-- Fin carga de los servicios web --");
	}
		
}
