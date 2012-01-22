/**
 * @author Victor Roncalla
 */

package pe.edu.upc.srs.reserva.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TipoDocumentoDTO implements Serializable{

	/* Atributos */
	private int id;
    private String descripcion;

    /* Métodos de acceso */
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
}