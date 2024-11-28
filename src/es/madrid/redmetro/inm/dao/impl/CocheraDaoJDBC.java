/**
 * 
 */
package es.madrid.redmetro.inm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.madrid.redmetro.inm.dao.ICocheraDAO;
import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.utilidades.GestorConexion;
import es.madrid.redmetro.inm.vo.Cochera;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
public class CocheraDaoJDBC implements ICocheraDAO{

	public int insertarCochera(Cochera cochera) throws RedMetroException {
		int resultadoSentencia=0;

		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "INSERT INTO T_COCHERA VALUES (?, ?, ? , ?)";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			System.out.println(sentenciaSQL);
		
			declaracion.setInt(1, cochera.getCodigoCochera());
			declaracion.setString(2, cochera.getNombre());
			declaracion.setString(3, cochera.getDireccion());
			declaracion.setBoolean(4, cochera.isDeposito());
			
			resultadoSentencia = declaracion.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conexion!=null) {
				try {
					declaracion.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return resultadoSentencia;
	}

	public int borrarCochera(int idCochera) throws RedMetroException {
		int resultadoSentencia=0;

		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "DELETE FROM T_COCHERA WHERE cod_cochera = ?";
			System.out.println(sentenciaSQL);

			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setInt(1, idCochera);
		
			resultadoSentencia = declaracion.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conexion!=null) {
				try {
					declaracion.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return resultadoSentencia;
	}

	public int actualizarCochera(Cochera cochera) throws RedMetroException {
		int resultadoSentencia=0;

		Connection conexion=GestorConexion.getConexion();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "UPDATE T_COCHERA SET nombre = ?, direccion = ? , deposito = ?"
					  + " WHERE cod_cochera = ?";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			System.out.println(sentenciaSQL);
		
			declaracion.setString(1, cochera.getNombre());
			declaracion.setString(2, cochera.getDireccion());
			declaracion.setBoolean(3, cochera.isDeposito());
			declaracion.setInt(4, cochera.getCodigoCochera());
			
			resultadoSentencia = declaracion.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conexion!=null) {
				try {
					declaracion.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return resultadoSentencia;
	}
}
