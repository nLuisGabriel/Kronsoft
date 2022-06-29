package ro.kronsoft.farmacie.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class Vz_cant_PK  implements Serializable{

	private String produs;
	
	private LocalDate data;
	

	public Vz_cant_PK() {
		super();
	}


	public Vz_cant_PK(String produs, LocalDate data) {
		super();
		this.produs = produs;
		this.data = data;
	}
	
	public String getProdus() {
		return produs;
	}


	public void setProdus(String produs) {
		this.produs = produs;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	@Override
	public int hashCode() {
		return Objects.hash(data, produs);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vz_cant_PK other = (Vz_cant_PK) obj;
		return Objects.equals(data, other.data) && Objects.equals(produs, other.produs);
	}


	
	
}

