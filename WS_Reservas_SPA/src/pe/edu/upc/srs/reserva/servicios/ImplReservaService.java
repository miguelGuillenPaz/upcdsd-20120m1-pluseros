package pe.edu.upc.srs.reserva.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.beans.Servicio;
import pe.edu.upc.srs.reserva.despachadores.IDespachadorReserva;
import pe.edu.upc.srs.reserva.utilitarios.UtilDaoConfig;

public class ImplReservaService implements IServicioReserva{

    DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorReserva despachadorReserva = (IDespachadorReserva) fabrica.getDao(IDespachadorReserva.class);

    @Override
    public Servicio[] obtenerServicios() {
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        servicios = despachadorReserva.obtenerServicios();

        return (Servicio[]) servicios.toArray(new Servicio[servicios.size()]);
    }

    @Override
    public Personal[] obtenerEmpleados() {
        return null;
    }

    @Override
    public Personal[] obtenerEmpleadosPorServicio(Servicio servicio) {
        return null;
    }

	@Override
	public int registrarReserva(Reserva reserva) {
		return 0;
	}

	@Override
	public int anularReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}
}