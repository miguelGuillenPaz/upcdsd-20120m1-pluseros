/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.seguridad.action;

import java.util.Map;

import pe.edu.upc.srs.reservas.servicios.ImplReservaService;
import pe.edu.upc.srs.seguridad.servicios.ImplSeguridadService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -3910745312163339486L;
	private String usuario;
	private String clave;
	private String strMensaje;
	
	@SuppressWarnings("unchecked")
	public String login(){
		ImplSeguridadService objImplSeguridadService = new ImplSeguridadService();
		Map session = ActionContext.getContext().getSession();
		System.out.println("LOGIN INGRESADO: "+usuario);
		System.out.println("CLAVE INGRESADO: "+clave);
		
		//objImplSeguridadService.autenticarCliente(usuario, clave);
		
		if(session.get("logged") != null &&
			session.get("logged").equals(true)){
			return SUCCESS;
		}else{
			if(!usuario.equals("")){
				if(!clave.equals("")){
					if(usuario.equals("alderfg") &&
						clave.equals("clave")){
						
						session.put("logged","1");
						
						return SUCCESS;
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
	
}
