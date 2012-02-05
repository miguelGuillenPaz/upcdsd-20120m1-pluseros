/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.gestion.servicios.servicios;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.gestion.servicios.beans.ClienteDTO;
import pe.edu.upc.srs.gestion.servicios.beans.EmpleadoDTO;
import pe.edu.upc.srs.gestion.servicios.beans.PersonalDTO;
import pe.edu.upc.srs.gestion.servicios.beans.ReservaDTO;
import pe.edu.upc.srs.gestion.servicios.beans.ServicioDTO;
import pe.edu.upc.srs.gestion.servicios.utilitarios.UtilWebService;

public class ImplGestionServicios implements IGestionServicios {


	@Override
	public ClienteDTO autenticarCliente(String strUsuario, String strClave) {
		return null;
	}

	@Override
	public String registrarReserva(ReservaDTO reserva) {
		String resultado = "";
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public int anularReserva(int codigo) {
		int resultado = 0;

		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_RESERVA_SRS);
			objCall.setOperationName(new QName("http://servicios.reserva.srs.upc.edu.pe","anularReserva"));
			objCall.addParameter("codigo", XMLType.XSD_INT, ParameterMode.IN);
			objCall.setReturnType(XMLType.XSD_INT);
			
			resultado =  (Integer)objCall.invoke(new Object[]{codigo});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".anularReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = -1;
		}

		return resultado;
	}

	@Override
	public ReservaDTO buscarReserva(String codigo) {
		ReservaDTO reserva = null;
		
		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_RESERVA_SRS);
			objCall.registerTypeMapping(ReservaDTO.class, new QName("http://beans.reserva.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.reserva.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(ClienteDTO.class, new QName("http://beans.reserva.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(PersonalDTO.class, new QName("http://beans.reserva.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.reserva.srs.upc.edu.pe","buscarReserva"));
			objCall.addParameter("codigo", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.setReturnClass(ReservaDTO.class);
			
			reserva =  (ReservaDTO) objCall.invoke(new Object[]{codigo});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
		}

		return reserva;
	}

	@Override
	public PersonalDTO[] obtenerEmpleadosPorServicio(int servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservaDTO[] obtenerHorariosPorServicio(ReservaDTO reserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservaDTO[] obtenerHorariosPorPersonal(int personal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registrarServicio(ServicioDTO servicio) {
		int resultado = 0;

		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_MANTENIMIENTO_SPA);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.mantenimiento.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.mantenimiento.srs.upc.edu.pe", "registrarServicio"));
			objCall.addParameter("servicio", new QName("http://beans.mantenimiento.srs.upc.edu.pe", "ServicioDTO"), ParameterMode.IN);
			objCall.setReturnType(XMLType.XSD_INT);

			resultado =  (Integer)objCall.invoke(new Object[]{servicio});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = -1;
		}

		return resultado;
	}

	@Override
	public int modificarServicio(ServicioDTO servicio) {
		int resultado = 0;

		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_MANTENIMIENTO_SPA);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.mantenimiento.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.mantenimiento.srs.upc.edu.pe", "modificarServicio"));
			objCall.addParameter("servicio", new QName("http://beans.mantenimiento.srs.upc.edu.pe", "ServicioDTO"), ParameterMode.IN);
			objCall.setReturnType(XMLType.XSD_INT);

			resultado =  (Integer)objCall.invoke(new Object[]{servicio});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = -1;
		}

		return resultado;
	}

	@Override
	public int eliminarServicio(int codigo) {
		int resultado = 0;

		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_RESERVA_SRS);
			objCall.setOperationName(new QName("http://servicios.mantenimiento.srs.upc.edu.pe","eliminarServicio"));
			objCall.addParameter("codigo", XMLType.XSD_INT, ParameterMode.IN);
			objCall.setReturnType(XMLType.XSD_INT);

			resultado =  (Integer)objCall.invoke(new Object[]{codigo});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".eliminarServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = -1;
		}

		return resultado;
	}

	@Override
	public ServicioDTO buscarServicio(int codigo) {
		ServicioDTO servicio = null;
		
		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_RESERVA_SRS);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.mantenimiento.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.mantenimiento.srs.upc.edu.pe", "buscarServicio"));
			objCall.addParameter("codigo", XMLType.XSD_STRING, ParameterMode.IN);
			objCall.setReturnClass(ServicioDTO.class);
			
			servicio =  (ServicioDTO) objCall.invoke(new Object[]{codigo});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".buscarServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
		}

		return servicio;
	}

	@Override
	public ServicioDTO[] obtenerServicios() {
		ServicioDTO[] servicios = null;
		
		try {
			Call objCall = UtilWebService.getCallService(UtilWebService.WS_RESERVA_SRS);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.mantenimiento.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.mantenimiento.srs.upc.edu.pe", "obtenerServicios"));
			objCall.setReturnClass(ServicioDTO.class);
			
			servicios =  (ServicioDTO[]) objCall.invoke(new Object[]{});
		} catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerServicios(): " + excepcion.getMessage());
            excepcion.printStackTrace();
		}

		return servicios;
	}

	@Override
	public int registrarEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return 0;
	}


}
