/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.*;

public interface IEmpleadoServicioServicio {
	
	public int RegistrarEmpleadoServicio(EmpleadoServicioDTO empserv);
	public int ModificarEmpleadoServicio(EmpleadoServicioDTO servicio);
	public int EliminarEmpleadoServicio(int codigo);
	public EmpleadoServicioDTO buscarEmpleadoServicio(int empleado, int servicio);
	public EmpleadoServicioDTO[] obtenerEmpleadoServicios();
	 
}
