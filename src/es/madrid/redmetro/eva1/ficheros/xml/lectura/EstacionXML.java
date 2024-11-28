/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.lectura;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class EstacionXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int id;
	private String nombre;
	private String direccion;
    @JacksonXmlElementWrapper(useWrapping = true, localName = "accesos")
	private List<AccesoXML> listaAccesos;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the listaAccesos
	 */
	public List<AccesoXML> getListaAccesos() {
		return listaAccesos;
	}
	/**
	 * @param listaAccesos the listaAccesos to set
	 */
	public void setListaAccesos(List<AccesoXML> listaAccesos) {
		this.listaAccesos = listaAccesos;
	}

}
