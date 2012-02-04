package pe.edu.upc.srs.mantenimiento.servicios;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImplServicio servicio = new ImplServicio();
		ImplEmpleado empleado = new ImplEmpleado();
		int rpta =0;
		ServicioDTO serv = new ServicioDTO();
		////serv.setId(1);
		//serv.setDescripcion("prueba2");
		//rpta= servicio.RegistrarServicio(serv);
		//System.out.println("LA RESPUESTA ES: "+rpta);
		
		//serv.setId(1);
		//serv.setDescripcion("prueba modif");
		//rpta = servicio.ModificarServicio(serv);
		//System.out.println("LA RESPUESTA ES: "+rpta);
		
		//rpta = servicio.EliminarServicio(1);
		
		ServicioDTO[] servicios = servicio.obtenerServicios();
		
		for(ServicioDTO s : servicios){
			System.out.println(s.getDescripcion());
		}
		
		//ArrayList<Empl>
		EmpleadoServicioDTO[] lista = new EmpleadoServicioDTO[1];
		
		EmpleadoServicioDTO es = new EmpleadoServicioDTO();
		es.setId_servicio(2);
		es.setId_empleado(1);
		lista[0] = es;
		empleado.asociarServicio(lista);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
