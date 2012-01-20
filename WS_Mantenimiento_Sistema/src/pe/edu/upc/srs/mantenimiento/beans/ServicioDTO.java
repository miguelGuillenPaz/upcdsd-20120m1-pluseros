/**
 *@autor : Lizbeth D�az 
 **/
package pe.edu.upc.srs.mantenimiento.beans;

import java.io.Serializable;

public class ServicioDTO implements Serializable{
	
	private static final long serialVersionUID = 6246826969585329348L;

	private int id;
    private String descripcion;
    private double duracion;
    private String rutaImagen;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
