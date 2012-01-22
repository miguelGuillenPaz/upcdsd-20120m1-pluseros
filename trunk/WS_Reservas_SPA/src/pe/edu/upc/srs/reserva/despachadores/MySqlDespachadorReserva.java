/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.ReservaDTO;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class MySqlDespachadorReserva extends SqlMapDaoTemplate implements IDespachadorReserva {

    public MySqlDespachadorReserva(DaoManager daoManager) {
        super(daoManager);
    }

    @Override
    public ReservaDTO buscarReserva(String codigo) {
        ReservaDTO reserva = null;

        try {
            reserva = (ReservaDTO) queryForObject("buscarReserva", codigo);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".buscarReserva(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return reserva;
    }

    @Override
    public String registrarReserva(ReservaDTO reserva) {
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
    public ArrayList<ReservaDTO> obtenerHorariosPorServicio(ReservaDTO reserva) {
        ArrayList<ReservaDTO> horarios = new ArrayList<ReservaDTO>();

        try {
            horarios = (ArrayList<ReservaDTO>) queryForList("obtenerEmpleadosPorServicio", reserva);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerEmpleadosPorServicio(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return horarios;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<ReservaDTO> obtenerHorariosPorPersonal(int personal) {
        ArrayList<ReservaDTO> horarios = new ArrayList<ReservaDTO>();

        try {
            horarios = (ArrayList<ReservaDTO>) queryForList("obtenerHorariosPorPersonal", personal);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".obtenerHorariosPorPersonal(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return horarios;
    }
}