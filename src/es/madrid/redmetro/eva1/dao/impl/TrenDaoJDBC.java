/**
 * 
 */
package es.madrid.redmetro.eva1.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.madrid.redmetro.eva1.dao.ITrenDAO;
import es.madrid.redmetro.eva1.utilidades.GestorConexionSGDB;
import es.madrid.redmetro.eva1.vo.Cochera;
import es.madrid.redmetro.eva1.vo.Color;
import es.madrid.redmetro.eva1.vo.Linea;
import es.madrid.redmetro.eva1.vo.Tren;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class TrenDaoJDBC implements ITrenDAO{
	private GestorConexionSGDB gestorConexion=new GestorConexionSGDB(); 
	
	public int insertarTren(Tren tren){
		int resultadoSentencia=0;

		Connection conexion=gestorConexion.getConexionSGDB();
		PreparedStatement declaracion=null;
		try {
			String sentenciaSQL= "INSERT INTO T_TREN VALUES (?, ?, ? , ?, ?, ?)";
			declaracion = conexion.prepareStatement(sentenciaSQL);
		
			declaracion.setInt(1, tren.getCodigoTren());
			declaracion.setString(2, tren.getModelo());
			declaracion.setString(3, tren.getEmpresaConstructora());
			// Obtener java.sql.Date de Un java.util.Date
			Date fechaBBDD= new Date(tren.getFechaIncorporacion().getTime());
			declaracion.setDate(4, fechaBBDD);
			declaracion.setInt(5, tren.getCochera().getCodigoCochera());
			declaracion.setInt(6, tren.getLinea().getCodigoLinea());
			
			System.out.println(declaracion);

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

			declaracion = conexion.prepareStatement(sentenciaSQL);
			declaracion.setInt(1, idCochera);

			System.out.println(declaracion);
	
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
		
			declaracion.setString(1, cochera.getNombre());
			declaracion.setString(2, cochera.getDireccion());
			declaracion.setBoolean(3, cochera.isDeposito());
			declaracion.setInt(4, cochera.getCodigoCochera());

			System.out.println(declaracion);
			
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

	@Override
	public List<Tren> obtenerListaTrenes(){
		List<Tren> listaTrenes=null;

		Connection conexion=gestorConexion.getConexionSGDB();
		PreparedStatement declaracion=null;
		ResultSet resultadoSentencia=null;
		try {
			String sentenciaSQL= "SELECT * FROM "
								+ "T_TREN tren join T_LINEA linea "
								+ "ON tren.cod_linea =linea.cod_linea"
								+ " join T_COCHERA cochera "
								+ " on tren.cod_cochera =cochera.cod_cochera "
								+ " join T_COLOR color "
								+ " on linea.cod_color =color.cod_color ";
			declaracion = conexion.prepareStatement(sentenciaSQL);

			System.out.println(declaracion);
			
			resultadoSentencia = declaracion.executeQuery();
			while (resultadoSentencia.next()) {
				if (listaTrenes==null) {
					listaTrenes= new ArrayList<Tren>();
				}
				Tren tren =new Tren();
				tren.setCodigoTren(resultadoSentencia.getInt("tren.cod_tren"));
				tren.setEmpresaConstructora(resultadoSentencia.getString("tren.empresa_constructora"));
				tren.setModelo(resultadoSentencia.getString("tren.modelo"));
				tren.setFechaIncorporacion(resultadoSentencia.getDate("tren.fecha_incorporacion"));
				
				// Información de la Línea
				Linea linea = new Linea();
				linea.setCodigoLinea(resultadoSentencia.getInt("linea.cod_linea"));
				linea.setKilometros(resultadoSentencia.getFloat("linea.kilometros"));
				linea.setNombreCorto(resultadoSentencia.getString("linea.nombre_corto"));
				linea.setNombreLargo(resultadoSentencia.getString("linea.nombre_largo"));
				
				// Información de Color
				Color color = new Color();
				color.setCodigoColor(resultadoSentencia.getInt("color.cod_color"));
				color.setNombre(resultadoSentencia.getString("color.nombre"));
				color.setCod_hexadecimal(resultadoSentencia.getString("color.cod_hexadecimal"));

				linea.setColor(color);
				
				tren.setLinea(linea);

				// Información de la Cochera
				Cochera cochera= new Cochera();
				cochera.setCodigoCochera(resultadoSentencia.getInt("cochera.cod_cochera"));
				cochera.setDeposito(resultadoSentencia.getBoolean("cochera.deposito"));
				cochera.setDireccion(resultadoSentencia.getString("cochera.direccion"));
				cochera.setNombre(resultadoSentencia.getString("cochera.nombre"));
				tren.setCochera(cochera);

				listaTrenes.add(tren);
				
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

		return listaTrenes;
	}
}
