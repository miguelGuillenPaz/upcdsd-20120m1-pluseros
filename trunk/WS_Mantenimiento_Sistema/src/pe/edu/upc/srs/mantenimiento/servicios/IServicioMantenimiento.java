/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.*;

public interface IServicioMantenimiento {
	
	public int registrarServicio(ServicioDTO servicio);
	public int registarEmpleado(EmpleadoDTO empleado);
	public int registrarCliente(ClienteDTO cliente);
	
	public int modificarServicio(ServicioDTO servicio);
	public int eliminarServicio(ServicioDTO servicio);
	public ServicioDTO[] obtenerServicios();
	public ServicioDTO[]  ObtenerServicioPorEmpleado(EmpleadoDTO empleado);
	 
}
