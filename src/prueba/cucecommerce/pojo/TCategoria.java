package prueba.cucecommerce.pojo;

import java.io.Serializable;

public class TCategoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nombre;
	private boolean visible;
	private int categoria_superior;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getCategoria_superior() {
		return categoria_superior;
	}
	public void setCategoria_superior(int categoria_superior) {
		this.categoria_superior = categoria_superior;
	}
	@Override
	public String toString() {
		return "TCategoria [codigo=" + codigo + ", nombre=" + nombre + ", visible=" + visible + ", categoria_superior="
				+ categoria_superior + "]";
	}	

}
