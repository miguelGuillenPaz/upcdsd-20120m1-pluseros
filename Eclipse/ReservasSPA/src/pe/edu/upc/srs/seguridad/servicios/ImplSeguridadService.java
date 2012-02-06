package pe.edu.upc.srs.seguridad.servicios;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.seguridad.bean.UsuarioDTO;
import pe.edu.upc.srs.util.UtilWebServiceSPA;


public class ImplSeguridadService implements ISeguridadService {

	@Override
	public UsuarioDTO autenticarCliente(String strUsuario, String strClave) {
		UsuarioDTO objUsuarioDTO = null;
		
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			objCall.registerTypeMapping(UsuarioDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","autenticarUsuario"));
			objCall.setReturnClass(UsuarioDTO.class);
			objCall.addParameter("usuario", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.addParameter("clave", XMLType.XSD_STRING, ParameterMode.IN);
			
			objUsuarioDTO = (UsuarioDTO) objCall.invoke(new Object[]{strUsuario,strClave});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objUsuarioDTO;
	}

	
}
