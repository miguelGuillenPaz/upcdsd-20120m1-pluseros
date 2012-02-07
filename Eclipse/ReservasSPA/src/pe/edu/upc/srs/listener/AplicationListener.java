/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.edu.upc.srs.util.UtilWebServiceSPA;

public class AplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-- Inicio Aplicaci�n ReservasSPA --");
		UtilWebServiceSPA.cargarWebServices();
		System.out.println("-- Fin Aplicaci�n ReservasSPA --");
	}
		
}
