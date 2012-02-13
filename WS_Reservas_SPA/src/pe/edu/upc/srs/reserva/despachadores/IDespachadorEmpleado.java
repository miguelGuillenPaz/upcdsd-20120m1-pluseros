/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.EmpleadoDTO;

public interface IDespachadorEmpleado {
    public ArrayList<EmpleadoDTO> obtenerEmpleadosDisponibles(int idServicio, String dia, String mes, String anio, String horaInicio, String horaFin);

}