/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;

public interface IServicioUbigeo {

    public DepartamentoDTO[] listarDepartamentos();
    public ProvinciaDTO[] listarProvincias(String idDepartamento);
    public DistritoDTO[] listarDistritos(String idProvincia);
}
