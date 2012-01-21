/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.util;

import org.apache.axis.client.*;


public class UtilWebServiceSPA {

	public static String WS_SISTEMA_RESERVAS_SPA;
	public static String WS_LOGIN_SPA;
	private static String fichero = "pe.edu.upc.srs.util.WS";
	
	public static void cargarWebServices(){
	
		String key = "WS_SISTEMA_RESERVAS_SPA";
		WS_SISTEMA_RESERVAS_SPA = UtilProperties.getMessage(fichero, key);
		key = "WS_LOGIN_SPA";
		WS_LOGIN_SPA = UtilProperties.getMessage(fichero, key);
	}
	
	public static Call getCallService(String ws){
		Service servicio= new Service();
		System.out.println("se instancia el nuevo servicio");
		try {
			System.out.println("antes del call service");
			Call caller=(Call)servicio.createCall();
			System.out.println("se crea el nuevo servicio");
			caller.setTargetEndpointAddress(ws);
			System.out.println("se setea el endpoint");
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
