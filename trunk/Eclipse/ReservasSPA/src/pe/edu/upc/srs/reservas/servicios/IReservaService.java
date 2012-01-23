/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;

import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;

public interface IReservaService {

	public ArrayList<ServicioDTO> obtenerServicios();
	public ReservaDTO buscarReserva(String codigo);
	public int anularReserva(int codigo);
	
}
