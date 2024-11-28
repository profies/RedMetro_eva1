/**
 * 
 */
package es.madrid.redmetro.inm.excepcion;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class RedMetroException extends Exception {
	private static final long serialVersionUID = -457918139315438755L;
	
	public static long ERROR_CONSULTA_BBDD=1;
	public static long ERROR_INSERCION_BBDD=2;
	public static long ERROR_ACTUALIZACION_BBDD=3;
	public static long ERROR_BORRADO_BBDD=4;
	public static long ERROR_TRATAMIENTO_CSV=4;
	public static long ERROR_TRATAMIENTO_LECTURA_XML=5;
	public static long ERROR_TRATAMIENTO_ESCRITURA_XML=6;


	long idError;
	
	public RedMetroException (Exception excepcion, long identificadorError) {
		super(excepcion);
		idError=identificadorError;
	}

	/**
	 * @return the idError
	 */
	public long getIdError() {
		return idError;
	}

	/**
	 * @param idError the idError to set
	 */
	public void setIdError(long idError) {
		this.idError = idError;
	}
}
