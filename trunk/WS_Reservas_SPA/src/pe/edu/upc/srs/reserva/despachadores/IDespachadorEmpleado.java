/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;

public interface IDespachadorEmpleado {
    public ArrayList<Personal> obtenerEmpleadosPorServicio(int servicio);
}