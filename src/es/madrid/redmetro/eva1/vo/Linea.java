/**
 * 
 */
package es.madrid.redmetro.eva1.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class Linea implements Serializable{
	private static final long serialVersionUID = 2546017016457301339L;

	private int codigoLinea;
	private String nombreCorto;
	private String nombreLargo;
	private Date fechaInauguracion;
	private float kilometros;
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the codigoLinea
	 */
	public int getCodigoLinea() {
		return codigoLinea;
	}
	/**
	 * @param codigoLinea the codigoLinea to set
	 */
	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	/**
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}
	/**
	 * @param nombreCorto the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	/**
	 * @return the nombreLargo
	 */
	public String getNombreLargo() {
		return nombreLargo;
	}
	/**
	 * @param nombreLargo the nombreLargo to set
	 */
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	/**
	 * @return the fechaInauguracion
	 */
	public Date getFechaInauguracion() {
		return fechaInauguracion;
	}
	/**
	 * @param fechaInauguracion the fechaInauguracion to set
	 */
	public void setFechaInauguracion(Date fechaInauguracion) {
		this.fechaInauguracion = fechaInauguracion;
	}
	/**
	 * @return the kilometros
	 */
	public float getKilometros() {
		return kilometros;
	}
	/**
	 * @param kilometros the kilometros to set
	 */
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", fechaInauguracion=" + fechaInauguracion + ", kilometros=" + kilometros + ", color=" + color + "]";
	}
}
