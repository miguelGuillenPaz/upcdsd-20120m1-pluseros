/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.IDespachadorServicio;
import pe.edu.upc.srs.mantenimiento.utilitarios.UtilDaoConfig;

public class ImplServicio implements IServicioServicio {
	
	DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
	IDespachadorServicio despachadorServicio = (IDespachadorServicio) fabrica.getDao(IDespachadorServicio.class);

	@Override
	public int registrarServicio(ServicioDTO servicio) {
		return despachadorServicio.registrarServicio(servicio);
	}

	@Override
	public int modificarServicio(ServicioDTO servicio) {
		return despachadorServicio.modificarServicio(servicio);
	}

	@Override
	public int eliminarServicio(int codigo) {
		return despachadorServicio.eliminarServicio(codigo);
	}

	@Override
	public ServicioDTO buscarServicio(int codigo) {
		return despachadorServicio.buscarServicio(codigo);
	}

	@Override
	public ServicioDTO[] obtenerServicios() {
		ArrayList<ServicioDTO> servicio = new ArrayList<ServicioDTO>();
		servicio =despachadorServicio.obtenerServicios();
		return (ServicioDTO[]) servicio.toArray(new ServicioDTO[servicio.size()]);
	}

}
