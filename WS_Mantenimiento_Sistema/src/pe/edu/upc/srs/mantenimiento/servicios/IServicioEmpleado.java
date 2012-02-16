/**
 * @author Elías García
 */

package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;

public interface IServicioEmpleado {
	public int registrarEmpleado(EmpleadoDTO empleado);
	public int asociarServicio(EmpleadoServicioDTO[] empserv);
}
