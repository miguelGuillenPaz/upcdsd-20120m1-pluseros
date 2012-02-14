/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.seguridad.action;

import java.util.ArrayList;
import java.util.Map;

import pe.edu.upc.srs.reservas.bean.DepartamentoDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.seguridad.bean.UsuarioDTO;
import pe.edu.upc.srs.seguridad.servicios.ImplSeguridadService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -3910745312163339486L;
	private String usuario;
	private String clave;
	private String strMensaje;
	private UsuarioDTO objUsuarioDTO;
	
	@SuppressWarnings("unchecked")
	public String login(){
		ImplSeguridadService objImplSeguridadService = new ImplSeguridadService();
		
		Map session = ActionContext.getContext().getSession();
		
		if(session.get("logged") != null &&
			session.get("logged").equals(true)){
			return SUCCESS;
		}else{
			if(!usuario.equals("")){
				if(!clave.equals("")){
					objUsuarioDTO = objImplSeguridadService.autenticarCliente(usuario, clave);
					if(objUsuarioDTO != null){
						if(objUsuarioDTO.getEstado() == 1){
							session.put("logged","1");
							session.put("objUsuarioDTO",objUsuarioDTO);
							return SUCCESS;							
						}else{
							strMensaje = "El usuario no se encuentra habilitado.";
							return ERROR;
						}
					}else{
						strMensaje = "Verifique usuario y clave.";
						return ERROR;
					}	
				}else{
					strMensaje = "Ingrese la clave.";
					return ERROR;
				}
			}else{
				strMensaje = "Ingrese el usuario.";
				return ERROR;
			}
		}

	}

	@SuppressWarnings("unchecked")
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("logged");
		session.put("logged",0);
		session.remove("objUsuarioDTO");
		return SUCCESS;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setStrMensaje(String strMensaje) {
		this.strMensaje = strMensaje;
	}

	public String getStrMensaje() {
		return strMensaje;
	}

	public void setObjUsuarioDTO(UsuarioDTO objUsuarioDTO) {
		this.objUsuarioDTO = objUsuarioDTO;
	}

	public UsuarioDTO getObjUsuarioDTO() {
		return objUsuarioDTO;
	}
	
}
