/**
 * 
 */
package es.madrid.redmetro.eva1.dao;

import es.madrid.redmetro.eva1.vo.Cochera;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public interface ICocheraDAO {
	public int insertarCochera(Cochera cochera);
	
	public int borrarCochera(int iDCochera);
	
	public int actualizarCochera(Cochera cochera);
}
