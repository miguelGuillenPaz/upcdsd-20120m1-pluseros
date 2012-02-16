/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.action;

import java.util.ArrayList;
import java.util.Map;

import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.util.UtilMethod;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisponibilidadAction extends ActionSupport{
	 
	private static final long serialVersionUID = 1L;
	private int id_servicio;
	private int id_empleado;
	private String picker;
	private ArrayList<EmpleadoDTO> lstEmpleadoDTO;
	private ArrayList<ServicioDTO> lstServicioDTO;
	private ArrayList<ReservaDTO> lstReservaDTO;
	private ArrayList<ArrayList<EmpleadoDTO>> lstPosiblesEmpleados;
	//private EmpleadoDTO objEmpleadoDTO;

	public String disponibilidad(){
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		lstServicioDTO = objImplReservaService.obtenerServicios();
		
		return SUCCESS;
	}
	
	public String seleccionaServicio(){
		
		String strFechaActual = UtilMethod.getFechaActual();
		String[] lstParteFechas = UtilMethod.obtenerPartesDia(strFechaActual);
		
		System.out.println(lstParteFechas[0]);
		System.out.println(lstParteFechas[1]);
		System.out.println(lstParteFechas[2]);
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		lstReservaDTO = objImplReservaService.obtenerHorariosDisponibles(id_servicio, lstParteFechas[0], lstParteFechas[1], lstParteFechas[2]);
		lstPosiblesEmpleados = new ArrayList<ArrayList<EmpleadoDTO>>();
		for(ReservaDTO res : lstReservaDTO){
			ArrayList<EmpleadoDTO> lstE = objImplReservaService.obtenerEmpleadosDisponibles(id_servicio, 
										lstParteFechas[0], lstParteFechas[1], lstParteFechas[2],
										res.getHoraInicio().substring(0,2) , res.getHoraFin().substring(0,2));
			lstPosiblesEmpleados.add(lstE);
		}
		
		picker = UtilMethod.getFechaActual();
		Map session = ActionContext.getContext().getSession();
		session.put("piker_", picker);
		System.out.println("CANTIDAD DE RESERVAS: "+lstReservaDTO.size());
		
		return SUCCESS;
	}
	
	public String buscarPorDia(){
		System.out.println("FECHA: "+picker.substring(0,10));
		String strFechaFormateada = UtilMethod.formateaFecha_ddMMyyyy(picker.substring(0,10), "-", "/");
		
		String[] lstParteFechas = UtilMethod.obtenerPartesDia(strFechaFormateada);
		
		System.out.println(lstParteFechas[0]);
		System.out.println(lstParteFechas[1]);
		System.out.println(lstParteFechas[2]);
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		lstReservaDTO = objImplReservaService.obtenerHorariosDisponibles(id_servicio, lstParteFechas[0], lstParteFechas[1], lstParteFechas[2]);
		
		lstPosiblesEmpleados = new ArrayList<ArrayList<EmpleadoDTO>>();
		for(ReservaDTO res : lstReservaDTO){
			ArrayList<EmpleadoDTO> lstE = objImplReservaService.obtenerEmpleadosDisponibles(id_servicio, 
										lstParteFechas[0], lstParteFechas[1], lstParteFechas[2],
										res.getHoraInicio().substring(0,2) , res.getHoraFin().substring(0,2));
			lstPosiblesEmpleados.add(lstE);
		}
		
		
		picker = strFechaFormateada;
		Map session = ActionContext.getContext().getSession();
		session.put("piker_", picker);
		System.out.println("CANTIDAD DE RESERVAS 2: "+lstReservaDTO.size());
		
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

	public void setLstEmpleadoDTO(ArrayList<EmpleadoDTO> lstEmpleadoDTO) {
		this.lstEmpleadoDTO = lstEmpleadoDTO;
	}

	public ArrayList<EmpleadoDTO> getLstEmpleadoDTO() {
		return lstEmpleadoDTO;
	}

	public void setPicker(String picker) {
		this.picker = picker;
	}

	public String getPicker() {
		return picker;
	}

	public ArrayList<ReservaDTO> getLstReservaDTO() {
		return lstReservaDTO;
	}

	public void setLstReservaDTO(ArrayList<ReservaDTO> lstReservaDTO) {
		this.lstReservaDTO = lstReservaDTO;
	}

	public void setLstPosiblesEmpleados(ArrayList<ArrayList<EmpleadoDTO>> lstPosiblesEmpleados) {
		this.lstPosiblesEmpleados = lstPosiblesEmpleados;
	}

	public ArrayList<ArrayList<EmpleadoDTO>> getLstPosiblesEmpleados() {
		return lstPosiblesEmpleados;
	}
	
	
}
