/**
 *@autor : Victor Roncalla 
 */
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;

public interface IDespachadorUbigeo {

    public ArrayList<DepartamentoDTO> listarDepartamentos();
    public ArrayList<ProvinciaDTO> listarProvincias(String idDepartamento);
    public ArrayList<DistritoDTO> listarDistritos(String idProvincia);

}
