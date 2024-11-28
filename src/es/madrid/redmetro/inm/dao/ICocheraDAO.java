/**
 * 
 */
package es.madrid.redmetro.inm.dao;

import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.vo.Cochera;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public interface ICocheraDAO {
	public int insertarCochera(Cochera cochera) throws RedMetroException;
	
	public int borrarCochera(int iDCochera) throws RedMetroException;
	
	public int actualizarCochera(Cochera cochera) throws RedMetroException;
}
