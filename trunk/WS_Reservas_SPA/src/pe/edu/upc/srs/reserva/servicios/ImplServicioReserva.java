package pe.edu.upc.srs.reserva.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.reserva.beans.EmpleadoDTO;
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
    public String registrarReserva(ReservaDTO reserva) {
        return despachadorReserva.registrarReserva(reserva);
    }

    @Override
    public int anularReserva(int codigo) {
        return despachadorReserva.anularReserva(codigo);
    }

    @Override
    public ReservaDTO[] obtenerHorariosDisponibles(int idServicio, String dia, String mes, String anio) {
        ArrayList<ReservaDTO> horarios = new ArrayList<ReservaDTO>();
        horarios = despachadorReserva.obtenerHorariosDisponibles(idServicio, dia, mes, anio);

        return (ReservaDTO[]) horarios.toArray(new ReservaDTO[horarios.size()]);
    }

    @Override
    public EmpleadoDTO[] obtenerEmpleadosDisponibles(int idServicio, String dia, String mes, String anio, String horaInicio, String horaFin) {
        ArrayList<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
        empleados = despachadorEmpleado.obtenerEmpleadosDisponibles(idServicio, dia, mes, anio, horaInicio, horaFin);

        return (EmpleadoDTO[]) empleados.toArray(new EmpleadoDTO[empleados.size()]);
	}
}