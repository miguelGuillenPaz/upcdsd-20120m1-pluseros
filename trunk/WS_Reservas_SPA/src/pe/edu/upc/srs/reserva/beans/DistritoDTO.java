/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DistritoDTO implements Serializable{

	/* Atributos */
	private String id;
    private String nombre;
    private ProvinciaDTO provincia;
	
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
	public ProvinciaDTO getProvincia() {
		return provincia;
	}
	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}
    
}
