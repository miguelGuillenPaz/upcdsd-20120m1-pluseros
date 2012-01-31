/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public interface IDespachadorEmpleadoServicio {
	
	public int RegistrarEmpleadoServicio(EmpleadoServicioDTO empserv);
	public int ModificarEmpleadoServicio(EmpleadoServicioDTO empserv);
	public int EliminarEmpleadoServicio(int emp, int serv);
	public EmpleadoServicioDTO buscarEmpleadosxServicio(int servicio);
	public EmpleadoServicioDTO buscarServiciosxEmpleados(int empleado);
	public ArrayList<EmpleadoServicioDTO> obtenerEmpleadoServicios();
	
}
