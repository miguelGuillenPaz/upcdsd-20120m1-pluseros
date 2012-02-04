/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public interface IDespachadorEmpleadoServicio {
	
	public int registrarEmpleadoServicio(EmpleadoServicioDTO empserv);
	public int modificarEmpleadoServicio(EmpleadoServicioDTO empserv);
	public int eliminarEmpleadoServicio(int emp, int serv);
	public EmpleadoServicioDTO buscarEmpleadosxServicio(int servicio);
	public EmpleadoServicioDTO buscarServiciosxEmpleados(int empleado);
	public ArrayList<EmpleadoServicioDTO> obtenerEmpleadoServicios();
	
}
