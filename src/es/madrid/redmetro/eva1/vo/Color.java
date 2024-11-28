/**
 * 
 */
package es.madrid.redmetro.eva1.vo;

import java.io.Serializable;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class Color implements Serializable{
	private static final long serialVersionUID = 3295865115889018033L;

	private int codigoColor;
	private String nombre;
	private String codigoHexadecimal;
	private Linea linea;
	/**
	 * @return the codigoColor
	 */
	public int getCodigoColor() {
		return codigoColor;
	}
	/**
	 * @param codigoColor the codigoColor to set
	 */
	public void setCodigoColor(int codigoColor) {
		this.codigoColor = codigoColor;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the cod_hexadecimal
	 */
	public String getCodigoHexadecimal() {
		return codigoHexadecimal;
	}
	/**
	 * @param cod_hexadecimal the cod_hexadecimal to set
	 */
	public void setCod_hexadecimal(String cod_hexadecimal) {
		this.codigoHexadecimal = cod_hexadecimal;
	}
	/**
	 * @return the linea
	 */
	public Linea getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	@Override
	public String toString() {
		return "Color [codigoColor=" + codigoColor + ", nombre=" + nombre + ", cod_hexadecimal="
				+ codigoHexadecimal + ", linea=" + linea + "]";
	}
	
}
