/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.navigation.action;

import java.util.ArrayList;
import java.util.Map;

import pe.edu.upc.srs.reservas.bean.DepartamentoDTO;
import pe.edu.upc.srs.reservas.servicios.ImplReservaService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport{

	private static final long serialVersionUID = 3013386262446827287L;
	
	public String initLogin(){
		
		Map session = ActionContext.getContext().getSession();
		ImplReservaService objImplReservaService = new ImplReservaService();
		
		ArrayList<DepartamentoDTO> lstDepartamentoDTO = new ArrayList<DepartamentoDTO>();
		DepartamentoDTO objDepartamentoDTO = new DepartamentoDTO();
		objDepartamentoDTO.setId("0");
		objDepartamentoDTO.setNombre("Seleccione");
		lstDepartamentoDTO.add(objDepartamentoDTO);
		lstDepartamentoDTO.addAll(objImplReservaService.listarDepartamentos());
		session.put("lstDepartamentoDTO",lstDepartamentoDTO);
		
		return SUCCESS;
	}
	
	public String welcome(){
		return SUCCESS;
	}
	
}
