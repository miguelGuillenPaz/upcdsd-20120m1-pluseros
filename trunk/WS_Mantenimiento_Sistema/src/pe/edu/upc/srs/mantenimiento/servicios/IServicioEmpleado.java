/**
 * @author El�as Garc�a
 */

package pe.edu.upc.srs.mantenimiento.servicios;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public interface IServicioEmpleado {
	public int registrarEmpleado(EmpleadoDTO empleado);
	public int asociarServicio(ArrayList<EmpleadoServicioDTO> empserv);
}
