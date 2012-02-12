/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.reserva.beans.ReservaDTO;

public interface IDespachadorReserva {
    public String registrarReserva(ReservaDTO reserva);
    public int anularReserva(int codigo);
    public ReservaDTO buscarReserva(String codigo);
    public ArrayList<ReservaDTO> obtenerHorariosDisponibles(int idServicio, String dia, String mes, String anio);

}