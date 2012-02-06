/**
 * @author Christian Arias
 */
package pe.edu.upc.srs.seguridad.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable {

    /* Atributos */
    private int id;
    private String usuario;
    private String clave;
    private String nombre;
    private String email;
    private int tipoUsuario;
    private int estado;

    /* Métodos de acceso */
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
