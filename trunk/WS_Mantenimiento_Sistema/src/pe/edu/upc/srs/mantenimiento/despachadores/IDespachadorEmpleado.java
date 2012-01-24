/**
 * @author Elías García
 */

package pe.edu.upc.srs.mantenimiento.despachadores;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;

public interface IDespachadorEmpleado {

	public int registrarEmpleado(EmpleadoDTO empleado);
	
}
