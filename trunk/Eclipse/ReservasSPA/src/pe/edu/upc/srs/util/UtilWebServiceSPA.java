/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.util;

import org.apache.axis.client.*;


public class UtilWebServiceSPA {

	public static String WS_GESTION_SERVICIOS;
	private static String fichero = "pe.edu.upc.srs.util.WS";
	
	public static void cargarWebServices(){
	
		String key = "WS_GESTION_SERVICIOS";
		WS_GESTION_SERVICIOS = UtilProperties.getMessage(fichero, key);
		
	}
	
	public static Call getCallService(String ws){
		Service servicio= new Service();
		try {
			Call caller=(Call)servicio.createCall();
			caller.setTargetEndpointAddress(ws);
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
