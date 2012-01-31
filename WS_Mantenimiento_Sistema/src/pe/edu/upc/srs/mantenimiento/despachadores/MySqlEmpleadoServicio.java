/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public class MySqlEmpleadoServicio implements IDespachadorEmpleadoServicio {

	@Override
	public int RegistrarEmpleadoServicio(EmpleadoServicioDTO empserv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ModificarEmpleadoServicio(EmpleadoServicioDTO empserv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int EliminarEmpleadoServicio(int emp, int serv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpleadoServicioDTO buscarEmpleadosxServicio(int servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoServicioDTO buscarServiciosxEmpleados(int empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmpleadoServicioDTO> obtenerEmpleadoServicios() {
		// TODO Auto-generated method stub
		return null;
	}


}
