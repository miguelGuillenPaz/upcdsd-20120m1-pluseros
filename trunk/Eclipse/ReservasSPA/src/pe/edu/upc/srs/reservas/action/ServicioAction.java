package pe.edu.upc.srs.reservas.action;

import java.util.ArrayList;

import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionSupport;

public class ServicioAction extends ActionSupport{

	private static final long serialVersionUID = -1243207746934198152L;
	private ArrayList<ServicioDTO> lstServicioDTO;
	
	public String mantenerServicio(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		setLstServicioDTO(objImplReservaService.obtenerServicios());
		
		return SUCCESS;
	}

	public void setLstServicioDTO(ArrayList<ServicioDTO> lstServicioDTO) {
		this.lstServicioDTO = lstServicioDTO;
	}

	public ArrayList<ServicioDTO> getLstServicioDTO() {
		return lstServicioDTO;
	}
	
}
