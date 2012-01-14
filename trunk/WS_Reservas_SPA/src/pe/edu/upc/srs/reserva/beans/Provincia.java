/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.beans;

public class Provincia {

	/* Atributos */
	private String id;
    private String nombre;
    private Departamento departamento;
	
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
    


}