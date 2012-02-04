/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public interface IDespachadorServicio {
	
	public int registrarServicio(ServicioDTO servicio);
	public int modificarServicio(ServicioDTO servicio);
	public int eliminarServicio(int codigo);
	public ServicioDTO buscarServicio(int codigo);
	public ArrayList<ServicioDTO> obtenerServicios();
	
}
