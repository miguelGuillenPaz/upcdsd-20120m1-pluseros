package pe.edu.upc.srs.seguridad.servicios;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.util.UtilWebServiceSPA;


public class ImplSeguridadService implements ISeguridadService {

	@Override
	public ClienteDTO autenticarCliente(String strUsuario,String strClave) {
		// TODO Auto-generated method stub
		ClienteDTO objClienteDTO = null;
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			/*System.out.println("llego aca 1");
			objCall.registerTypeMapping(ClienteDTO.class, new QName("http://tempuri.org/","ClienteDTO"), 
					BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://tempuri.org/","RetornaCliente"));
		
			objCall.setUseSOAPAction(true);
			objCall.setSOAPActionURI("http://tempuri.org/RetornaCliente");
			
			objCall.addParameter("usuario", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("llego aca 3");
			objCall.addParameter("clave", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("llego aca 4");
			
			objCall.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
			objCall.getOperation().setStyle(org.apache.axis.constants.Style.WRAPPED);
			objCall.getOperation().setUse(org.apache.axis.constants.Use.LITERAL);
			objCall.setEncodingStyle(null);
			objCall.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
			objCall.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
			objCall.setReturnClass(ClienteDTO.class);
			objCall.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", "ClienteDTO"),ClienteDTO.class);
			objCall.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "RetornaClienteResult"));
			System.out.println("llego aca 5");
			
			objClienteDTO= (ClienteDTO) objCall.invoke(new Object[]{strUsuario,strClave});
			System.out.println("llego aca 6");

			System.out.println(objClienteDTO.getNombres());
			System.out.println(objClienteDTO.getApellidoPaterno());*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objClienteDTO;
	}

}
