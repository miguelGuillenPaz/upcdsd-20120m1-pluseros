package pe.edu.upc.srs.reservas.action;

import java.io.File;

import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionSupport;

public class EmpleadoAction extends ActionSupport{

	private static final long serialVersionUID = -1149483159796106280L;

	private EmpleadoDTO objEmpleadoDTO;
	private String strMensaje;
	//private File flfoto;
	
	public String mantenerEmpleado(){
		return SUCCESS;
	}

	public String registrarEmpleado(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		int intResultado = objImplReservaService.registrarEmpleado(objEmpleadoDTO);
		
		//System.out.println("la foto es: "+flfoto);
		
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

	public void setObjEmpleadoDTO(EmpleadoDTO objEmpleadoDTO) {
		this.objEmpleadoDTO = objEmpleadoDTO;
	}

	public EmpleadoDTO getObjEmpleadoDTO() {
		return objEmpleadoDTO;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	
}
