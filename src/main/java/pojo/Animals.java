package pojo;


import java.util.HashSet;
import java.util.Set;

public class Animals  implements java.io.Serializable {

	private Integer idanimals;
	private String name;
	private String region;
	private Set junctions = new HashSet(0);

	public Animals () {
	}

	public Animals(String name, String region, Set junctions) {
		this.name = name;
		this.region = region;
		this.junctions = junctions;
	}

	public Integer getIdanimals() {
		return this.idanimals;
	}

	public void setIdanimals(Integer idanimals) {
		this.idanimals = idanimals;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}  
	
	public Set getJunctions() {
		return this.junctions;
	}

	public void setJunctions(Set consultaties) {
		this.junctions = consultaties;
	}
}




