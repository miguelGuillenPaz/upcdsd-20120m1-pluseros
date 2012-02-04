/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public class ImplServicioMantenimiento implements IServicioMantenimiento {
	IServicioCliente interfazCliente;
	IServicioEmpleado interfazEmpleado;
	IServicioServicio interfazServicio;	

	@Override
	public int registrarServicio(ServicioDTO servicio) {
		return interfazServicio.registrarServicio(servicio);
	}

	@Override
	public int modificarServicio(ServicioDTO servicio) {
		return interfazServicio.modificarServicio(servicio);
	}

	@Override
	public int eliminarServicio(int codigo) {
		return interfazServicio.eliminarServicio(codigo);
	}

	@Override
	public ServicioDTO[] obtenerServicios() {
		return interfazServicio.obtenerServicios();
	}

	@Override
	public ServicioDTO buscarServicio(int codigo) {
		return interfazServicio.buscarServicio(codigo);
	}

	@Override
	public int registarEmpleado(EmpleadoDTO empleado) {
		return interfazEmpleado.registrarEmpleado(empleado);
	}

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		return interfazCliente.registrarCliente(cliente);
	}

}
