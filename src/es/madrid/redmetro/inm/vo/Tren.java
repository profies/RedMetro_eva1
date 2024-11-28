/**
 * 
 */
package es.madrid.redmetro.inm.vo;

import java.io.Serializable;
import java.util.Date;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class Tren implements Serializable{
	private static final long serialVersionUID = 3033036838329546838L;
	
	private int codigoTren;
	private String modelo;
	private String empresaConstructora;
	private Date fechaIncorporacion;
	private Cochera cochera;
	private Linea linea;
	
	/**
	 * @return the codigoTren
	 */
	public int getCodigoTren() {
		return codigoTren;
	}
	/**
	 * @param codigoTren the codigoTren to set
	 */
	public void setCodigoTren(int codigoTren) {
		this.codigoTren = codigoTren;
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
	 * @return the empresaConstructora
	 */
	public String getEmpresaConstructora() {
		return empresaConstructora;
	}
	/**
	 * @param empresaConstructora the empresaConstructora to set
	 */
	public void setEmpresaConstructora(String empresaConstructora) {
		this.empresaConstructora = empresaConstructora;
	}
	/**
	 * @return the fechaIncorporacion
	 */
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	/**
	 * @param fechaIncorporacion the fechaIncorporacion to set
	 */
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	/**
	 * @return the cochera
	 */
	public Cochera getCochera() {
		return cochera;
	}
	/**
	 * @param cochera the cochera to set
	 */
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
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
		return "Tren [codigoTren=" + codigoTren + ", modelo=" + modelo + ", empresaConstructora=" + empresaConstructora
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", cochera=" + cochera + ", linea=" + linea + "]";
	}
}
