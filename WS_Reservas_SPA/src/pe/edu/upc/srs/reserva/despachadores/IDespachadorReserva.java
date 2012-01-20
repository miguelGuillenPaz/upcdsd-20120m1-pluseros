/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.beans.Servicio;

public interface IDespachadorReserva {
    public ArrayList<Personal> obtenerEmpleadosPorServicio(Servicio servicio);
    public int registrarReserva(Reserva reserva);
    public int anularReserva(Reserva reserva);
}