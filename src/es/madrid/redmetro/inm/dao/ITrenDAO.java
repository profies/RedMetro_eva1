/**
 * 
 */
package es.madrid.redmetro.inm.dao;

import java.util.List;

import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.vo.Tren;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public interface ITrenDAO {
	public int insertarTren(Tren tren) throws RedMetroException;

	public List<Tren> obtenerListaTrenes() throws RedMetroException;

}
