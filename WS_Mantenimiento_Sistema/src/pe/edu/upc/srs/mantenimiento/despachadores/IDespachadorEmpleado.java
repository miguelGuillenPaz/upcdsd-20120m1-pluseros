/**
 * @author Elías García
 */

package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public interface IDespachadorEmpleado {

	public int registrarEmpleado(EmpleadoDTO empleado);
	public int asociarServicio(EmpleadoServicioDTO[] empserv);
	public EmpleadoDTO obtenerEmpleado(int codigo);
	
}
