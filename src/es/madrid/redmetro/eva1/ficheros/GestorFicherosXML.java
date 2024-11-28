/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.madrid.redmetro.eva1.dao.IColorDAO;
import es.madrid.redmetro.eva1.dao.ITrenDAO;
import es.madrid.redmetro.eva1.dao.impl.ColorDaoJDBC;
import es.madrid.redmetro.eva1.dao.impl.TrenDaoJDBC;
import es.madrid.redmetro.eva1.ficheros.xml.escritura.ColorEscXML;
import es.madrid.redmetro.eva1.ficheros.xml.escritura.InfoTrenesLineaColorXML;
import es.madrid.redmetro.eva1.ficheros.xml.escritura.LineaEscXML;
import es.madrid.redmetro.eva1.ficheros.xml.escritura.TrenEscXML;
import es.madrid.redmetro.eva1.ficheros.xml.lectura.InfoTrenesEstacionesAaccesosXML;
import es.madrid.redmetro.eva1.ficheros.xml.lectura.TrenXML;
import es.madrid.redmetro.eva1.utilidades.GestorFicheroConfiguracion;
import es.madrid.redmetro.eva1.vo.Cochera;
import es.madrid.redmetro.eva1.vo.Color;
import es.madrid.redmetro.eva1.vo.Linea;
import es.madrid.redmetro.eva1.vo.Tren;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
public class GestorFicherosXML {

	public void procesarFicheroTrenXML(){
		// Dos opciones: 1. Usar Jackson - 2. Usar DOM
		// 1. Usar Jackson
		// List<TrenXML> listaTrenXML = gestorFicheros.obtenerListaTrenesXML();
		// 2. Usar DOM
		List<TrenXML> listaTrenXML = obtenerListaTrenesXMLDeDOM();

		// Tratamiento TrenXML
		int resultado = 0;
		if (listaTrenXML != null && listaTrenXML.size() > 0) {
			ITrenDAO iTrenDAO = new TrenDaoJDBC();

			for (TrenXML trenXML : listaTrenXML) {
				System.out.println("Valor de trenXML: " + trenXML);

				Tren tren = obtenerTrenDeTrenXML(trenXML);
				resultado = iTrenDAO.insertarTren(tren);
				System.out.println("Valor de resulado: " + resultado);
			}
		}

	}

