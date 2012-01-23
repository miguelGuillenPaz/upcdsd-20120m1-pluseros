/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DistritoDTO implements Serializable{

	/* Atributos */
	private String id;
    private String nombre;
    private Provincia provincia;
	
    /* Métodos de acceso */
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
    
}
