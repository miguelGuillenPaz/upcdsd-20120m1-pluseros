package pe.edu.upc.srs.seguridad.servicios;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.util.UtilWebServiceSPA;


public class ImplSeguridadService implements ISeguridadService {

	@Override
	public ClienteDTO autenticarCliente(String strUsuario,String strClave) {
		// TODO Auto-generated method stub
		ClienteDTO objClienteDTO = null;
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_LOGIN_SPA);
			System.out.println("llego aca 1");
			objCall.setOperationName(new QName("http://tempuri.org/","RetornaCliente"));
			System.out.println("llego aca 2");
			objCall.addParameter("usuario", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("llego aca 3");
			objCall.addParameter("clave", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("llego aca 4");
			
			objCall.setReturnClass(String.class);
			System.out.println("llego aca 5");
			
			String[] datosCliente = (String[]) objCall.invoke(new Object[]{strUsuario,strClave});
			System.out.println("llego aca 6");
			for(String str: datosCliente){
				System.out.println("- "+str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objClienteDTO;
	}

}
