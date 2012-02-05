/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.gestion.servicios.utilitarios;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class UtilWebService {

	public static String WS_AUTENTICACION_SRS_PATH;
	public static String WS_AUTENTICACION_SRS_HOST;
	public static int WS_AUTENTICACION_SRS_PUERTO;
	public static String WS_RESERVA_SRS;
	public static String WS_MANTENIMIENTO_SPA;
	
	private static String fichero = "pe.edu.upc.srs.gestion.servicios.configuracion.servicios";
	
	public static void cargarWebServices(){
		WS_AUTENTICACION_SRS_PATH = UtilProperties.getMessage(fichero, "WS_AUTENTICACION_SRS.PATH");
		WS_AUTENTICACION_SRS_HOST = UtilProperties.getMessage(fichero, "WS_AUTENTICACION_SRS.HOST");
		WS_AUTENTICACION_SRS_PUERTO = Integer.parseInt(UtilProperties.getMessage(fichero, "WS_AUTENTICACION_SRS.PUERTO"));
		WS_RESERVA_SRS = UtilProperties.getMessage(fichero, "WS_RESERVAS_SRS");
		WS_MANTENIMIENTO_SPA = UtilProperties.getMessage(fichero, "WS_MANTENIMIENTO_SRS");
	}
	
	public static Call getCallService(String url){
		Service servicio= new Service();
		System.out.println("se instancia el nuevo servicio");
		try {
			Call caller=(Call)servicio.createCall();
			caller.setTargetEndpointAddress(url);
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}