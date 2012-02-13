/**
 * @author Elías García
 */

package pe.edu.upc.srs.reserva.beans;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable{
    
    private static final long serialVersionUID = 6246826969585329348L;

    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private int tipoDocumentoIdentidad;
    private String nroDocumentoIdentidad;
    private String distrito;
    private String codigo;
    private String cargo;
    private String foto;
    private String email;
    private String usuario;
    private String clave;
    private ServicioDTO[] servicios;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public String getDistrito() {
        return distrito;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public ServicioDTO[] getServicios() {
        return servicios;
    }
    public void setServicios(ServicioDTO[] servicios) {
        this.servicios = servicios;
    }
}
