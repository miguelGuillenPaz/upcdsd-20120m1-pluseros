/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.beans;

import java.io.Serializable;

public class EmpleadoServicioDTO implements Serializable{
	
	private static final long serialVersionUID = 6246826969585329348L;

	private int id_empleado;
    private int id_codigo;

	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getId_codigo() {
		return id_codigo;
	}

	public void setId_codigo(int id_codigo) {
		this.id_codigo = id_codigo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
