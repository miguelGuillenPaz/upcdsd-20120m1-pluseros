package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;

public interface IReservaService {

	public ArrayList<ServicioDTO> obtenerServicios();
	
}
