/**
 * @author Elías García
 */

package pe.edu.upc.srs.mantenimiento.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpleadoDTO implements Serializable{
	
	private static final long serialVersionUID = 6246826969585329348L;

	private int id;
	private String codigo;
	private String nombres;
	private String apePatEmp;
	private String apeMatEmp;
	private String tipo_doc_identidad;
	private String nro_doc_identidad;
	private String distrito;
	private String direccion;
	private String cargo;
	private String usuario;
	private String clave;
	private String foto;
	private ArrayList<ServicioDTO> lstServicioDTO;
	
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
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApePatEmp() {
		return apePatEmp;
	}
	public void setApePatEmp(String apePatEmp) {
		this.apePatEmp = apePatEmp;
	}
	public String getApeMatEmp() {
		return apeMatEmp;
	}
	public void setApeMatEmp(String apeMatEmp) {
		this.apeMatEmp = apeMatEmp;
	}
	public String getTipo_doc_identidad() {
		return tipo_doc_identidad;
	}
	public void setTipo_doc_identidad(String tipo_doc_identidad) {
		this.tipo_doc_identidad = tipo_doc_identidad;
	}
	public String getNro_doc_identidad() {
		return nro_doc_identidad;
	}
	public void setNro_doc_identidad(String nro_doc_identidad) {
		this.nro_doc_identidad = nro_doc_identidad;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public ArrayList<ServicioDTO> getLstServicioDTO() {
		return lstServicioDTO;
	}
	public void setLstServicioDTO(ArrayList<ServicioDTO> lstServicioDTO) {
		this.lstServicioDTO = lstServicioDTO;
	}
	
}
