/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.util;

import org.apache.axis.client.*;


public class UtilWebServiceSPA {

	public static String WS_GESTION_SERVICIOS;
	public static String JMS_USER;
	public static String JMS_PASS;
	public static String JMS_URL;
	public static String JMS_QUEUE_NAME;
	private static String fichero = "pe.edu.upc.srs.util.WS";
	
	public static void cargarWebServices(){
	
		String key = "WS_GESTION_SERVICIOS";
		WS_GESTION_SERVICIOS = UtilProperties.getMessage(fichero, key);
		key = "JMS_USER";
		JMS_USER = UtilProperties.getMessage(fichero, key);
		key = "JMS_PASS";
		JMS_PASS = UtilProperties.getMessage(fichero, key);
		key = "JMS_URL";
		JMS_URL = UtilProperties.getMessage(fichero, key);
		key = "JMS_QUEUE_NAME";
		JMS_QUEUE_NAME = UtilProperties.getMessage(fichero, key);
		
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
