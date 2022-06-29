package ro.kronsoft.farmacie.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class StocDetPK implements Serializable {

	private String produs;
	private String producator;
	private String tip_stoc;
	private String categorie;
	private int vechimeStoc;
	private String furnizor_Nume;
	private LocalDate BBD;
	private double sc_cant;
	private double pret_Achizite;
	private double pret_unitar;
	private double val_pret_achizitie;
	public StocDetPK(String produs, String producator, String tip_stoc, String categorie, String vechimeStoc,
			String furnizor_Nume, String bBD, String sc_cant, String pret_Achizite, String pret_unitar,
			String val_pret_achizitie) {
		super();
		this.produs = produs;
		this.producator = producator;
		this.tip_stoc = tip_stoc;
		this.categorie = categorie;
		this.vechimeStoc = Integer.parseInt(vechimeStoc);
		this.furnizor_Nume = furnizor_Nume;
		BBD = PrelucreazaData(bBD); 
		this.sc_cant = Double.parseDouble(sc_cant);
		this.pret_Achizite = Double.parseDouble(pret_Achizite);
		this.pret_unitar = Double.parseDouble(pret_unitar);
		this.val_pret_achizitie = Double.parseDouble(pret_unitar);
	}
	public StocDetPK() {
		super();
	}
	public String getProdus() {
		return produs;
	}
	public void setProdus(String produs) {
		this.produs = produs;
	}
	public String getProducator() {
		return producator;
	}
	public void setProducator(String producator) {
		this.producator = producator;
	}
	public String getTip_stoc() {
		return tip_stoc;
	}
	public void setTip_stoc(String tip_stoc) {
		this.tip_stoc = tip_stoc;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getVechimeStoc() {
		return vechimeStoc;
	}
	public void setVechimeStoc(int vechimeStoc) {
		this.vechimeStoc = vechimeStoc;
	}
	public String getFurnizor_Nume() {
		return furnizor_Nume;
	}
	public void setFurnizor_Nume(String furnizor_Nume) {
		this.furnizor_Nume = furnizor_Nume;
	}
	public LocalDate getBBD() {
		return BBD;
	}
	public void setBBD(LocalDate bBD) {
		BBD = bBD;
	}
	public double getSc_cant() {
		return sc_cant;
	}
	public void setSc_cant(double sc_cant) {
		this.sc_cant = sc_cant;
	}
	public double getPret_Achizite() {
		return pret_Achizite;
	}
	public void setPret_Achizite(double pret_Achizite) {
		this.pret_Achizite = pret_Achizite;
	}
	public double getPret_unitar() {
		return pret_unitar;
	}
	public void setPret_unitar(double pret_unitar) {
		this.pret_unitar = pret_unitar;
	}
	public double getVal_pret_achizitie() {
		return val_pret_achizitie;
	}
	public void setVal_pret_achizitie(double val_pret_achizitie) {
		this.val_pret_achizitie = val_pret_achizitie;
	}
	@Override
	public int hashCode() {
		return Objects.hash(BBD, categorie, furnizor_Nume, pret_Achizite, pret_unitar, producator, produs, sc_cant,
				tip_stoc, val_pret_achizitie, vechimeStoc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StocDetPK other = (StocDetPK) obj;
		return Objects.equals(BBD, other.BBD) && Objects.equals(categorie, other.categorie)
				&& Objects.equals(furnizor_Nume, other.furnizor_Nume)
				&& Double.doubleToLongBits(pret_Achizite) == Double.doubleToLongBits(other.pret_Achizite)
				&& Double.doubleToLongBits(pret_unitar) == Double.doubleToLongBits(other.pret_unitar)
				&& Objects.equals(producator, other.producator) && Objects.equals(produs, other.produs)
				&& Double.doubleToLongBits(sc_cant) == Double.doubleToLongBits(other.sc_cant)
				&& Objects.equals(tip_stoc, other.tip_stoc)
				&& Double.doubleToLongBits(val_pret_achizitie) == Double.doubleToLongBits(other.val_pret_achizitie)
				&& vechimeStoc == other.vechimeStoc;
	}
	public LocalDate PrelucreazaData(String dataDeTrimis) {
		String[] data = dataDeTrimis.split("/");
		// 0-luna | 1-ziua |2-an
		LocalDate ld = LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		return ld;
	}
	

	
}
