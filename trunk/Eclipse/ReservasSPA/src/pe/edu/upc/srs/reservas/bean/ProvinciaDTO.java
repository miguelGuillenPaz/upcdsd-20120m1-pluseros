/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.reservas.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProvinciaDTO implements Serializable{

	/* Atributos */
	private String id;
    private String nombre;
    private DepartamentoDTO departamento;
	
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
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
    


}