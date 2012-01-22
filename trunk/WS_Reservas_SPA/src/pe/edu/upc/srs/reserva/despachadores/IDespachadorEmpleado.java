/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.PersonalDTO;

public interface IDespachadorEmpleado {
    public ArrayList<PersonalDTO> obtenerEmpleadosPorServicio(int servicio);
}