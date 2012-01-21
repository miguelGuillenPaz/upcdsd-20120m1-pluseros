/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;

public interface IDespachadorReserva {
    public String registrarReserva(Reserva reserva);
    public int anularReserva(int codigo);
    public Reserva buscarReserva(String codigo);
    public ArrayList<Personal> obtenerEmpleadosPorServicio(int servicio);
    public ArrayList<Reserva> obtenerHorariosPorServicio(int codigo);
    public ArrayList<Reserva> obtenerHorariosPorPersonal(int codigo);
}