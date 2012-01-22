package pe.edu.upc.srs.gestion.servicios.servicios;

import pe.edu.upc.srs.gestion.servicios.beans.ClienteDTO;
import pe.edu.upc.srs.gestion.servicios.beans.PersonalDTO;
import pe.edu.upc.srs.gestion.servicios.beans.ReservaDTO;

public interface IGestionServicios {
    /* Operaciones de Autenticación */
    public ClienteDTO    autenticarCliente(String strUsuario,String strClave);
    /* Operaciones de Reserva */
    public String     registrarReserva(ReservaDTO reserva);
    public int        anularReserva(int codigo);
    public ReservaDTO    buscarReserva(String codigo);
    public PersonalDTO[] obtenerEmpleadosPorServicio(int servicio);
    public ReservaDTO[]  obtenerHorariosPorServicio(ReservaDTO reserva);
    public ReservaDTO[]  obtenerHorariosPorPersonal(int personal);
    /* Operaciones de Mantenimiento */
}