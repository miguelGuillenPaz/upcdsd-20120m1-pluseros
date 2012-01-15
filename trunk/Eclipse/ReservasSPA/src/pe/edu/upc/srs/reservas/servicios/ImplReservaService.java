package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.util.UtilSPA;

public class ImplReservaService implements IReservaService{

	@Override
	public ArrayList<ServicioDTO> obtenerServicios() {
		// TODO Auto-generated method stub
		try {
			System.out.println("llego aca");
			Call objCall = UtilSPA.getCallService(UtilSPA.WS_SISTEMA_RESERVAS_SPA);
			System.out.println("llego aca 1");
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.reserva.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			System.out.println("llego aca 2");
			objCall.setOperationName(new QName("http://servicios.reserva.srs.upc.edu.pe","obtenerServicios"));
			System.out.println("llego aca 3");
			objCall.setReturnClass(ArrayList.class);
			System.out.println("llego aca 4");
			ArrayList<ServicioDTO> lstServicioDTO = (ArrayList<ServicioDTO>)objCall.invoke(new Object[]{});
			System.out.println("llego aca 5");
			for(ServicioDTO serv:lstServicioDTO){
				System.out.println(serv.getDescripcion());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
