/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.gestion.servicios.utilitarios;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class UtilWebService {

	public static String WS_AUTENTICACION_SRS;
	public static String WS_RESERVA_SRS;
	public static String WS_MANTENIMIENTO_SPA;
	
	private static String fichero = "pe.edu.upc.srs.gestion.servicios.configuracion.servicios";
	
	public static void cargarWebServices(){
		WS_AUTENTICACION_SRS = UtilProperties.getMessage(fichero, "WS_AUTENTICACION_SRS");
		WS_RESERVA_SRS = UtilProperties.getMessage(fichero, "WS_RESERVAS_SRS");
		WS_MANTENIMIENTO_SPA = UtilProperties.getMessage(fichero, "WS_MANTENIMIENTO_SRS");
	}
	
	public static Call getCallService(String url){
		Service servicio= new Service();
		
		System.out.println("se instancia el nuevo servicio");
		try {
			System.out.println("antes del call service");
			Call caller=(Call)servicio.createCall();
			System.out.println("se crea el nuevo servicio");
			caller.setTargetEndpointAddress(url);
			System.out.println("se setea el endpoint");
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}