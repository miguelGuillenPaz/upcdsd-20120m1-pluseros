package sigel.util.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.edu.upc.srs.util.UtilSPA;

public class AplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try {
			Context ctx = new InitialContext();
			Context myCtx = (Context)ctx.lookup("java:comp/env"); 
			UtilSPA.WS_SISTEMA_RESERVAS_SPA = (String)myCtx.lookup("WS_SISTEMA_RESERVAS_SPA");
			System.out.println("Valor del web service: "+UtilSPA.WS_SISTEMA_RESERVAS_SPA);
			System.out.println("Se leyeron correctamente las variables del web.xml");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
		
}