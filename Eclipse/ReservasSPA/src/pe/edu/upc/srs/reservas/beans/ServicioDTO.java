package pe.edu.upc.srs.reservas.beans;

import java.io.Serializable;

public class ServicioDTO implements Serializable{
	private static final long serialVersionUID = 6752856113741236688L;
	
	private int id_servicio;
	private String descripcion;
	private double duracion_horas;
	private String imagen;
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int idServicio) {
		id_servicio = idServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getDuracion_horas() {
		return duracion_horas;
	}
	public void setDuracion_horas(double duracionHoras) {
		duracion_horas = duracionHoras;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
