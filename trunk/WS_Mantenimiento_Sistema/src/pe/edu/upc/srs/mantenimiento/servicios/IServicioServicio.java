/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.*;

public interface IServicioServicio {
	
	public int RegistrarServicio(ServicioDTO servicio);
	public int ModificarServicio(ServicioDTO servicio);
	public int EliminarServicio(ServicioDTO servicio);
	public ServicioDTO[] obtenerServicios();
	public ServicioDTO[]  ObtenerServicioPorEmpleado(EmpleadoDTO empleado);
	 
}
