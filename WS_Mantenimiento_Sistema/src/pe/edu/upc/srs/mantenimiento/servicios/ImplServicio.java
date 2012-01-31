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
	public int RegistrarServicio(ServicioDTO servicio) {
		return despachadorServicio.RegistrarServicio(servicio);
	}

	@Override
	public int ModificarServicio(ServicioDTO servicio) {
		return despachadorServicio.ModificarServicio(servicio);
	}

	@Override
	public int EliminarServicio(int codigo) {
		return despachadorServicio.EliminarServicio(codigo);
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
