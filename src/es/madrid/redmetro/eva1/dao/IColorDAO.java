/**
 * 
 */
package es.madrid.redmetro.eva1.dao;

import es.madrid.redmetro.eva1.vo.Color;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public interface IColorDAO {
	public Color obtenerColorPorIdLinea(int idLinea);
}
