/**
 * 
 */
package es.madrid.redmetro.eva1.dao;

import java.util.List;

import es.madrid.redmetro.eva1.vo.Tren;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public interface ITrenDAO {
	public int insertarTren(Tren tren);

	public List<Tren> obtenerListaTrenes();

}
