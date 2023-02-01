package pojo;

public class Junction  implements java.io.Serializable {

	private Integer idjunction;
	private Animals animals;
	private Characteristics characteristics;

	public Junction() {
	}

	public Junction(Animals animals, Characteristics characteristics) {
		this.animals = animals;
		this.characteristics = characteristics;
	}

	public Integer getIdjunction() {
		return this.idjunction;
	}

	public void setIdjunction(Integer idconsultatie) {
		this.idjunction = idconsultatie;
	}
	public Animals getAnimals() {
		return this.animals;
	}

	public void setAnimals (Animals medici) {
		this.animals = medici;
	}
	public Characteristics getCharacteristics() {
		return this.characteristics;
	}

	public void setCharacteristics(Characteristics pacienti) {
		this.characteristics = pacienti;
	}
	
}




