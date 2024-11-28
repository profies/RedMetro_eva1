/**
 * 
 */
package es.madrid.redmetro.inm;

import java.util.Scanner;

import es.madrid.redmetro.inm.dao.IColorDAO;
import es.madrid.redmetro.inm.dao.impl.ColorDaoJDBC;
import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.ficheros.GestorFicheroCSV;
import es.madrid.redmetro.inm.ficheros.GestorFicherosXML;
import es.madrid.redmetro.inm.vo.Color;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 2 dic 2023
 *
 */
public class RedMetroApp {
	public static void main(String[] args) {
		RedMetroApp app = new RedMetroApp();

		// Tratamiento de lógica de negocio
		String operacion = app.obtenerOperacionProcesar();

		app.ejecutarFuncionalidadesRedMetro(operacion);
	}

	private String obtenerOperacionProcesar() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Menú:");
		System.out.println("  A: Consultar Información Línea-Color");
		System.out.println("  B: Procesar fichero Cocheras.csv");
		System.out.println("  C: Procesar Fichero XML de Trenes-Estaciones-Accesos");
		System.out.println("  D: Cargar información Trenes-Linea-Color en fichero XML");
		System.out.println("----------------------------------------------------------");
		System.out.println("Introduce la operación a realizar:");
		// Operación recogida
		String operacion = entrada.nextLine().trim();

		while (!("ABCD".contains(operacion))) {
			System.out.println("Has seleccionado un operación errónea (ha de ser un número entre A y D)");
			System.out.print("Introduce la operación a realizar:");

			// Operación recogida
			operacion = entrada.nextLine();
		}
		System.out.println("Operación a realizar: " + operacion);
		// Cerrar la entrada del Scanner
		entrada.close();

		return operacion;
	}

	public void ejecutarFuncionalidadesRedMetro(String operacion) {
		try {
			switch (operacion) {
			case "A": { // Consulta Linea-Color
				System.out.println("Ejecutar consultarLineaColor");
				IColorDAO iColorDao = new ColorDaoJDBC();
				Color color = iColorDao.obtenerColorPorIdLinea(13);
				System.out.println("La Línea " + color.getLinea().getNombreLargo() + "( " + color.getLinea().getCodigoLinea()
						+ ") tiene como color " + color.getNombre() + "( " + color.getCodigoHexadecimal() + ")");
				break;
			}
			case "B": { // Procesar Fichero CSV Cocheras
				System.out.println("Ejecutar procesarFicheroCocheraCSV");
				GestorFicheroCSV gestorFicheros = new GestorFicheroCSV();
				gestorFicheros.procesarFicheroCocheraCSV();
				break;
			}
			case "C": { // Procesar Fichero XML Trenes
				System.out.println("Ejecutar procesarFicheroTrenXML");
				GestorFicherosXML gestorFicheros = new GestorFicherosXML();

				gestorFicheros.procesarFicheroTrenXML();
				break;
			}
			case "D": { // Crear fichero XML a partir de información de Trenes-Línea-Color
				System.out.println("Ejecutar crearFicheroXMLInforTrenes");
				GestorFicherosXML gestorFicheros = new GestorFicherosXML();

				gestorFicheros.escribirXMLConInfoTrenLineaColor();
				break;
			}
			default: {
				break;
			}
			}
		} catch (RedMetroException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha saltado una excepción RedMetroException. Código " + e.getIdError());
			e.printStackTrace();
		}
	}
}
