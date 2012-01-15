package pe.edu.upc.srs.reserva.servicios;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Servicio;

public interface IServicioReserva {
    public Servicio[] obtenerServicios();
    public Personal[] obtenerEmpleados();
    public Servicio[] obtenerEmpleadosPorServicio(Servicio servicio);

}
