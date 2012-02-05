package pe.edu.upc.srs.gestion.servicios.servicios;

import pe.edu.upc.srs.gestion.servicios.beans.ClienteDTO;
import pe.edu.upc.srs.gestion.servicios.beans.EmpleadoDTO;
import pe.edu.upc.srs.gestion.servicios.beans.PersonalDTO;
import pe.edu.upc.srs.gestion.servicios.beans.ReservaDTO;
import pe.edu.upc.srs.gestion.servicios.beans.ServicioDTO;
import pe.edu.upc.srs.gestion.servicios.beans.UsuarioDTO;

public interface IGestionServicios {
    /* Operaciones de Autenticación */
    public UsuarioDTO    autenticarUsuario(String usuario,String clave);
    
    /* Operaciones de Reserva */
    public String        registrarReserva(ReservaDTO reserva);
    public int           anularReserva(int codigo);
    public ReservaDTO    buscarReserva(String codigo);
    public PersonalDTO[] obtenerEmpleadosPorServicio(int servicio);
    public ReservaDTO[]  obtenerHorariosPorServicio(ReservaDTO reserva);
    public ReservaDTO[]  obtenerHorariosPorPersonal(int personal);
    
    /* Operaciones de Mantenimiento */
    //
	public int           registrarServicio(ServicioDTO servicio);
	public int           modificarServicio(ServicioDTO servicio);
	public int           eliminarServicio(int codigo);
	public ServicioDTO   buscarServicio(int codigo);
	public ServicioDTO[] obtenerServicios();
	public int           registrarEmpleado(EmpleadoDTO empleado);
	public int           registrarCliente(ClienteDTO cliente);
    /* Operaciones de Mensajería */
}