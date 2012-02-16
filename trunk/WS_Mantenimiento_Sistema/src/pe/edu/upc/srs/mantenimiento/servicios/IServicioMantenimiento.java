/**
 *@autor : Lizbeth Díaz 
 */
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.ClienteDTO;
import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;
import pe.edu.upc.srs.mantenimiento.beans.ServicioDTO;

public interface IServicioMantenimiento {

    public int registrarServicio(ServicioDTO servicio);
    public int registrarEmpleado(EmpleadoDTO empleado);
    public int registrarCliente(ClienteDTO cliente);
    public int modificarServicio(ServicioDTO servicio);
    public int eliminarServicio(int codigo);
    public ServicioDTO buscarServicio(int codigo);
    public ServicioDTO[] obtenerServicios();
    public DepartamentoDTO[] listarDepartamentos();
    public ProvinciaDTO[] listarProvincias(String idDepartamento);
    public DistritoDTO[] listarDistritos(String idProvincia);
}
