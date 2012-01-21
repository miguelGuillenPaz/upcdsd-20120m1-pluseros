/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.Personal;
import pe.edu.upc.srs.reserva.beans.Reserva;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorReserva extends SqlMapDaoTemplate implements IDespachadorReserva {

    public MySqlDespachadorReserva(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
	@Override
    public ArrayList<Personal> obtenerEmpleadosPorServicio(int servicio) {
        ArrayList<Personal> empleados = null;

        try {
            empleados = new ArrayList<Personal>();
            empleados = (ArrayList<Personal>) queryForList("obtenerEmpleadosPorServicio", servicio);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }
        

        return empleados;
    }

    @Override
    public String registrarReserva(Reserva reserva) {
        String resultado = "";

        try {
            getSqlMapExecutor().insert("sp_registrar_reserva", reserva);
            resultado = reserva.getCodigo();
        } catch (SQLException excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
            resultado = "error";
        }

        return resultado;
    }

    @Override
    public int anularReserva(int codigo) {
        int resultado = 0;

        try {
            getSqlMapExecutor().insert("sp_anular_reserva", codigo);
            resultado = 1;
        } catch (SQLException e) {
            System.out.println("Error - " + this.getClass().getName() + ".registrarReserva(): " + e.getMessage());
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;
    }


	@Override
	public ArrayList<Reserva> obtenerHorariosPorServicio(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.reserva.despachadores.IDespachadorReserva#obtenerHorariosPorPersonal(int)
	 */
	@Override
	public ArrayList<Reserva> obtenerHorariosPorPersonal(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see pe.edu.upc.srs.reserva.despachadores.IDespachadorReserva#buscarReserva(java.lang.String)
	 */
	@Override
	public Reserva buscarReserva(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
}