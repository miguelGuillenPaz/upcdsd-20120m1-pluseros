/**
 *@autor : Victor Roncalla
 **/
package pe.edu.upc.srs.mantenimiento.servicios;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;

import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.IDespachadorUbigeo;
import pe.edu.upc.srs.mantenimiento.utilitarios.UtilDaoConfig;

public class ImplServicioUbigeo implements IServicioUbigeo {

    DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorUbigeo despachadorServicio = (IDespachadorUbigeo) fabrica.getDao(IDespachadorUbigeo.class);

    @Override
    public DepartamentoDTO[] listarDepartamentos() {
        ArrayList<DepartamentoDTO> departamentos = new ArrayList<DepartamentoDTO>();
        departamentos = despachadorServicio.listarDepartamentos();
        return (DepartamentoDTO[]) departamentos.toArray(new DepartamentoDTO[departamentos.size()]);
    }

    @Override
    public ProvinciaDTO[] listarProvincias(String idDepartamento) {
        ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
        provincias = despachadorServicio.listarProvincias(idDepartamento);
        return (ProvinciaDTO[]) provincias.toArray(new ProvinciaDTO[provincias.size()]);
    }

    @Override
    public DistritoDTO[] listarDistritos(String idProvincia) {
        ArrayList<DistritoDTO> distritos = new ArrayList<DistritoDTO>();
        distritos = despachadorServicio.listarDistritos(idProvincia);
        return (DistritoDTO[]) distritos.toArray(new DistritoDTO[distritos.size()]);
    }
}