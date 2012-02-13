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
		System.out.println("NOMBRE: "+objClienteDTO.getNombres());
		System.out.println("APELLIDO P: "+objClienteDTO.getApellidoPaterno());
		System.out.println("APELLIDO M: "+objClienteDTO.getApellidoMaterno());
		System.out.println("DIRECCION: "+objClienteDTO.getDireccion());
		System.out.println("TIPO DOC: "+objClienteDTO.getTipoDocumentoIdentidad());
		System.out.println("NUM DOC: "+objClienteDTO.getNroDocumentoIdentidad());
		System.out.println("E-MAIL: "+objClienteDTO.getEmail());
		System.out.println("TELEFONO "+objClienteDTO.getTelefono());
		System.out.println("USUARIO: "+objClienteDTO.getUsuario());
		System.out.println("CLAVE: "+objClienteDTO.getClave());
		
		DistritoDTO objDistritoDTO = new DistritoDTO();
		objDistritoDTO.setId("150101");
		
		objClienteDTO.setDistrito(objDistritoDTO);
		
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
