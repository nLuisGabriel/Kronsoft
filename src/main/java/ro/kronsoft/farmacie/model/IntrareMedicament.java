package ro.kronsoft.farmacie.model;



import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="intrari_medicamente")
@IdClass(Intrari_PK.class)
public class IntrareMedicament {

	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
	@Column(name="nume_furnizor")
	
	private String numeFurnizor;
	@Column(name="tip_stoc")
	private String tipStoc;
	
	@Column(name="agent_furnizor")
	private String agentFurnizor; 
	@Id
	@Column(name="produs")
	private String produs;
	
	@Column(name="cod_cas")
	private String codCas;
	@Id
	@Column(name="bbd_date")
	private LocalDate BBD;
	@Id
	@Column(name="tip_lot")
	private String lot;
	@Id
	@Column(name="numar_doc_intrare")
	private long numarDocIntrare;
	@Id
	@Column(name="data_doc_intrare")
	private LocalDate dataDocIntrare;
	
	@Column(name="nume_moneda")
	private String numeMoneda;
	
	@Column(name="pret_achizitie_valuta")
	private double pretAchizitieValuta;
	@Id
	@Column(name="cantitate_medicament")
	private int cantitate;
	
	@Column(name="valoare_achizitie_discountat")
	private double valoareAchizitieDiscountat;
	
	@Column(name="valoare_discount_achizitie")
	private double valoareDiscountAchizitie;
	
	
	@Column(name="pret_achizitie")
	private double pretAchizitie;

	
//	public IntrareMedicament(String numeFurnizor, String agentFurnizor, String produs, String codCas, String bBD,
//			String lot, long numarDocIntrare, String dataDocIntrare, String numeMoneda, double pretAchizitieValuta,
//			int cantitate, double valoareAchizitieDiscountat, double valoareDiscountAchizitie, double pretAchizitie) {
//		this.numeFurnizor = numeFurnizor;
//		this.agentFurnizor = agentFurnizor;
//		this.produs = produs;
//		this.codCas = codCas;
//		BBD = PrelucreazaData(bBD);
//		this.lot = lot;
//		this.numarDocIntrare = numarDocIntrare;
//		this.dataDocIntrare = PrelucreazaData(dataDocIntrare);
//		this.numeMoneda = numeMoneda;
//		this.pretAchizitieValuta = pretAchizitieValuta;
//		this.cantitate = cantitate;
//		this.valoareAchizitieDiscountat = valoareAchizitieDiscountat;
//		this.valoareDiscountAchizitie = valoareDiscountAchizitie;
//		this.pretAchizitie = pretAchizitie;
//	}
	
	
	
	public IntrareMedicament(String numeFurnizor, String tipStoc, String agentFurnizor, String produs, String codCas,
			String bBD, String lot, long numarDocIntrare, String dataDocIntrare, String numeMoneda,
			double pretAchizitieValuta, int cantitate, double valoareAchizitieDiscountat,
			double valoareDiscountAchizitie, double pretAchizitie) {
		super();
		this.numeFurnizor = numeFurnizor;
		this.tipStoc = tipStoc;
		this.agentFurnizor = agentFurnizor;
		this.produs = produs;
		this.codCas = codCas;
		BBD = PrelucreazaData(bBD);
		this.lot = lot;
		this.numarDocIntrare = numarDocIntrare;
		this.dataDocIntrare = PrelucreazaData(dataDocIntrare);
		this.numeMoneda = numeMoneda;
		this.pretAchizitieValuta = pretAchizitieValuta;
		this.cantitate = cantitate;
		this.valoareAchizitieDiscountat = valoareAchizitieDiscountat;
		this.valoareDiscountAchizitie = valoareDiscountAchizitie;
		this.pretAchizitie = pretAchizitie;
	}



	public IntrareMedicament() {
		super();
	}


	public IntrareMedicament(double pretAchizitieValuta, int cantitate, LocalDate bBD, LocalDate dataDocIntrare,
			String codCas, String numeMoneda, String produs, String numeFurnizor, double pretAchizitie, String lot,
			double valoareDiscountAchizitie, double valoareAchizitieDiscountat, String agentFurnizor,
			long numarDocIntrare) {
		super();
		this.pretAchizitieValuta = pretAchizitieValuta;
		this.cantitate = cantitate;
		BBD = bBD;
		this.dataDocIntrare = dataDocIntrare;
		this.codCas = codCas;
		this.numeMoneda = numeMoneda;
		this.produs = produs;
		this.numeFurnizor = numeFurnizor;
		this.pretAchizitie = pretAchizitie;
		this.lot = lot;
		this.valoareDiscountAchizitie = valoareDiscountAchizitie;
		this.valoareAchizitieDiscountat = valoareAchizitieDiscountat;
		this.agentFurnizor = agentFurnizor;
		this.numarDocIntrare = numarDocIntrare;
	}



