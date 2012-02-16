/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;
import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public class ImplServicioMantenimiento implements IServicioMantenimiento {
	ImplCliente interfazCliente = new ImplCliente(); 
	ImplEmpleado interfazEmpleado = new ImplEmpleado(); 
	ImplServicio interfazServicio = new ImplServicio();
	IServicioUbigeo interfazUbigeo = new ImplServicioUbigeo();

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
	public int registrarEmpleado(EmpleadoDTO empleado) {
		return interfazEmpleado.registrarEmpleado(empleado);
	}

	@Override
	public int registrarCliente(ClienteDTO cliente) {
		return interfazCliente.registrarCliente(cliente);
	}

	@Override
	public DepartamentoDTO[] listarDepartamentos() {
		return interfazUbigeo.listarDepartamentos();
	}

	@Override
	public ProvinciaDTO[] listarProvincias(String idDepartamento) {
		return interfazUbigeo.listarProvincias(idDepartamento);
	}

	@Override
	public DistritoDTO[] listarDistritos(String idProvincia) {
		return interfazUbigeo.listarDistritos(idProvincia);
	}

}
