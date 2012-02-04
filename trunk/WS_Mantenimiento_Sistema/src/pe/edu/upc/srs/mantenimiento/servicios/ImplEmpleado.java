package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.IDespachadorEmpleado;
import pe.edu.upc.srs.mantenimiento.utilitarios.UtilDaoConfig;

import com.ibatis.dao.client.DaoManager;

public class ImplEmpleado {

	DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorEmpleado despachadorEmpleado = (IDespachadorEmpleado) fabrica.getDao(IDespachadorEmpleado.class);
    
	public int registrarEmpleado(EmpleadoDTO empleado) {
		return despachadorEmpleado.registrarEmpleado(empleado);

	}

}