	public LocalDate PrelucreazaData(String dataDeTrimis) {
		String[] data = dataDeTrimis.split("/");
		//0-luna | 1-ziua |2-an
		LocalDate ld = LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		return ld;
	}

	
	

	public String getTipStoc() {
		return tipStoc;
	}



	public void setTipStoc(String tipStoc) {
		this.tipStoc = tipStoc;
	}



	public String getNumeFurnizor() {
		return numeFurnizor;
	}

	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}

	public String getAgentFurnizor() {
		return agentFurnizor;
	}

	public void setAgentFurnizor(String agentFurnizor) {
		this.agentFurnizor = agentFurnizor;
	}

	public String getProdus() {
		return produs;
	}

	public void setProdus(String produs) {
		this.produs = produs;
	}

	public String getCodCas() {
		return codCas;
	}

	public void setCodCas(String codCas) {
		this.codCas = codCas;
	}

	public LocalDate getBBD() {
		return BBD;
	}

	
	
	
	
	public void setBBD(LocalDate bBD) {
		BBD = bBD;
	}



	public void setDataDocIntrare(LocalDate dataDocIntrare) {
		this.dataDocIntrare = dataDocIntrare;
	}

	
	public void setDataDocIntrare2(String data2) {
		String[] data = data2.split("/");
		this.dataDocIntrare=LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[0]), Integer.parseInt(data[1]));
	}
	

	public void setBBD2(String bBD) {
		String[] data = bBD.split("/");
		//0-luna | 1-ziua |2-an
		BBD= LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[0]), Integer.parseInt(data[1]));

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

	public String getNumeMoneda() {
		return numeMoneda;
	}

	public void setNumeMoneda(String numeMoneda) {
		this.numeMoneda = numeMoneda;
	}

	public double getPretAchizitieValuta() {
		return pretAchizitieValuta;
	}

	public void setPretAchizitieValuta(double pretAchizitieValuta) {
		this.pretAchizitieValuta = pretAchizitieValuta;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public double getValoareAchizitieDiscountat() {
		return valoareAchizitieDiscountat;
	}

	public void setValoareAchizitieDiscountat(double valoareAchizitieDiscountat) {
		this.valoareAchizitieDiscountat = valoareAchizitieDiscountat;
	}

	public double getValoareDiscountAchizitie() {
		return valoareDiscountAchizitie;
	}

	public void setValoareDiscountAchizitie(double valoareDiscountAchizitie) {
		this.valoareDiscountAchizitie = valoareDiscountAchizitie;
	}

	public double getPretAchizitie() {
		return pretAchizitie;
	}

	public void setPretAchizitie(double pretAchizitie) {
		this.pretAchizitie = pretAchizitie;
	}



	@Override
	public String toString() {
		return "IntrareMedicament [numeFurnizor=" + numeFurnizor + ", agentFurnizor=" + agentFurnizor + ", produs="
				+ produs + ", codCas=" + codCas + ", BBD=" + BBD + ", lot=" + lot + ", numarDocIntrare="
				+ numarDocIntrare + ", dataDocIntrare=" + dataDocIntrare + ", numeMoneda=" + numeMoneda
				+ ", pretAchizitieValuta=" + pretAchizitieValuta + ", cantitate=" + cantitate
				+ ", valoareAchizitieDiscountat=" + valoareAchizitieDiscountat + ", valoareDiscountAchizitie="
				+ valoareDiscountAchizitie + ", pretAchizitie=" + pretAchizitie + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(BBD, agentFurnizor, cantitate, codCas, dataDocIntrare, lot, numarDocIntrare, numeFurnizor,
				numeMoneda, pretAchizitie, pretAchizitieValuta, produs, valoareAchizitieDiscountat,
				valoareDiscountAchizitie);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntrareMedicament other = (IntrareMedicament) obj;
		return Objects.equals(BBD, other.BBD) && Objects.equals(agentFurnizor, other.agentFurnizor)
				&& cantitate == other.cantitate && Objects.equals(codCas, other.codCas)
				&& Objects.equals(dataDocIntrare, other.dataDocIntrare) && Objects.equals(lot, other.lot)
				&& numarDocIntrare == other.numarDocIntrare && Objects.equals(numeFurnizor, other.numeFurnizor)
				&& Objects.equals(numeMoneda, other.numeMoneda)
				&& Double.doubleToLongBits(pretAchizitie) == Double.doubleToLongBits(other.pretAchizitie)
				&& Double.doubleToLongBits(pretAchizitieValuta) == Double.doubleToLongBits(other.pretAchizitieValuta)
				&& Objects.equals(produs, other.produs)
				&& Double.doubleToLongBits(valoareAchizitieDiscountat) == Double
						.doubleToLongBits(other.valoareAchizitieDiscountat)
				&& Double.doubleToLongBits(valoareDiscountAchizitie) == Double
						.doubleToLongBits(other.valoareDiscountAchizitie);
	}



	






	
	
	
	
	
	
	
}
