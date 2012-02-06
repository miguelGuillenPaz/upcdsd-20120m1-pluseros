/**
 * @author Victor Roncalla
 */
package pe.edu.upc.srs.reserva.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClienteDTO implements Serializable {

    /* Atributos */
    private int id;
    private String codigo;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccion;
    private String telefono;
    private String email;
    private int tipoDocumentoIdentidad;
    private String nroDocumentoIdentidad;
    private String usuario;
    private String clave;
    private String rutaFoto;
    private DistritoDTO distrito;

    /* Métodos de acceso */
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}
	public void setTipoDocumentoIdentidad(int tipoDocumentoIdentidad) {
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}
	public String getNroDocumentoIdentidad() {
		return nroDocumentoIdentidad;
	}
	public void setNroDocumentoIdentidad(String nroDocumentoIdentidad) {
		this.nroDocumentoIdentidad = nroDocumentoIdentidad;
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
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	public DistritoDTO getDistrito() {
		return distrito;
	}
	public void setDistrito(DistritoDTO distrito) {
		this.distrito = distrito;
	}
}
