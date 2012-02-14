package pe.edu.upc.srs.reservas.action;

import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.reservas.bean.DistritoDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionSupport;

public class ClienteAction extends ActionSupport{

	private static final long serialVersionUID = 7329641875836041026L;
	private ClienteDTO objClienteDTO;
	private String strMensaje;
	
	public String mantenerCliente(){
		return SUCCESS;
	}
	
	public String registrarCliente(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		int intResultado = objImplReservaService.registrarCliente(objClienteDTO);
		
		switch (intResultado) {
		case 0:
			setStrMensaje("Ocurrio un problema al registrar al cliente.");
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

	public ClienteDTO getObjClienteDTO() {
		return objClienteDTO;
	}

	public void setObjClienteDTO(ClienteDTO objClienteDTO) {
		this.objClienteDTO = objClienteDTO;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public String getStrMensaje() {
		return strMensaje;
	}	
}
