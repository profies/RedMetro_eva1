/**
 * 
 */
package es.madrid.redmetro.inm.vo;

import java.io.Serializable;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class Cochera implements Serializable{
	private static final long serialVersionUID = 3155379009944780512L;

	  private int codigoCochera;
	  private String nombre;
	  private String direccion;
	  private boolean deposito;
	/**
	 * @return the codCochera
	 */
	public int getCodigoCochera() {
		return codigoCochera;
	}
	/**
	 * @param codCochera the codCochera to set
	 */
	public void setCodigoCochera(int codCochera) {
		this.codigoCochera = codCochera;
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
	 * @return the deposito
	 */
	public boolean isDeposito() {
		return deposito;
	}
	/**
	 * @param deposito the deposito to set
	 */
	public void setDeposito(boolean deposito) {
		this.deposito = deposito;
	}
	public String toString() {
		return "Cochera [codCochera=" + codigoCochera + ", nombre=" + nombre + ", direccion=" + direccion + ", deposito="
				+ deposito + "]";
	}

}
