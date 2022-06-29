package ro.kronsoft.farmacie.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name="evidenta")
@IdClass(EvidentaPK.class)
public class Evidenta {
	
	@Id
	@Column(name="Data")
	private LocalDate ld;
	
	@Id
	@Column(name="Ora")
	private LocalTime lt;
	
	@Id
	@Column(name="Nume_sheet")
	private String numeSheet;
	
	@Column(name="Intrari_initiale")
	private long intrariInitiale;
	
	@Column(name="Intrari_noi")
	private long intrariNoi;
	
	@Column(name="Total_intrari")
	private long totalIntrari;
	
	

	public Evidenta(long intrariInitiale,long intrariNoi, long totalIntrari, String numeSheet) {
		super();
		this.intrariInitiale=intrariInitiale;
		this.ld = LocalDate.now();
		this.lt = LocalTime.now().withNano(0);
		this.intrariNoi = intrariNoi;
		this.totalIntrari = totalIntrari;
		this.numeSheet = numeSheet;
	}

	public Evidenta() {
		this.ld = LocalDate.now();
		this.lt = LocalTime.now().withNano(0);
	}

	
	public long getIntrariInitiale() {
		return intrariInitiale;
	}

	public void setIntrariInitiale(long intrariInitiale) {
		this.intrariInitiale = intrariInitiale;
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

	public long getIntrariNoi() {
		return intrariNoi;
	}

	public void setIntrariNoi(long intrariNoi) {
		this.intrariNoi = intrariNoi;
	}

	public long getTotalIntrari() {
		return totalIntrari;
	}

	public void setTotalIntrari(long totalIntrari) {
		this.totalIntrari = totalIntrari;
	}

	public String getNumeSheet() {
		return numeSheet;
	}

	public void setNumeSheet(String numeSheet) {
		this.numeSheet = numeSheet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(intrariNoi, ld, lt, numeSheet, totalIntrari);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evidenta other = (Evidenta) obj;
		return intrariNoi == other.intrariNoi && Objects.equals(ld, other.ld) && Objects.equals(lt, other.lt)
				&& Objects.equals(numeSheet, other.numeSheet) && totalIntrari == other.totalIntrari;
	}

	@Override
	public String toString() {
		return "Evidenta [ld=" + ld + ", lt=" + lt + ", intrariNoi=" + intrariNoi + ", totalIntrari=" + totalIntrari
				+ ", numeSheet=" + numeSheet + "]";
	}

	
	
	
	
}
