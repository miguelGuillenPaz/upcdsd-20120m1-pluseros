package pe.edu.upc.srs.navigation.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport{

	private static final long serialVersionUID = 3013386262446827287L;
	
	public String initLogin(){
		Map session = ActionContext.getContext().getSession();
		session.remove("logged");
		return SUCCESS;
	}
	
	public String welcome(){
		return SUCCESS;
	}
	
}
