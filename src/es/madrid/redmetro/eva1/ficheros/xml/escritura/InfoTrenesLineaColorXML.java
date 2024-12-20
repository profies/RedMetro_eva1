/**
 * 
 */
package es.madrid.redmetro.eva1.ficheros.xml.escritura;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Isidoro Nevares Martín (IES Virgen de la Paloma)
 * Fecha: 28 nov 2024
 */
@JacksonXmlRootElement (localName = "info-trenes-linea-color")
public class InfoTrenesLineaColorXML {
    @JacksonXmlElementWrapper(useWrapping = true, localName = "trenes")
    @JsonProperty(value = "tren")
	private List<TrenEscXML> listaTrenes;

	/**
	 * @return the listaTrenes
	 */
	public List<TrenEscXML> getListaTrenes() {
		return listaTrenes;
	}

	/**
	 * @param listaTrenes the listaTrenes to set
	 */
	public void setListaTrenes(List<TrenEscXML> listaTrenes) {
		this.listaTrenes = listaTrenes;
	}

	@Override
	public String toString() {
		return "InfoTrenesLineaColorXML [listaTrenes=" + listaTrenes + "]";
	}	
}
