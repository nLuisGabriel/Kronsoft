package ro.kronsoft.farmacie.model;



import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="stoc_detaliat")
@IdClass(StocDetPK.class)
public class Stoc_detaliat {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
	
	
	@Column(name="Cod")
	private String cod;
	@Column(name="CodCAS")
	private String codCAS;
	@Id
	@Column(name="Produs")
	private String produs;
	@Id
	@Column(name="Producator")
	private String producator;
	@Id
	@Column(name="Tip_stoc")
	private String tip_stoc;
	@Id
	@Column(name="Categorie")
	private String categorie;
	@Id
	@Column(name="VechimeStoc")
	private int vechimeStoc;
	@Id
	@Column(name="Furnizor_Nume")
	private String furnizor_Nume;
	@Id
	@Column(name="BBD")
	private  LocalDate BBD;
	@Id
	@Column(name="sc_cant")
	private double sc_cant;
	@Id
	@Column(name=" Pret_Achizite")
	private double  pret_Achizite;
	@Id
	@Column(name="pret_unitar")
	private double pret_unitar;
	@Id
	@Column(name="val_pret_achizitie")
	private double val_pret_achizitie;
	public Stoc_detaliat() {
		super();
	}
	public Stoc_detaliat(String cod, String codCAS, String produs, String producator, String tip_stoc,
			String categorie, int vechimeStoc, String furnizor_Nume, LocalDate bBD, double sc_cant,
			double pret_Achizite, double pret_unitar, double val_pret_achizitie) {
		super();
		
		this.cod = cod;
		this.codCAS = codCAS;
		this.produs = produs;
		this.producator = producator;
		this.tip_stoc = tip_stoc;
		this.categorie = categorie;
		this.vechimeStoc = vechimeStoc;
		this.furnizor_Nume = furnizor_Nume;
		BBD = bBD;
		this.sc_cant = sc_cant;
		this.pret_Achizite = pret_Achizite;
		this.pret_unitar = pret_unitar;
		this.val_pret_achizitie = val_pret_achizitie;
	}
//	public long getId() {
//		return id;
//	}

	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCodCAS() {
		return codCAS;
	}
	public void setCodCAS(String codCAS) {
		this.codCAS = codCAS;
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
	public String toString() {
		return "Stoc_detaliat [cod=" + cod + ", codCAS=" + codCAS + ", produs=" + produs + ", producator=" + producator
				+ ", tip_stoc=" + tip_stoc + ", categorie=" + categorie + ", vechimeStoc=" + vechimeStoc
				+ ", furnizor_Nume=" + furnizor_Nume + ", BBD=" + BBD + ", sc_cant=" + sc_cant + ", pret_Achizite="
				+ pret_Achizite + ", pret_unitar=" + pret_unitar + ", val_pret_achizitie=" + val_pret_achizitie + "]";
	}

	public void seteazaData(String data) {
		String[] informatiiData=data.split("/"); //y m d 
		LocalDate dataDeTrimis=LocalDate.of(Integer.parseInt(informatiiData[2]), Integer.parseInt(informatiiData[0]), Integer.parseInt(informatiiData[1]));
		this.setBBD(dataDeTrimis);
	}
	
	
	
	
	
	
}
