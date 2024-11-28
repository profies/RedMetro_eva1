package es.madrid.redmetro.inm.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 4 nov 2023
*
*/
public class GestorConexion {
	//Conexión con JDBC 	
	public static Connection getConexion() {
		Connection conexion=null;
		try {
			String driver=GestorConfiguracion.getInfoConfiguracion("sgdb.driver").trim();
		    Class.forName(driver);

		    String urlSGDB=GestorConfiguracion.getInfoConfiguracion("sgdb.url").trim();
			String nombreBBDD=GestorConfiguracion.getInfoConfiguracion("bbdd.nombre").trim();
			String nombreUsuario=GestorConfiguracion.getInfoConfiguracion("bbdd.usuario").trim();
			String claveUsuario=GestorConfiguracion.getInfoConfiguracion("bbdd.clave").trim();
			
			StringBuilder urlConexionBBDD=new StringBuilder().append(urlSGDB).append(nombreBBDD);
			// Acceso a información de un fichero de configuración: Devuelve Properties
			System.out.println(urlConexionBBDD);
		    
			//Connection cn = DriverManager.getConnection("jdbc:mysql://servidor_bd:puerto/nombre_bd", "usuario", "contrase�a");
			conexion = DriverManager.getConnection(urlConexionBBDD.toString(), nombreUsuario, claveUsuario);
		} catch (ClassNotFoundException ex) {
			System.out.println("No se encontro el Driver MySQL para JDBC.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
}
