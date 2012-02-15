/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.reservas.bean.DepartamentoDTO;
import pe.edu.upc.srs.reservas.bean.DistritoDTO;
import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.bean.ProvinciaDTO;
import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.util.UtilWebServiceSPA;
import pe.edu.upc.srs.util.cifrado.Sha1;

public class ImplReservaService implements IReservaService{

	@Override
	public ArrayList<ServicioDTO>  obtenerServicios() {
		// TODO Auto-generated method stub
		ArrayList<ServicioDTO>  lstServicioDTO = null;
		ServicioDTO[]  ServicioDTOs = null;
		try {
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","obtenerServicios"));
			objCall.setReturnClass(ServicioDTO[].class);
			
			ServicioDTOs = (ServicioDTO[])objCall.invoke(new Object[]{});
			lstServicioDTO = new ArrayList<ServicioDTO>();
			
			for(ServicioDTO serv:ServicioDTOs){
				lstServicioDTO.add(serv);
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
			objCall.registerTypeMapping(EmpleadoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
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

	
	@Override
	public int registrarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		int intResultado = 0;
		try {
			
			cliente.setClave(Sha1.getHash(cliente.getClave()));
			
			Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
			
			objCall.registerTypeMapping(ClienteDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.registerTypeMapping(DistritoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
			objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe","registrarCliente"));
			objCall.setReturnClass(Integer.class);
			objCall.addParameter("cliente", new QName("http://beans.mantenimiento.srs.upc.edu.pe", "ClienteDTO"), ParameterMode.IN);
			
			intResultado = Integer.parseInt(objCall.invoke(new Object[]{cliente}).toString());
			
			System.out.println("resultado: "+intResultado);
			
		} catch (Exception e) {
			intResultado = -1;
			e.printStackTrace();
		}
		return intResultado;
	}

	@Override
	public ArrayList<DepartamentoDTO> listarDepartamentos() {
		DepartamentoDTO[] departamentos = null;
		ArrayList<DepartamentoDTO> lstDepartamentoDTO = null;
        try {
            Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
            objCall.registerTypeMapping(DepartamentoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.setOperationName(new QName("http://servicios.servicios.gestion.srs.upc.edu.pe", "listarDepartamentos"));
            objCall.setReturnClass(DepartamentoDTO[].class);

            departamentos =  (DepartamentoDTO[]) objCall.invoke(new Object[]{});
            lstDepartamentoDTO = new ArrayList<DepartamentoDTO>();
            for(DepartamentoDTO dep : departamentos){
            	lstDepartamentoDTO.add(dep);
            }
            
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarDepartamentos(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }
		return lstDepartamentoDTO;
	}

	@Override
	public ArrayList<DistritoDTO> listarDistritos(String idProvincia) {
		ArrayList<DistritoDTO> lstDistritoDTO = null;
		DistritoDTO[] distritos = null;

        try {
            Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
            objCall.registerTypeMapping(ProvinciaDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.registerTypeMapping(DistritoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.setOperationName(new QName("http://beans.servicios.gestion.srs.upc.edu.pe", "listarDistritos"));
            objCall.addParameter("idProvincia", XMLType.XSD_STRING, ParameterMode.IN);
            objCall.setReturnClass(DistritoDTO[].class);

            distritos =  (DistritoDTO[]) objCall.invoke(new Object[]{idProvincia});
            lstDistritoDTO = new ArrayList<DistritoDTO>();
            
            for(DistritoDTO dis : distritos){
            	lstDistritoDTO.add(dis);
            }
            
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarDistritos(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return lstDistritoDTO;
	}

	@Override
	public ArrayList<ProvinciaDTO> listarProvincias(String idDepartamento) {
		ArrayList<ProvinciaDTO> lstProvinciaDTO = null;
		ProvinciaDTO[] provincias = null;

        try {
            Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
            objCall.registerTypeMapping(DepartamentoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.registerTypeMapping(ProvinciaDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.setOperationName(new QName("http://beans.servicios.gestion.srs.upc.edu.pe", "listarProvincias"));
            objCall.addParameter("idDepartamento", XMLType.XSD_STRING, ParameterMode.IN);
            objCall.setReturnClass(ProvinciaDTO[].class);

            provincias =  (ProvinciaDTO[]) objCall.invoke(new Object[]{idDepartamento});
            lstProvinciaDTO = new ArrayList<ProvinciaDTO>();
            for(ProvinciaDTO prov : provincias){
            	lstProvinciaDTO.add(prov);
            }
            
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarProvincias(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }
        return lstProvinciaDTO;
	}

	@Override
	public int registrarEmpleado(EmpleadoDTO empleado) {
		int resultado = 0;

        try {
            Call objCall = UtilWebServiceSPA.getCallService(UtilWebServiceSPA.WS_GESTION_SERVICIOS);
            objCall.registerTypeMapping(EmpleadoDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            //objCall.registerTypeMapping(ServicioDTO.class, new QName("http://beans.servicios.gestion.srs.upc.edu.pe"), BeanSerializerFactory.class, BeanDeserializerFactory.class);
            objCall.setOperationName(new QName("http://beans.servicios.gestion.srs.upc.edu.pe", "registrarEmpleado"));
            objCall.addParameter("empleado", new QName("http://beans.servicios.gestion.srs.upc.edu.pe", "EmpleadoDTO"), ParameterMode.IN);
            objCall.setReturnType(XMLType.XSD_INT);

            resultado =  (Integer)objCall.invoke(new Object[]{empleado});
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarEmpleado(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = -1;
        }

        return resultado;
	}

}
