/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.action;

import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.util.UtilMethod;
import com.opensymphony.xwork2.ActionSupport;

public class ServicioAction extends ActionSupport implements ServletContextAware,ServletRequestAware {

	private static final long serialVersionUID = -1243207746934198152L;
	private ArrayList<ServicioDTO> lstServicioDTO;
	private ServicioDTO objServicioDTO;
	private File flFotoServicio;
	private ServletContext objServletContext;
	private HttpServletRequest request;
	private String strMensaje;
	
	public String mantenerServicio(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		setLstServicioDTO(objImplReservaService.obtenerServicios());
		
		return SUCCESS;
	}

	public String registrarServicio(){
		objServicioDTO.setRutaImagen(request.getParameter("rutaImagen").toString());
		try {
			if(flFotoServicio != null)
				UtilMethod.grabaArchivoEnServidor(objServicioDTO.getRutaImagen(),flFotoServicio,objServletContext.getRealPath(""),UtilMethod.DIRECTORIO_SERVICIO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImplReservaService objImplReservaService = new ImplReservaService();
		int intResultado = objImplReservaService.registrarServicio(objServicioDTO);
				
		switch (intResultado) {
		case 0:
			setStrMensaje("Ocurrio un problema al registrar al servicio.");
			break;
		case 1: 
			setStrMensaje("Operacion Exitosa");
			break;
		case -1:
			setStrMensaje("ERROR-EXCEPTION: Ocurrio un registrar el cliente.");
			break;
		}
		
		return SUCCESS;
	}
	
	public void setLstServicioDTO(ArrayList<ServicioDTO> lstServicioDTO) {
		this.lstServicioDTO = lstServicioDTO;
	}

	public ArrayList<ServicioDTO> getLstServicioDTO() {
		return lstServicioDTO;
	}

	public void setObjServicioDTO(ServicioDTO objServicioDTO) {
		this.objServicioDTO = objServicioDTO;
	}



	public ServicioDTO getObjServicioDTO() {
		return objServicioDTO;
	}



	public void setFlFotoServicio(File flFotoServicio) {
		this.flFotoServicio = flFotoServicio;
	}



	public File getFlFotoServicio() {
		return flFotoServicio;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setObjServletContext(ServletContext objServletContext) {
		this.objServletContext = objServletContext;
	}

	public ServletContext getObjServletContext() {
		return objServletContext;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		objServletContext = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	
}
