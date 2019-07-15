package com.cucecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_producto")
public class TProducto {

	@Id
	@GeneratedValue
	private int webid;
	private String nombre;
	private float precio;
	private float precio_nuevo;
	private int stock;
	private boolean nuevo;
	private boolean recomendado;
	private String descripcion;
	private boolean visible;
	private int codigo_cat;
	private int id_empresa;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	
	public int getWebid() {
		return webid;
	}
	public void setWebid(int webid) {
		this.webid = webid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getPrecio_nuevo() {
		return precio_nuevo;
	}
	public void setPrecio_nuevo(float precio_nuevo) {
		this.precio_nuevo = precio_nuevo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isNuevo() {
		return nuevo;
	}
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	public boolean isRecomendado() {
		return recomendado;
	}
	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getCodigo_cat() {
		return codigo_cat;
	}
	public void setCodigo_cat(int codigo_cat) {
		this.codigo_cat = codigo_cat;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg5() {
		return img5;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	@Override
	public String toString() {
		return "TProducto [webid=" + webid + ", nombre=" + nombre + ", precio=" + precio + ", precio_nuevo="
				+ precio_nuevo + ", stock=" + stock + ", nuevo=" + nuevo + ", recomendado=" + recomendado
				+ ", descripcion=" + descripcion + ", visible=" + visible + ", codigo_cat=" + codigo_cat
				+ ", id_empresa=" + id_empresa + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", img4="
				+ img4 + ", img5=" + img5 + "]";
	}
	
	
	
}
