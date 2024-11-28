/**
 * 
 */
package es.madrid.redmetro.eva1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.madrid.redmetro.eva1.dao.ICocheraDAO;
import es.madrid.redmetro.eva1.utilidades.GestorConexionSGDB;
import es.madrid.redmetro.eva1.vo.Cochera;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class CocheraDaoJDBC implements ICocheraDAO{
	private GestorConexionSGDB gestorConexion=new GestorConexionSGDB(); 
	
	public int insertarCochera(Cochera cochera){
		int resultadoSentencia=0;

		Connection conexion=gestorConexion.getConexionSGDB();
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

	public int borrarCochera(int idCochera){
		int resultadoSentencia=0;

		Connection conexion=gestorConexion.getConexionSGDB();
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

	public int actualizarCochera(Cochera cochera){
		int resultadoSentencia=0;

		Connection conexion=gestorConexion.getConexionSGDB();
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
