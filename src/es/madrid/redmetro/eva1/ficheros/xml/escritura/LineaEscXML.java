/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.escritura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class LineaEscXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int id;
	private String nombre_l;
	private ColorEscXML color;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre_l
	 */
	public String getNombre_l() {
		return nombre_l;
	}
	/**
	 * @param nombre_l the nombre_l to set
	 */
	public void setNombre_l(String nombre_l) {
		this.nombre_l = nombre_l;
	}
	/**
	 * @return the color
	 */
	public ColorEscXML getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(ColorEscXML color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "LineaEscXML [id=" + id + ", nombre_l=" + nombre_l + ", color=" + color + "]";
	}
}
