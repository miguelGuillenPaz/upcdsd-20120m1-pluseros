package pe.edu.upc.srs.reservas.action;

import java.util.Map;

import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.util.UtilMethod;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReservaAction extends ActionSupport{

	private static final long serialVersionUID = -4808299293733417157L;
	private String strCodigoReserva;
	private ReservaDTO objReservaDTO;
	private String strMensaje;
	private String strMensajeExito;
	
	@SuppressWarnings("unchecked")
	public String anularReserva(){
		strCodigoReserva = "";
		strMensajeExito = "";
		strMensaje = "";
		Map session = ActionContext.getContext().getSession();
		session.remove("objReservaDTO");
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String buscarReserva(){
		if(strCodigoReserva.equals("")){
			strMensaje = "* Debe de ingresar un código de reserva";
		}else{
			ImplReservaService objImplReservaService = new ImplReservaService();
			objReservaDTO = objImplReservaService.buscarReserva(strCodigoReserva);
			if(objReservaDTO != null){
				objReservaDTO.setHoraInicio(UtilMethod.formateaHora24(objReservaDTO.getHoraInicio()));
				objReservaDTO.setHoraFin(UtilMethod.formateaHora24(objReservaDTO.getHoraFin()));
				
				if(objReservaDTO.getEstado().equals("A")){
					strMensaje = "* La Reserva ya ha sido anulada";
				}else if(objReservaDTO.getEstado().equals("R")){
					strMensaje = "* La Reserva ya ha sido realizada";
				}
				
			}else{
				strMensaje = "* No Existe una reserva asociada con ese código";
			}
			
		}
		
		Map session = ActionContext.getContext().getSession();
		session.put("objReservaDTO", objReservaDTO);
		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String registrarAnulacionReserva(){
		Map session = ActionContext.getContext().getSession();
		objReservaDTO = (ReservaDTO) session.get("objReservaDTO");

		ImplReservaService objImplReservaService = new ImplReservaService();
		int intResultado = objImplReservaService.anularReserva(objReservaDTO.getId());
		
		switch (intResultado) {
		case 0:
			strMensaje = "* Ocurrio un problema al anular la reserva.";
			break;
		case 1: 
			setStrMensajeExito("Se anulo la reserva satisfactoriamente");
			break;
		case -1:
			strMensaje = "ERROR-EXCEPTION: Ocurrio un problema al anular la reserva.";
			break;
		}
		
		return SUCCESS;
	}
	
	public String getStrCodigoReserva() {
		return strCodigoReserva;
	}

	public void setStrCodigoReserva(String strCodigoReserva) {
		this.strCodigoReserva = strCodigoReserva;
	}

	public ReservaDTO getObjReservaDTO() {
		return objReservaDTO;
	}

	public void setObjReservaDTO(ReservaDTO objReservaDTO) {
		this.objReservaDTO = objReservaDTO;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setStrMensajeExito(String strMensajeExito) {
		this.strMensajeExito = strMensajeExito;
	}

	public String getStrMensajeExito() {
		return strMensajeExito;
	}
	
	
}
