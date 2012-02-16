package pe.edu.upc.srs.reservas.action;

import java.util.ArrayList;
import java.util.Map;

import pe.edu.upc.srs.jms.JMSQueueSender;
import pe.edu.upc.srs.mail.MailDTO;
import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.seguridad.bean.UsuarioDTO;
import pe.edu.upc.srs.util.UtilMethod;
import pe.edu.upc.srs.util.UtilWebServiceSPA;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReservaAction extends ActionSupport{

	private static final long serialVersionUID = -4808299293733417157L;
	private String strCodigoReserva;
	private ReservaDTO objReservaDTO;
	private String strMensaje;
	private String strMensajeExito;
	
	private int id_servicio;
	private int id_empleado;
	private String horaIni;
	private String horaFin;
	private ArrayList<ReservaDTO> lstReservaDTO;
	private ArrayList<ArrayList<EmpleadoDTO>> lstPosiblesEmpleados;
	
	
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
	
	public String registrarReserva(){
		Map session = ActionContext.getContext().getSession();
		UsuarioDTO objUsuarioDTO = (UsuarioDTO) session.get("objUsuarioDTO");
		
		System.out.println("FECHA: "+session.get("piker_"));
		//String strFechaFormateada = UtilMethod.formateaFecha_ddMMyyyy(picker.substring(0,10), "-", "/");
		String[] lstParteFechas = UtilMethod.obtenerPartesDia(session.get("piker_").toString());
		
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		ReservaDTO objR = new ReservaDTO();
		ClienteDTO objClienteDTO = new ClienteDTO();
		objClienteDTO.setId(1);
		objR.setCliente(objClienteDTO);
		objR.setDia(lstParteFechas[0]);
		objR.setMes(lstParteFechas[1]);
		objR.setAnio(lstParteFechas[2]);
		ServicioDTO serv = new ServicioDTO();
		serv.setId(id_servicio);
		objR.setServicio(serv);
		EmpleadoDTO emp = new EmpleadoDTO();
		emp.setId(id_empleado);
		System.out.println("id_empleado "+id_empleado);
		objR.setEmpleado(emp);
		objR.setHoraInicio(horaIni.substring(0,2));
		objR.setHoraFin(horaFin.substring(0,2));
		
		String strCodigo = objImplReservaService.registrarReserva(objR);
		
		if(strCodigo != "error"){
			MailDTO objMailDTO = new MailDTO();
			
			objMailDTO.setStrAsunto("Registro de Reserva Nº "+strCodigo);
			objMailDTO.setStrPara(objUsuarioDTO.getEmail());
			objMailDTO.setStrMensaje("Estimado(a) "+objUsuarioDTO.getNombre()+", usted acaba de reservar una cita en Elisas's SPA, por favor acercar a el dia " +
					session.get("piker_").toString()+" de "+horaIni+" a "+horaFin+".<br> Muchas gracias");
			
			JMSQueueSender objJmsQueueSender = new JMSQueueSender();
			
					
			objJmsQueueSender.enviaMensaje(UtilWebServiceSPA.JMS_USER , 
											UtilWebServiceSPA.JMS_PASS  ,
											UtilWebServiceSPA.JMS_URL, 
											UtilWebServiceSPA.JMS_QUEUE_NAME, 
											objMailDTO);	
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
	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int idServicio) {
		id_servicio = idServicio;
	}

	public ArrayList<ReservaDTO> getLstReservaDTO() {
		return lstReservaDTO;
	}

	public void setLstReservaDTO(ArrayList<ReservaDTO> lstReservaDTO) {
		this.lstReservaDTO = lstReservaDTO;
	}

	public ArrayList<ArrayList<EmpleadoDTO>> getLstPosiblesEmpleados() {
		return lstPosiblesEmpleados;
	}

	public void setLstPosiblesEmpleados(
			ArrayList<ArrayList<EmpleadoDTO>> lstPosiblesEmpleados) {
		this.lstPosiblesEmpleados = lstPosiblesEmpleados;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getHoraFin() {
		return horaFin;
	}
	
}
