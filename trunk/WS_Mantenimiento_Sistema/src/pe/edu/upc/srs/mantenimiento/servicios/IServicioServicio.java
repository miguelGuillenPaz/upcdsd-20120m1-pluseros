/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.*;

public interface IServicioServicio {
	
	public int registrarServicio(ServicioDTO servicio);
	public int modificarServicio(ServicioDTO servicio);
	public int eliminarServicio(int codigo);
	public ServicioDTO buscarServicio(int codigo);
	public ServicioDTO[] obtenerServicios();
	
}
