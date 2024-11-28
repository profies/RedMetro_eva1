/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.lectura;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class TrenXML {
	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private int id;
	private String modelo;
	
	@JacksonXmlProperty(localName = "anyo_incorporacion")
	private String anyoIncorporacion;

	@JacksonXmlProperty(localName = "empresa_constructora")
	private String empresaConstructora;

	@JacksonXmlProperty(localName = "cod_cochera")
	private int codCochera;

	@JacksonXmlProperty(localName = "id_linea")
	private int idLinea;
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
	public String getAnyoIncorporacion() {
		return anyoIncorporacion;
	}
	public void setAnyoIncorporacion(String anyoIncorporacion) {
		this.anyoIncorporacion = anyoIncorporacion;
	}
	public String getEmpresaConstructora() {
		return empresaConstructora;
	}
	public void setEmpresaConstructora(String empresaConstructora) {
		this.empresaConstructora = empresaConstructora;
	}
	public int getCodCochera() {
		return codCochera;
	}
	public void setCodCochera(int codCochera) {
		this.codCochera = codCochera;
	}
	public int getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	@Override
	public String toString() {
		return "TrenXML [id=" + id + ", modelo=" + modelo + ", anyoIncorporacion=" + anyoIncorporacion
				+ ", empresaConstructora=" + empresaConstructora + ", codCochera=" + codCochera + ", idLinea=" + idLinea
				+ "]";
	}
	
}
