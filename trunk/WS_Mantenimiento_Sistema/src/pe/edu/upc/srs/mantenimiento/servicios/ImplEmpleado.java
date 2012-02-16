package pe.edu.upc.srs.mantenimiento.servicios;

import pe.edu.upc.srs.mantenimiento.beans.EmpleadoDTO;
import pe.edu.upc.srs.mantenimiento.beans.EmpleadoServicioDTO;
import pe.edu.upc.srs.mantenimiento.despachadores.IDespachadorEmpleado;
import pe.edu.upc.srs.mantenimiento.utilitarios.UtilDaoConfig;

import com.ibatis.dao.client.DaoManager;

public class ImplEmpleado implements IServicioEmpleado {

	DaoManager fabrica = UtilDaoConfig.obtenerDaoManager();
    IDespachadorEmpleado despachadorEmpleado = (IDespachadorEmpleado) fabrica.getDao(IDespachadorEmpleado.class);
    
	@Override
	public int registrarEmpleado(EmpleadoDTO empleado) {
		return despachadorEmpleado.registrarEmpleado(empleado);
	}

	@Override
	public int asociarServicio(EmpleadoServicioDTO[] empserv) {
		// TODO Auto-generated method stub
		return despachadorEmpleado.asociarServicio(empserv);
	}

}
