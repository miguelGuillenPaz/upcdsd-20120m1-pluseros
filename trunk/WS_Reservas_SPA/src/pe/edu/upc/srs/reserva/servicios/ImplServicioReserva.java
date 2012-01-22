package pe.edu.upc.srs.reserva.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.reserva.beans.PersonalDTO;
import pe.edu.upc.srs.reserva.beans.ReservaDTO;
import pe.edu.upc.srs.reserva.despachadores.IDespachadorEmpleado;
import pe.edu.upc.srs.reserva.despachadores.IDespachadorReserva;
import pe.edu.upc.srs.reserva.utilitarios.UtilDaoConfig;

public class ImplServicioReserva implements IServicioReserva{

    DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorReserva despachadorReserva = (IDespachadorReserva) fabrica.getDao(IDespachadorReserva.class);
    IDespachadorEmpleado despachadorEmpleado = (IDespachadorEmpleado) fabrica.getDao(IDespachadorEmpleado.class);

    @Override
    public ReservaDTO buscarReserva(String codigo) {
    	return despachadorReserva.buscarReserva(codigo);
    }

    @Override
    public PersonalDTO[] obtenerEmpleadosPorServicio(int servicio) {
        ArrayList<PersonalDTO> empleados = new ArrayList<PersonalDTO>();
        empleados = despachadorEmpleado.obtenerEmpleadosPorServicio(servicio);

        return (PersonalDTO[]) empleados.toArray(new PersonalDTO[empleados.size()]);
    }

    @Override
    public String registrarReserva(ReservaDTO reserva) {
        return despachadorReserva.registrarReserva(reserva);
    }

    @Override
    public int anularReserva(int codigo) {
        return despachadorReserva.anularReserva(codigo);
    }

    @Override
    public ReservaDTO[] obtenerHorariosPorServicio(ReservaDTO reserva) {
        ArrayList<ReservaDTO> horarios = new ArrayList<ReservaDTO>();
        horarios = despachadorReserva.obtenerHorariosPorServicio(reserva);

        return (ReservaDTO[]) horarios.toArray(new ReservaDTO[horarios.size()]);
    }

    @Override
    public ReservaDTO[] obtenerHorariosPorPersonal(int personal) {
        ArrayList<ReservaDTO> horarios = new ArrayList<ReservaDTO>();
        horarios = despachadorReserva.obtenerHorariosPorPersonal(personal);

        return (ReservaDTO[]) horarios.toArray(new ReservaDTO[horarios.size()]);
    }
}