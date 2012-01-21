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

    @Override
    public Reserva buscarReserva(String codigo) {
        Reserva reserva = null;

        try {
            reserva = (Reserva) queryForObject("buscarReserva", codigo);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return reserva;
    }

    @SuppressWarnings("unchecked")
	@Override
    public ArrayList<Personal> obtenerEmpleadosPorServicio(int servicio) {
        ArrayList<Personal> empleados = null;

        try {
            empleados = new ArrayList<Personal>();
            empleados = (ArrayList<Personal>) queryForList("obtenerEmpleadosPorServicio", servicio);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerEmpleadosPorServicio(): " + excepcion.getMessage());
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
            getSqlMapExecutor().update("sp_anular_reserva", codigo);
            resultado = 1;
        } catch (SQLException e) {
            System.out.println("Error - " + this.getClass().getName() + ".anularReserva(): " + e.getMessage());
            e.printStackTrace();
            resultado = -1;
        }

        return resultado;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Reserva> obtenerHorariosPorServicio(int servicio) {
        ArrayList<Reserva> horarios = new ArrayList<Reserva>();

        try {
            horarios = (ArrayList<Reserva>) queryForList("obtenerEmpleadosPorServicio", servicio);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerEmpleadosPorServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return horarios;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Reserva> obtenerHorariosPorPersonal(int personal) {
        ArrayList<Reserva> horarios = new ArrayList<Reserva>();

        try {
            horarios = (ArrayList<Reserva>) queryForList("obtenerHorariosPorPersonal", personal);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerHorariosPorPersonal(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return horarios;
    }
}