/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.servicios;

import java.util.ArrayList;
import pe.edu.upc.srs.reservas.bean.ClienteDTO;
import pe.edu.upc.srs.reservas.bean.DepartamentoDTO;
import pe.edu.upc.srs.reservas.bean.DistritoDTO;
import pe.edu.upc.srs.reservas.bean.EmpleadoDTO;
import pe.edu.upc.srs.reservas.bean.ProvinciaDTO;
import pe.edu.upc.srs.reservas.bean.ReservaDTO;
import pe.edu.upc.srs.reservas.bean.ServicioDTO;

public interface IReservaService {

	public ArrayList<ServicioDTO> obtenerServicios();
	public ReservaDTO buscarReserva(String codigo);
	public int anularReserva(int codigo);
	public int registrarCliente(ClienteDTO cliente);
	
	public ArrayList<DepartamentoDTO> listarDepartamentos();
    public ArrayList<ProvinciaDTO>listarProvincias(String idDepartamento);
    public ArrayList<DistritoDTO> listarDistritos(String idProvincia);
    
    public int registrarEmpleado(EmpleadoDTO empleado);
	
}
