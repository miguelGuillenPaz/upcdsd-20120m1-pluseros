/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.action;

import java.util.ArrayList;

import pe.edu.upc.srs.reservas.bean.PersonalDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.IReservaService;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionSupport;

public class DisponibilidadAction extends ActionSupport{
	 
	private static final long serialVersionUID = 1L;
	private int id_servicio;
	private int id_empleado;
	private ArrayList<PersonalDTO> lstPersonalDTO;
	private ArrayList<ServicioDTO> lstServicioDTO;
	//private EmpleadoDTO objEmpleadoDTO;

	public String disponibilidad(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		lstServicioDTO = objImplReservaService.obtenerServicios();
		
		return SUCCESS;
	}
	
	public String seleccionaServicio(){
		
		
		
		System.out.println("el codigo seleccionado es: "+id_servicio);
		lstPersonalDTO = new ArrayList<PersonalDTO>();
		/* Se implementa la logica de consulta al web service */
		for (int i = 0; i < 6; i++) {
			PersonalDTO objPersonalDTO = new PersonalDTO();
			objPersonalDTO = new PersonalDTO();
			objPersonalDTO.setId(i);
			objPersonalDTO.setNombres("Empleado "+(i+1));
			lstPersonalDTO.add(objPersonalDTO);
		}
		System.out.println("fin del action");
		
		return SUCCESS;
	}
	
	public String seleccionaEmpleado(){
		System.out.println(id_empleado);
		System.out.println("el codigo del empleado es: "+id_empleado);
		/* Se implementa la logica de consulta al web service */
		return SUCCESS;
	}
	
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setLstPersonalDTO(ArrayList<PersonalDTO> lstPersonalDTO) {
		this.lstPersonalDTO = lstPersonalDTO;
	}

	public ArrayList<PersonalDTO> getLstPersonalDTO() {
		return lstPersonalDTO;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public int getId_empleado() {
		return id_empleado;
	}

	public void setLstServicioDTO(ArrayList<ServicioDTO> lstServicioDTO) {
		this.lstServicioDTO = lstServicioDTO;
	}

	public ArrayList<ServicioDTO> getLstServicioDTO() {
		return lstServicioDTO;
	}
	
}
