/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;
import pe.edu.upc.srs.mantenimiento.servicios.ArrayList;

public interface IDespachadorServicio {
	
	public int RegistrarServicio(ServicioDTO servicio);
	public int ModificarServicio(ServicioDTO servicio);
	public int EliminarServicio(ServicioDTO servicio);
	public ArrayList<ServicioDTO> obtenerServicios();
	public ArrayList<ServicioDTO> ObtenerServicioPorEmpleado(EmpleadoDTO empleado); 

}
