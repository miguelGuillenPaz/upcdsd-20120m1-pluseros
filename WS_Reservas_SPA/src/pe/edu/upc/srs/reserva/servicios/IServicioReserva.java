package pe.edu.upc.srs.reserva.servicios;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Servicio;

public interface IServicioReserva {
    public ArrayList<Servicio> obtenerServicios();
    public ArrayList<Personal> obtenerEmpleados();
    public ArrayList<Servicio> obtenerEmpleadosPorServicio(Servicio servicio);

}
