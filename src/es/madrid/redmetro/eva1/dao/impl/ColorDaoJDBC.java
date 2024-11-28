/**
 * 
 */
package es.madrid.redmetro.eva1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.madrid.redmetro.eva1.dao.IColorDAO;
import es.madrid.redmetro.eva1.utilidades.GestorConexionSGDB;
import es.madrid.redmetro.eva1.vo.Color;
import es.madrid.redmetro.eva1.vo.Linea;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class ColorDaoJDBC implements IColorDAO{
	private GestorConexionSGDB gestorConexion=new GestorConexionSGDB(); 
	
	public Color obtenerColorPorIdLinea(int idLinea){
		Color color=null;

		Connection conexion=gestorConexion.getConexionSGDB();
		PreparedStatement declaracion=null;
		ResultSet resultadoSentencia=null;
		try {
			String sentenciaSQL= "SELECT * FROM T_COLOR color, T_LINEA linea "
					+ "WHERE color.cod_linea = linea.cod_linea "
					+ "and color.cod_linea = ?";
			declaracion = conexion.prepareStatement(sentenciaSQL);
			System.out.println(sentenciaSQL);
			declaracion.setInt(1, idLinea);
			resultadoSentencia = declaracion.executeQuery();
			if (resultadoSentencia.next()) {
				color=new Color();
				color.setCodigoColor(resultadoSentencia.getInt("color.cod_color"));
				color.setCod_hexadecimal(resultadoSentencia.getString("color.cod_hexadecimal"));
				color.setNombre(resultadoSentencia.getString("color.nombre"));
				
				Linea linea=new Linea();
				linea.setCodigoLinea(resultadoSentencia.getInt("linea.cod_linea"));
				linea.setNombreCorto(resultadoSentencia.getString("linea.nombre_corto"));
				linea.setNombreLargo(resultadoSentencia.getString("linea.nombre_largo"));
				linea.setFechaInauguracion(resultadoSentencia.getDate("linea.fecha_inauguracion"));
				linea.setKilometros(resultadoSentencia.getFloat("linea.kilometros"));
				color.setLinea(linea);
				
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

		return color;
	}
}
