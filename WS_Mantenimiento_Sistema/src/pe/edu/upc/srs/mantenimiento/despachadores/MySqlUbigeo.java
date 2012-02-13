/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.mantenimiento.despachadores;

import java.util.ArrayList;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import pe.edu.upc.srs.mantenimiento.beans.DepartamentoDTO;
import pe.edu.upc.srs.mantenimiento.beans.DistritoDTO;
import pe.edu.upc.srs.mantenimiento.beans.ProvinciaDTO;

public class MySqlUbigeo extends SqlMapDaoTemplate implements IDespachadorUbigeo{

    public MySqlUbigeo(DaoManager daoManager) {
        super(daoManager);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<DepartamentoDTO> listarDepartamentos() {
        ArrayList<DepartamentoDTO> departamentos = new ArrayList<DepartamentoDTO>();

        try {
        	departamentos = (ArrayList<DepartamentoDTO>) queryForList("sp_listar_departamentos","");
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarDepartamentos(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return departamentos;
	}

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<ProvinciaDTO> listarProvincias(String idDepartamento) {
        ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();

        try {
            provincias = (ArrayList<ProvinciaDTO>) queryForList("sp_listar_provincias", idDepartamento);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarProvincias(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return provincias;
	}

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<DistritoDTO> listarDistritos(String idProvincia) {
        ArrayList<DistritoDTO> distritos = new ArrayList<DistritoDTO>();

        try {
            distritos = (ArrayList<DistritoDTO>) queryForList("sp_listar_distritos", idProvincia);
        } catch (Exception excepcion) {
            System.out.println("Error - " + this.getClass().getName() + ".listarDistritos(): " + excepcion.getMessage());
            excepcion.printStackTrace();
        }

        return distritos;
	}

}
