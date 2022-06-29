package ro.kronsoft.farmacie.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class Intrari_PK implements Serializable{


	private String produs;
	private LocalDate BBD;
	private String lot;
	private long numarDocIntrare;
	private LocalDate dataDocIntrare;
	private int cantitate;
	public Intrari_PK() {
		super();
	}
	public Intrari_PK(String produs, LocalDate bBD, String lot, long numarDocIntrare, LocalDate dataDocIntrare,
			int cantitate) {
		super();
		this.produs = produs;
		BBD = bBD;
		this.lot = lot;
		this.numarDocIntrare = numarDocIntrare;
		this.dataDocIntrare = dataDocIntrare;
		this.cantitate = cantitate;
	}
	public String getProdus() {
		return produs;
	}
	public void setProdus(String produs) {
		this.produs = produs;
	}
	public LocalDate getBBD() {
		return BBD;
	}
	public void setBBD(LocalDate bBD) {
		BBD = bBD;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public long getNumarDocIntrare() {
		return numarDocIntrare;
	}
	public void setNumarDocIntrare(long numarDocIntrare) {
		this.numarDocIntrare = numarDocIntrare;
	}
	public LocalDate getDataDocIntrare() {
		return dataDocIntrare;
	}
	public void setDataDocIntrare(LocalDate dataDocIntrare) {
		this.dataDocIntrare = dataDocIntrare;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(BBD, cantitate, dataDocIntrare, lot, numarDocIntrare, produs);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intrari_PK other = (Intrari_PK) obj;
		return Objects.equals(BBD, other.BBD) && cantitate == other.cantitate
				&& Objects.equals(dataDocIntrare, other.dataDocIntrare) && Objects.equals(lot, other.lot)
				&& numarDocIntrare == other.numarDocIntrare && Objects.equals(produs, other.produs);
	}
	
	
}