	public List<TrenXML> obtenerListaTrenesXML(){
		InfoTrenesEstacionesAaccesosXML informacion = null;
		String nombreFicheroXML = GestorFicheroConfiguracion.getInfoConfiguracion("ruta.directorio")
				+ GestorFicheroConfiguracion.getInfoConfiguracion("nombre.fichero.tren.lectura.xml");
		ObjectMapper mapper = new XmlMapper();
		try {
			informacion = mapper.readValue(new File(nombreFicheroXML), InfoTrenesEstacionesAaccesosXML.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return informacion.getListaTrenes();
	}

	public Tren obtenerTrenDeTrenXML(TrenXML trenXML) {
		Tren tren = null;
		if (trenXML != null) {

			tren = new Tren();
			tren.setCodigoTren(trenXML.getId());
			tren.setModelo(trenXML.getModelo());
			tren.setEmpresaConstructora(trenXML.getEmpresa_constructora());
			SimpleDateFormat formato = new SimpleDateFormat("yyyy");
			Date fechaIncorporacion = null;
			try {
				fechaIncorporacion = formato.parse(trenXML.getAnyo_incorporacion());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tren.setFechaIncorporacion(fechaIncorporacion);
			Linea linea = new Linea();
			linea.setCodigoLinea(trenXML.getId_linea());
			tren.setLinea(linea);
			Cochera cochera = new Cochera();
			cochera.setCodigoCochera(trenXML.getCod_cochera());
			tren.setCochera(cochera);
		}
		return tren;
	}

	public List<TrenXML> obtenerListaTrenesXMLDeDOM(){
		List<TrenXML> listaTrenesXML = null;
		String nombreFicheroXML = GestorFicheroConfiguracion.getInfoConfiguracion("ruta.directorio")
				+ GestorFicheroConfiguracion.getInfoConfiguracion("nombre.fichero.tren.lectura.xml");
		// Tratamiento del fichero XML
		File file = new File(nombreFicheroXML);
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			// estos métodos podemos usarlos combinados para normalizar el archivo XML
			doc.getDocumentElement().normalize();

			// Obtener la lista de nodos cuya etiqueta es "tren"
			NodeList nList = doc.getElementsByTagName("tren");
			if (nList.getLength() != 0) {
				listaTrenesXML = new ArrayList<TrenXML>();
			}
			System.out.println("Número de Trenes: " + nList.getLength());
			// Recorrer los distintos nodos Tren
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nodoTren = nList.item(temp);

				if (nodoTren.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodoTren;
					// Obtener información del tren
					int idTren = Integer.parseInt(eElement.getAttribute("id"));
					String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
					String anyoFabricacion = eElement.getElementsByTagName("anyo_incorporacion").item(0)
							.getTextContent();
					String empresa_constructora = eElement.getElementsByTagName("empresa_constructora").item(0)
							.getTextContent();
					int codigoCochera = Integer
							.parseInt(eElement.getElementsByTagName("cod_cochera").item(0).getTextContent());
					int idLinea = Integer.parseInt(eElement.getElementsByTagName("id_linea").item(0).getTextContent());

					TrenXML trenXML = new TrenXML();
					trenXML.setId(idTren);
					trenXML.setAnyo_incorporacion(anyoFabricacion);
					trenXML.setModelo(modelo);
					trenXML.setEmpresa_constructora(empresa_constructora);
					trenXML.setCod_cochera(codigoCochera);
					trenXML.setId_linea(idLinea);

					listaTrenesXML.add(trenXML);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTrenesXML;
	}

	public void escribirXMLConInfoTrenLineaColor(){
		InfoTrenesLineaColorXML informacion = obtenerInfoTrenesLineaColorXML();
		String nombreFicheroXML = GestorFicheroConfiguracion.getInfoConfiguracion("ruta.directorio")
				+ GestorFicheroConfiguracion.getInfoConfiguracion("nombre.fichero.tren.escritura.xml");
		ObjectMapper mapper = new XmlMapper();
		try {
			mapper.writeValue(new File(nombreFicheroXML), informacion);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private InfoTrenesLineaColorXML obtenerInfoTrenesLineaColorXML(){
		InfoTrenesLineaColorXML informacionXMLEscritura = null;
		ITrenDAO iTrenDAO = new TrenDaoJDBC();
		List<Tren> listaTrenes = iTrenDAO.obtenerListaTrenes();
		System.out.println(listaTrenes);

		if (listaTrenes != null && listaTrenes.size() > 0) {
			informacionXMLEscritura = new InfoTrenesLineaColorXML();
			IColorDAO iColorDao = new ColorDaoJDBC();
			List<TrenEscXML> listaTrenesEscXML = new ArrayList<TrenEscXML>();
			for (Tren tren : listaTrenes) {
				System.out.println("Valor de tren: " + tren);

				TrenEscXML trenEscXML = new TrenEscXML();
				trenEscXML.setId(tren.getCodigoTren());
				trenEscXML.setCod_cochera(tren.getCochera().getCodigoCochera());
				trenEscXML.setEmpresa_constructora(tren.getEmpresaConstructora());
				// Obtener el año a partir de la fecha
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(tren.getFechaIncorporacion());
				trenEscXML.setAnyo_incorporacion(calendar.get(Calendar.YEAR));
				trenEscXML.setModelo(tren.getModelo());

				LineaEscXML lineaXML = new LineaEscXML();

				ColorEscXML colorXML = null;
				Color color = iColorDao.obtenerColorPorIdLinea(tren.getLinea().getCodigoLinea());
				if (color != null) {
					colorXML = new ColorEscXML();
					colorXML.setIdColor(color.getCodigoColor());
					colorXML.setCodigoHexadecimal(color.getCodigoHexadecimal());
					colorXML.setDescripcion(color.getNombre());

					lineaXML.setId(color.getLinea().getCodigoLinea());
					lineaXML.setNombre_l(color.getLinea().getNombreLargo());
					lineaXML.setColor(colorXML);
				}

				trenEscXML.setLinea(lineaXML);

				listaTrenesEscXML.add(trenEscXML);
			}
			informacionXMLEscritura.setListaTrenes(listaTrenesEscXML);
		}

		return informacionXMLEscritura;
	}

}
