/**
 * 
 */
package es.madrid.redmetro.inm.ficheros.xml.lectura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class AccesoXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int idAcceso;
	private String nombre;
	private int acceso_discapacidad;
	@Override
	public String toString() {
		return "AccesoXML [idAcceso=" + idAcceso + ", nombre=" + nombre + ", acceso_dicapacidad=" + acceso_discapacidad
				+ "]";
	}
	/**
	 * @return the idAcceso
	 */
	public int getIdAcceso() {
		return idAcceso;
	}
	/**
	 * @param idAcceso the idAcceso to set
	 */
	public void setIdAcceso(int idAcceso) {
		this.idAcceso = idAcceso;
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
	 * @return the acceso_discapacidad
	 */
	public int getAcceso_discapacidad() {
		return acceso_discapacidad;
	}
	/**
	 * @param acceso_discapacidad the acceso_discapacidad to set
	 */
	public void setAcceso_discapacidad(int acceso_discapacidad) {
		this.acceso_discapacidad = acceso_discapacidad;
	}
}
