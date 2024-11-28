package es.madrid.redmetro.eva1.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexionSGDB {

	public Connection getConexionSGDB(){
		Connection conexionSGDB = null;

		// Datos URL
		String urlBBDD =GestorFicheroConfiguracion.getInfoConfiguracion("url.bbdd");

		String usuario = GestorFicheroConfiguracion.getInfoConfiguracion("usuario.sgdb");
		String contrasenya =GestorFicheroConfiguracion.getInfoConfiguracion("clave.sgdb");

		try {
			String claseDriver= GestorFicheroConfiguracion.getInfoConfiguracion("driver.sgdb");
			Class.forName(claseDriver);

			conexionSGDB = DriverManager.getConnection(urlBBDD, usuario, contrasenya);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexionSGDB;
	}

}
