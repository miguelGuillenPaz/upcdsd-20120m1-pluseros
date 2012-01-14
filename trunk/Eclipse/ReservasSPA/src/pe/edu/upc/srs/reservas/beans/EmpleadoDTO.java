package pe.edu.upc.srs.reservas.beans;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{

	private static final long serialVersionUID = 6246826969585329348L;

	private int id_empleado;
	private String nombre;
	private String ape_pat_empleado;
	private String ape_mat_empleado;
	private String direccion;
	private int tipo_documento_identidad;
	private String nro_documento_identidad;
	private String distrito;
	private String cod_empleado;
	private String cargo;
	private String usuario;
	private String clave;
	private String foto;
	
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int idEmpleado) {
		id_empleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe_pat_empleado() {
		return ape_pat_empleado;
	}
	public void setApe_pat_empleado(String apePatEmpleado) {
		ape_pat_empleado = apePatEmpleado;
	}
	public String getApe_mat_empleado() {
		return ape_mat_empleado;
	}
	public void setApe_mat_empleado(String apeMatEmpleado) {
		ape_mat_empleado = apeMatEmpleado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTipo_documento_identidad() {
		return tipo_documento_identidad;
	}
	public void setTipo_documento_identidad(int tipoDocumentoIdentidad) {
		tipo_documento_identidad = tipoDocumentoIdentidad;
	}
	public String getNro_documento_identidad() {
		return nro_documento_identidad;
	}
	public void setNro_documento_identidad(String nroDocumentoIdentidad) {
		nro_documento_identidad = nroDocumentoIdentidad;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getCod_empleado() {
		return cod_empleado;
	}
	public void setCod_empleado(String codEmpleado) {
		cod_empleado = codEmpleado;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
