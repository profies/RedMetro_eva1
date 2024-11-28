/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.lectura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class AccesoXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int idAcceso;
	private String nombre;
	@JacksonXmlProperty(localName = "acceso_discapacidad")
	private int accesoDiscapacidad;
	
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
	public int getAccesoDiscapacidad() {
		return accesoDiscapacidad;
	}
	public void setAccesoDiscapacidad(int accesoDiscapacidad) {
		this.accesoDiscapacidad = accesoDiscapacidad;
	}
	@Override
	public String toString() {
		return "AccesoXML [idAcceso=" + idAcceso + ", nombre=" + nombre + ", accesoDiscapacidad=" + accesoDiscapacidad
				+ "]";
	}

}
