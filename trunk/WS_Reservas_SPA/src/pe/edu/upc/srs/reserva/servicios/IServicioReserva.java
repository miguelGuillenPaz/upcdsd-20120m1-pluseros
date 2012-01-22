/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.servicios;

import pe.edu.upc.srs.reserva.beans.PersonalDTO;
import pe.edu.upc.srs.reserva.beans.ReservaDTO;

public interface IServicioReserva {
    public String registrarReserva(ReservaDTO reserva);
    public int anularReserva(int codigo);
    public ReservaDTO buscarReserva(String codigo);
    public PersonalDTO[] obtenerEmpleadosPorServicio(int servicio);
    public ReservaDTO[] obtenerHorariosPorServicio(ReservaDTO reserva);
    public ReservaDTO[] obtenerHorariosPorPersonal(int personal);
}