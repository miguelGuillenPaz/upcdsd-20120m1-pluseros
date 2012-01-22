/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DepartamentoDTO implements Serializable {

	/* Atributos */
	private String id;
    private String nombre;

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

}