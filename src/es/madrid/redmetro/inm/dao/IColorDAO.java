/**
 * 
 */
package es.madrid.redmetro.inm.dao;

import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.vo.Color;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public interface IColorDAO {
	public Color obtenerColorPorIdLinea(int idLinea) throws RedMetroException;
}
