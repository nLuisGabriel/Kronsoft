package ro.kronsoft.farmacie.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class EvidentaPK implements Serializable{
	private LocalDate ld;
	private LocalTime lt;
	private String numeSheet;
	public EvidentaPK(LocalDate ld, LocalTime lt, String numeSheet) {
		super();
		this.ld = ld;
		this.lt = lt;
		this.numeSheet = numeSheet;
	}
	public EvidentaPK() {
		super();
	}
	public LocalDate getLd() {
		return ld;
	}
	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	public LocalTime getLt() {
		return lt;
	}
	public void setLt(LocalTime lt) {
		this.lt = lt;
	}
	public String getNumeSheet() {
		return numeSheet;
	}
	public void setNumeSheet(String numeSheet) {
		this.numeSheet = numeSheet;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ld, lt, numeSheet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvidentaPK other = (EvidentaPK) obj;
		return Objects.equals(ld, other.ld) && Objects.equals(lt, other.lt)
				&& Objects.equals(numeSheet, other.numeSheet);
	}
	@Override
	public String toString() {
		return "EvientaCheiePrimara [ld=" + ld + ", lt=" + lt + ", numeSheet=" + numeSheet + "]";
	}
	
	
	
}
