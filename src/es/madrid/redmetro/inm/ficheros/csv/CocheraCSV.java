/**
 * 
 */
package es.madrid.redmetro.inm.ficheros.csv;

import java.io.Serializable;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 2 dic 2023
 *
 */
public class CocheraCSV implements Serializable {
	private static final long serialVersionUID = 3155379009944780512L;

	int operacion;
	int cod_cochera;
	int deposito;
	String denominacion;
	String localizacion;
	/**
	 * @return the operacion
	 */
	public int getOperacion() {
		return operacion;
	}
	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(int operacion) {
		this.operacion = operacion;
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
	 * @return the deposito
	 */
	public int getDeposito() {
		return deposito;
	}
	/**
	 * @param deposito the deposito to set
	 */
	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	/**
	 * @return the denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}
	/**
	 * @param denominacion the denominacion to set
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}
	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	@Override
	public String toString() {
		return "CocheraCSV [operacion=" + operacion + ", cod_cochera=" + cod_cochera + ", deposito=" + deposito
				+ ", denominacion=" + denominacion + ", localizacion=" + localizacion + "]";
	}
}
