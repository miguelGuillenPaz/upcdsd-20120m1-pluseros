package pe.edu.upc.srs.reservas.action;

import java.util.ArrayList;

import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.IReservaService;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionSupport;

public class DisponibilidadAction extends ActionSupport{
	 
	private static final long serialVersionUID = 1L;
	private int id_servicio;
	private int id_empleado;
	private ArrayList<EmpleadoDTO> lstEmpleadoDTO;
	private ArrayList<ServicioDTO> lstServicioDTO;
	//private EmpleadoDTO objEmpleadoDTO;

	public String disponibilidad(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		lstServicioDTO = objImplReservaService.obtenerServicios();
		
		return SUCCESS;
	}
	
	public String seleccionaServicio(){
		
		
		
		System.out.println("el codigo seleccionado es: "+id_servicio);
		lstEmpleadoDTO = new ArrayList<EmpleadoDTO>();
		/* Se implementa la logica de consulta al web service */
		for (int i = 0; i < 6; i++) {
			EmpleadoDTO objEmpleadoDTO = new EmpleadoDTO();
			objEmpleadoDTO = new EmpleadoDTO();
			objEmpleadoDTO.setId_empleado(i);
			objEmpleadoDTO.setNombre("Empleado "+(i+1));
			lstEmpleadoDTO.add(objEmpleadoDTO);
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

	public void setLstEmpleadoDTO(ArrayList<EmpleadoDTO> lstEmpleadoDTO) {
		this.lstEmpleadoDTO = lstEmpleadoDTO;
	}

	public ArrayList<EmpleadoDTO> getLstEmpleadoDTO() {
		return lstEmpleadoDTO;
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
