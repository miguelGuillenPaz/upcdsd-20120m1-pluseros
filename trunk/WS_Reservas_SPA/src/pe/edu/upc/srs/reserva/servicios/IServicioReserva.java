package pe.edu.upc.srs.reserva.servicios;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.beans.Servicio;

public interface IServicioReserva {
    public Servicio[] obtenerServicios();
    public Personal[] obtenerEmpleadosPorServicio(Servicio servicio);
    public Personal[] obtenerEmpleados();
    public int registrarReserva(Reserva reserva);
    public int anularReserva(Reserva reserva);

}
