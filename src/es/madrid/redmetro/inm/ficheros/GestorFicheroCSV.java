/**
 * 
 */
package es.madrid.redmetro.inm.ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import es.madrid.redmetro.inm.dao.ICocheraDAO;
import es.madrid.redmetro.inm.dao.impl.CocheraDaoJDBC;
import es.madrid.redmetro.inm.excepcion.RedMetroException;
import es.madrid.redmetro.inm.ficheros.csv.CocheraCSV;
import es.madrid.redmetro.inm.utilidades.GestorConfiguracion;
import es.madrid.redmetro.inm.vo.Cochera;

/**
 * @author Isidoro Nevares Martín (IES El Cañaveral) Fecha: 2 dic 2023
 *
 */
public class GestorFicheroCSV {
	private final static char SEPARADOR_CSV_ORGANISMO = GestorConfiguracion.getInfoConfiguracion("csv.separador")
			.charAt(0);

	public void procesarFicheroCocheraCSV() throws RedMetroException {

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
	private List<CocheraCSV> obtenerListaCocheraCSV() throws RedMetroException {
		List<CocheraCSV> listaCocherasCSV = null;

		String nombreFicheroCSV = GestorConfiguracion.getInfoConfiguracion("ruta.directorio")
				+ GestorConfiguracion.getInfoConfiguracion("nombre.fichero.cochera.csv");
		try {
			listaCocherasCSV = new CsvToBeanBuilder(new FileReader(nombreFicheroCSV)).withType(CocheraCSV.class)
					.withSeparator(SEPARADOR_CSV_ORGANISMO).build().parse();
		} catch (IllegalStateException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RedMetroException(e, RedMetroException.ERROR_TRATAMIENTO_CSV);
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
