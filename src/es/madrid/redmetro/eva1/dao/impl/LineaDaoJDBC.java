/**
 * 
 */
package es.madrid.redmetro.eva1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.madrid.redmetro.eva1.dao.ILineaDAO;
import es.madrid.redmetro.eva1.utilidades.GestorConexionSGDB;
import es.madrid.redmetro.eva1.vo.Color;
import es.madrid.redmetro.eva1.vo.Linea;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class LineaDaoJDBC implements ILineaDAO{
	private GestorConexionSGDB gestorConexion=new GestorConexionSGDB(); 
	
	public  Linea obtenerInformacionLinea(int idLinea){
		Linea linea=null;

		Connection conexion=gestorConexion.getConexionSGDB();
		PreparedStatement declaracion=null;
		ResultSet resultadoSentencia=null;
		try {
			String sentenciaSQL= "SELECT * FROM T_COLOR color, T_LINEA linea "
					+ "WHERE linea.cod_color= color.cod_color "
					+ "and linea.cod_linea = ?";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setInt(1, idLinea);
			System.out.println(declaracion);

			resultadoSentencia = declaracion.executeQuery();
			if (resultadoSentencia.next()) {
				
				linea=new Linea();
				linea.setCodigoLinea(resultadoSentencia.getInt("linea.cod_linea"));
				linea.setNombreCorto(resultadoSentencia.getString("linea.nombre_corto"));
				linea.setNombreLargo(resultadoSentencia.getString("linea.nombre_largo"));
				linea.setKilometros(resultadoSentencia.getFloat("linea.kilometros"));
				
				Color color=new Color();
				color.setCodigoColor(resultadoSentencia.getInt("color.cod_color"));
				color.setCod_hexadecimal(resultadoSentencia.getString("color.cod_hexadecimal"));
				color.setNombre(resultadoSentencia.getString("color.nombre"));

				linea.setColor(color);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conexion!=null) {
				try {
					resultadoSentencia.close();
					declaracion.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return linea;
	}
}
