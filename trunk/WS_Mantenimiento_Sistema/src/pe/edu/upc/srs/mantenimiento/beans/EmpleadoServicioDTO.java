/**
 *@autor : Lizbeth Díaz 
 **/
package pe.edu.upc.srs.mantenimiento.beans;

import java.io.Serializable;

public class EmpleadoServicioDTO implements Serializable{
	
	private static final long serialVersionUID = 6246826969585329348L;

	private int id_empleado;
	private int id_servicio;

	
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int idEmpleado) {
		id_empleado = idEmpleado;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
