/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public class ImplServicioMantenimiento implements IServicioMantenimiento {

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.mantenimiento.servicios.IServicioMantenimiento#registrarServicio(pe.edu.upc.srs.mantenimiento.beans.ServicioDTO)
	 */
	@Override
	public int registrarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.mantenimiento.servicios.IServicioMantenimiento#modificarServicio(pe.edu.upc.srs.mantenimiento.beans.ServicioDTO)
	 */
	@Override
	public int modificarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.mantenimiento.servicios.IServicioMantenimiento#eliminarServicio(pe.edu.upc.srs.mantenimiento.beans.ServicioDTO)
	 */
	@Override
	public int eliminarServicio(ServicioDTO servicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.mantenimiento.servicios.IServicioMantenimiento#obtenerServicios()
	 */
	@Override
	public ServicioDTO[] obtenerServicios() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.mantenimiento.servicios.IServicioMantenimiento#ObtenerServicioPorEmpleado(pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO)
	 */
	@Override
	public ServicioDTO[] ObtenerServicioPorEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registarEmpleado(EmpleadoDTO empleado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return 0;
	}


}
