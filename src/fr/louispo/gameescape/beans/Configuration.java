/**
 * 
 */
package fr.louispo.gameescape.beans;

import java.util.Properties;

import fr.louispo.gameescape.Resource;

/**
 * @author Louis
 *
 */
public class Configuration {
	private Integer nombreDigit;
	private Integer nombreEssai;
	private Boolean modeDev;
	
	public Configuration(){
		
	}
	
	public Configuration(Integer nombreDigit, Integer nombreEssai, Boolean modeDev){
		this.nombreDigit = nombreDigit;
		this.nombreEssai = nombreEssai;
		this.modeDev = modeDev;
	}

	public Integer getNombreDigit() {
		return nombreDigit;
	}

	public void setNombreDigit(Integer nombreDigit) {
		this.nombreDigit = nombreDigit;
	}

	public Integer getNombreEssai() {
		return nombreEssai;
	}

	public void setNombreEssai(Integer nombreEssai) {
		try{
	         // chargement des propriétés
	         Properties prop = Resource.load("src/fr/louispo/gameescape/properties/config.properties");
	         nombreEssai= Integer.parseInt(prop.getProperty("nombreEssai"));
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
		this.nombreEssai = nombreEssai;
	}

	public Boolean getModeDev() {
		return modeDev;
	}

	public void setModeDev(Boolean modeDev) {
		this.modeDev = modeDev;
	}
	
	
}
