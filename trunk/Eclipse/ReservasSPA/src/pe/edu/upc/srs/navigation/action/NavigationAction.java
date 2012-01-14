package pe.edu.upc.srs.navigation.action;

import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport{

	private static final long serialVersionUID = 3013386262446827287L;
	private String codigo;
	private String[] nombres ;
	//HttpServletRequest request;
	
	public String welcome(){
		return "welcome";
	}
	
	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public String[] getNombres() {
		return nombres;
	}
}
