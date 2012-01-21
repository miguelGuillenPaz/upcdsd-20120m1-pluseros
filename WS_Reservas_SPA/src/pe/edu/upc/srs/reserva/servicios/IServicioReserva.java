/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.servicios;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;

public interface IServicioReserva {
    public String registrarReserva(Reserva reserva);
    public int anularReserva(int codigo);
    public Reserva buscarReserva(String codigo);
    public Personal[] obtenerEmpleadosPorServicio(int servicio);
    public Reserva[] obtenerHorariosPorServicio(int servicio);
    public Reserva[] obtenerHorariosPorPersonal(int personal);
}