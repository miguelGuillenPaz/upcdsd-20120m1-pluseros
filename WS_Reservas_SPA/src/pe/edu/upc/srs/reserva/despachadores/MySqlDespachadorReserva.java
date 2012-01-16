/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import pe.edu.upc.srs.reserva.beans.Servicio;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorReserva extends SqlMapDaoTemplate implements IDespachadorReserva {

    public MySqlDespachadorReserva(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Servicio> obtenerServicios() {
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
        servicios = (ArrayList<Servicio>) queryForList("obtenerServicios", null);

        return servicios;
    }

    @Override
    public ArrayList<Personal> obtenerEmpleados() {
    	return null;
    }

    @Override
    public ArrayList<Personal> obtenerEmpleadosPorServicio(Servicio servicio) {
    	return null;
    }

	@Override
	public int registrarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int anularReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}
}