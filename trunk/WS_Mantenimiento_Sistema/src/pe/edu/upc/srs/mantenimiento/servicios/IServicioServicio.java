/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.*;

public interface IServicioServicio {
	
	public int RegistrarServicio(ServicioDTO servicio);
	public int ModificarServicio(ServicioDTO servicio);
	public int EliminarServicio(int codigo);
	public ServicioDTO buscarServicio(int codigo);
	public ServicioDTO[] obtenerServicios();
	
}
