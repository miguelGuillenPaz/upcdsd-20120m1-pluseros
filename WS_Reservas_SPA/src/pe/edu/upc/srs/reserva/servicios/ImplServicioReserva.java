package pe.edu.upc.srs.reserva.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.despachadores.IDespachadorReserva;
import pe.edu.upc.srs.reserva.utilitarios.UtilDaoConfig;

public class ImplServicioReserva implements IServicioReserva{

    DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorReserva despachadorReserva = (IDespachadorReserva) fabrica.getDao(IDespachadorReserva.class);

    @Override
    public Reserva buscarReserva(String codigo) {
        return null;
    }

    @Override
    public Personal[] obtenerEmpleadosPorServicio(int servicio) {
        ArrayList<Personal> empleados = new ArrayList<Personal>();
        empleados = despachadorReserva.obtenerEmpleadosPorServicio(servicio);

        return (Personal[]) empleados.toArray(new Personal[empleados.size()]);
    }

    @Override
    public int registrarReserva(Reserva reserva) {
        return despachadorReserva.registrarReserva(reserva);
    }

    @Override
    public int anularReserva(int codigo) {
        return despachadorReserva.anularReserva(codigo);
    }

    @Override
    public Reserva[] obtenerHorariosPorServicio(int servicio) {
        ArrayList<Reserva> horarios = new ArrayList<Reserva>();
        horarios = despachadorReserva.obtenerHorariosPorServicio(servicio);

        return (Reserva[]) horarios.toArray(new Reserva[horarios.size()]);
    }

    @Override
    public Reserva[] obtenerHorariosPorPersonal(int personal) {
        ArrayList<Reserva> horarios = new ArrayList<Reserva>();
        horarios = despachadorReserva.obtenerHorariosPorServicio(personal);

        return (Reserva[]) horarios.toArray(new Reserva[horarios.size()]);
    }
}