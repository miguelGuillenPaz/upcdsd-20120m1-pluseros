/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.reservas.bean.PersonalDTO;
import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.util.UtilWebServiceSPA;

public class ImplReservaService implements IReservaService{

	@Override
	public ArrayList<ServicioDTO> obtenerServicios() {
		// TODO Auto-generated method stub
		ArrayList<ServicioDTO> lstServicioDTO = null;
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","obtenerServicios"));
			objCall.setReturnClass(ServicioDTO.class);
			
			lstServicioDTO = (ArrayList<ServicioDTO>) objCall.invoke(new Object[]{});
			
			lstServicioDTO = new ArrayList<ServicioDTO>();
			System.out.println("llego aca 5");
			for(ServicioDTO serv:lstServicioDTO){
				System.out.println(serv.getId());
				System.out.println(serv.getDescripcion());
				System.out.println(serv.getDuracion());
				System.out.println(serv.getRutaImagen());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstServicioDTO;
	}

	@Override
	public ReservaDTO buscarReserva(String codigo) {
		// TODO Auto-generated method stub
		ReservaDTO objReservaDTO = null;
		
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			
			objCall.registerTypeMapping(ReservaDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(ClienteDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(PersonalDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","buscarReserva"));
			objCall.setReturnClass(ReservaDTO.class);
			objCall.addParameter("codigo", XMLType.XSD_STRING, ParameterMode.IN);
			
			objReservaDTO = (ReservaDTO) objCall.invoke(new Object[]{codigo});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objReservaDTO;
	}

	@Override
	public int anularReserva(int codigo) {
		// TODO Auto-generated method stub
		int intResultado = 0;
		try {
			
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","anularReserva"));
			objCall.setReturnClass(Integer.class);
			objCall.addParameter("codigo", XMLType.XSD_INT, ParameterMode.IN);
			
			intResultado = Integer.parseInt(objCall.invoke(new Object[]{codigo}).toString());
			
			System.out.println("resultado: "+intResultado);
			
		} catch (Exception e) {
			intResultado = -1;
			e.printStackTrace();
		}
		return intResultado;
	}

}
