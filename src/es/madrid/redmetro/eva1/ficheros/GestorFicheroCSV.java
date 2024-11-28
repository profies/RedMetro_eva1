/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import es.madrid.redmetro.eva1.dao.ICocheraDAO;
import es.madrid.redmetro.eva1.dao.impl.CocheraDaoJDBC;
import es.madrid.redmetro.eva1.ficheros.csv.CocheraCSV;
import es.madrid.redmetro.eva1.utilidades.GestorFicheroConfiguracion;
import es.madrid.redmetro.eva1.vo.Cochera;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class GestorFicheroCSV {
	private final static char SEPARADOR_CSV_ORGANISMO = GestorFicheroConfiguracion.getInfoConfiguracion("csv.separador")
			.charAt(0);

	public void procesarFicheroCocheraCSV(){

		List<CocheraCSV> listaCocheraCSV = obtenerListaCocheraCSV();
		// Tratamiento Cochera CSV
		int resultado = 0;
		if (listaCocheraCSV != null && listaCocheraCSV.size() > 0) {
			ICocheraDAO iCocheraDAO = new CocheraDaoJDBC();

			for (CocheraCSV cocheraCSV : listaCocheraCSV) {
				int operacion = cocheraCSV.getOperacion();
				System.out.println("Valor de cocheraCSV: " + cocheraCSV);

				Cochera cochera = obtenerCocheraDeCocheraCSV(cocheraCSV);
				if (operacion == 1) {
					resultado = iCocheraDAO.insertarCochera(cochera);
				} else if (operacion == 2) {
					resultado = iCocheraDAO.actualizarCochera(cochera);
				} else if (operacion == 3) {
					resultado = iCocheraDAO.borrarCochera(cochera.getCodigoCochera());
				}
				System.out.println("Valor de resulado: " + resultado);
			}
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<CocheraCSV> obtenerListaCocheraCSV(){
		List<CocheraCSV> listaCocherasCSV = null;

		String nombreFicheroCSV = GestorFicheroConfiguracion.getInfoConfiguracion("ruta.directorio")
				+ GestorFicheroConfiguracion.getInfoConfiguracion("nombre.fichero.cochera.csv");
		try {
			listaCocherasCSV = new CsvToBeanBuilder(new FileReader(nombreFicheroCSV)).withType(CocheraCSV.class)
					.withSeparator(SEPARADOR_CSV_ORGANISMO).build().parse();
		} catch (IllegalStateException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaCocherasCSV;
	}

	public Cochera obtenerCocheraDeCocheraCSV(CocheraCSV cocheraCSV) {
		Cochera cochera = null;
		if (cocheraCSV != null) {
			cochera = new Cochera();
			cochera.setCodigoCochera(cocheraCSV.getCod_cochera());
			boolean esDeposito = false;
			if (cocheraCSV.getDeposito() == 1) {
				esDeposito = true;
			}
			cochera.setDeposito(esDeposito);
			cochera.setDireccion(cocheraCSV.getLocalizacion());
			cochera.setNombre(cocheraCSV.getDenominacion());
		}
		return cochera;
	}
}
