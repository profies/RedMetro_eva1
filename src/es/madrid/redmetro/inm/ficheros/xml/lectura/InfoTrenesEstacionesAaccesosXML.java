/**
 * 
 */
package es.madrid.redmetro.inm.ficheros.xml.lectura;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/** 
* @author Isidoro Nevares Martín (IES El Cañaveral)
* Fecha: 2 dic 2023
*
*/
@JacksonXmlRootElement
public class InfoTrenesEstacionesAaccesosXML {
    @JacksonXmlElementWrapper(useWrapping = true, localName = "trenes")
	private List<TrenXML> listaTrenes;	
    @JacksonXmlElementWrapper(useWrapping = true, localName = "estaciones")
	private List<EstacionXML> listaEstaciones;
	/**
	 * @return the listaTrenes
	 */
	public List<TrenXML> getListaTrenes() {
		return listaTrenes;
	}
	/**
	 * @param listaTrenes the listaTrenes to set
	 */
	public void setListaTrenes(List<TrenXML> listaTrenes) {
		this.listaTrenes = listaTrenes;
	}
	/**
	 * @return the listaEstaciones
	 */
	public List<EstacionXML> getListaEstaciones() {
		return listaEstaciones;
	}
	/**
	 * @param listaEstaciones the listaEstaciones to set
	 */
	public void setListaEstaciones(List<EstacionXML> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}
	@Override
	public String toString() {
		return "InfoTrenesEstacionesAaccesosXML [listaTrenes=" + listaTrenes + ", listaEstaciones=" + listaEstaciones
				+ "]";
	}
	
}
