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
		System.out.println("CODIGO: "+strCodigoReserva);
		
		if(strCodigoReserva.equals("")){
			System.out.println("ENTRO ACA!");
			strMensaje = "* Debe de ingresar un código de reserva";
		}else{
			ImplReservaService objImplReservaService = new ImplReservaService();
			objReservaDTO = objImplReservaService.buscarReserva(strCodigoReserva);
			objReservaDTO.setHoraInicio(UtilMethod.formateaHora24(objReservaDTO.getHoraInicio()));
			objReservaDTO.setHoraFin(UtilMethod.formateaHora24(objReservaDTO.getHoraFin()));
		}
		
		Map session = ActionContext.getContext().getSession();
		session.put("objReservaDTO", objReservaDTO);
		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String registrarAnulacionReserva(){
		Map session = ActionContext.getContext().getSession();
		objReservaDTO = (ReservaDTO) session.get("objReservaDTO");
		
		System.out.println("CODIGO: "+objReservaDTO.getId());

		ImplReservaService objImplReservaService = new ImplReservaService();
		int intResultado = objImplReservaService.anularReserva(objReservaDTO.getId());
		
		System.out.println("RESULTADO: "+intResultado);
		
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
