/**
 * 
 */
package es.madrid.redmetro.inm.ficheros.xml.escritura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class ColorEscXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int idColor;
	@JacksonXmlProperty(isAttribute = true, localName = "cod_hex")
	private String codigoHexadecimal;
	private String descripcion;
	/**
	 * @return the idColor
	 */
	public int getIdColor() {
		return idColor;
	}
	/**
	 * @param idColor the idColor to set
	 */
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	/**
	 * @return the codigoHexadecimal
	 */
	public String getCodigoHexadecimal() {
		return codigoHexadecimal;
	}
	/**
	 * @param codigoHexadecimal the codigoHexadecimal to set
	 */
	public void setCodigoHexadecimal(String codigoHexadecimal) {
		this.codigoHexadecimal = codigoHexadecimal;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "ColorEscXML [idColor=" + idColor + ", codigoHexadecimal=" + codigoHexadecimal + ", descripcion="
				+ descripcion + "]";
	}
}
