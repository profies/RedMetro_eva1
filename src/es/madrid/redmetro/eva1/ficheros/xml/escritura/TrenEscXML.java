/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.escritura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class TrenEscXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int id;
	private String modelo;
	private String empresa_constructora;
	private int anyo_incorporacion;
	private int cod_cochera;
	private LineaEscXML linea;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the empresa_constructora
	 */
	public String getEmpresa_constructora() {
		return empresa_constructora;
	}
	/**
	 * @param empresa_constructora the empresa_constructora to set
	 */
	public void setEmpresa_constructora(String empresa_constructora) {
		this.empresa_constructora = empresa_constructora;
	}
	/**
	 * @return the anyo_incorporacion
	 */
	public int getAnyo_incorporacion() {
		return anyo_incorporacion;
	}
	/**
	 * @param anyo_incorporacion the anyo_incorporacion to set
	 */
	public void setAnyo_incorporacion(int anyo_incorporacion) {
		this.anyo_incorporacion = anyo_incorporacion;
	}
	/**
	 * @return the cod_cochera
	 */
	public int getCod_cochera() {
		return cod_cochera;
	}
	/**
	 * @param cod_cochera the cod_cochera to set
	 */
	public void setCod_cochera(int cod_cochera) {
		this.cod_cochera = cod_cochera;
	}
	/**
	 * @return the linea
	 */
	public LineaEscXML getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(LineaEscXML linea) {
		this.linea = linea;
	}
	@Override
	public String toString() {
		return "TrenEscXML [id=" + id + ", modelo=" + modelo + ", empresa_constructora=" + empresa_constructora
				+ ", anyo_incorporacion=" + anyo_incorporacion + ", cod_cochera=" + cod_cochera + ", linea=" + linea
				+ "]";
	}
}
