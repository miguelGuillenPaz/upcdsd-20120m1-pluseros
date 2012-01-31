/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public interface IDespachadorServicio {
	
	public int RegistrarServicio(ServicioDTO servicio);
	public int ModificarServicio(ServicioDTO servicio);
	public int EliminarServicio(int codigo);
	public ServicioDTO buscarServicio(int codigo);
	public ArrayList<ServicioDTO> obtenerServicios();
	
}
