package com.cucecommerce.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="pyme_empresa")
public class PymeEmpresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_empresa")
	private int idEmpresa;
	
	@Column(name="razon_social")
	private String razonSocial;
	@Column(name="nombre_empresario")
	private String nombreEmpresario;
	@Column(name="logo_empresa")
	private String logoEmpresa;
	@Column(name="email")
	private String email;
	@Column(name="celular", length=10)
	private String celular;
	@Column(name="usuario")
	private String usuario;
	@Column(name="contrasena")
	private String contrasena;
	@Column(name="codigo_asignado")
	private String codigo_asignado;
	
	@Column(name="permiso")
	private String permiso;
	
	@Column(name="fechaCreacion")
	private Timestamp fechaCreacion;
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreEmpresario() {
		return nombreEmpresario;
	}
	public void setNombreEmpresario(String nombreEmpresario) {
		this.nombreEmpresario = nombreEmpresario;
	}
	public String getLogoEmpresa() {
		return logoEmpresa;
	}
	public void setLogoEmpresa(String logoEmpresa) {
		this.logoEmpresa = logoEmpresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCodigo_asignado() {
		return codigo_asignado;
	}
	public void setCodigo_asignado(String codigo_asignado) {
		this.codigo_asignado = codigo_asignado;
	}
	
	
	
	
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	@Override
	public String toString() {
		return "PymeEmpresa [idEmpresa=" + idEmpresa + ", razonSocial=" + razonSocial + ", nombreEmpresario="
				+ nombreEmpresario + ", logoEmpresa=" + logoEmpresa + ", email=" + email + ", celular=" + celular
				+ ", usuario=" + usuario + ", contrasena=" + contrasena + ", codigo_asignado=" + codigo_asignado
				+ ", permiso=" + permiso + ", fechaCreacion=" + fechaCreacion + "]";
	}

	
	
}
