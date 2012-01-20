/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public class MySqlServicio implements IDespachadorServicio {

	@Override
	public int RegistrarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ModificarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int EliminarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ServicioDTO> obtenerServicios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ServicioDTO> ObtenerServicioPorEmpleado(
			EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return null;
	}

}
