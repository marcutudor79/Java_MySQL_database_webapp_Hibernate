package pojo;

import java.util.HashSet;
import java.util.Set;

public class Characteristics  implements java.io.Serializable {

	private Integer idcharacteristics;
	private String clas;
	private String orders;
	private String species;
	private String kingdom;	
	private Set junctions = new HashSet(0);

	public Characteristics() {
	}

	public Characteristics (String Class, String Order, String Species, String Kingdom, Set junctions) {
		this.clas = Class;
		this.orders = Order;
		this.species = Species;
		this.kingdom = Kingdom;
		this.junctions = junctions;
	}

	public Integer getIdcharacteristics() {
		return this.idcharacteristics;
	}

	public void setIdcharacteristics(Integer idcharacteristics) {
		this.idcharacteristics = idcharacteristics;
	}
	
	public String getClas() {
		return this.clas;
	}

	public void setClas(String nume) {
		this.clas = nume;
	}
	public String getOrders() {
		return this.orders;
	}

	public void setOrders(String prenume) {
		this.orders = prenume;
	}
	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String sectie) {
		this.species = sectie;
	}
	
	public String getKingdom() {
		return this.kingdom;
	}
	public void setKingdom(String sectie) {
		this.kingdom = sectie;
	}
	
	public Set getJunctions() {
		return this.junctions;
	}

	public void setJunctions(Set consultaties) {
		this.junctions = consultaties;
	}
}




