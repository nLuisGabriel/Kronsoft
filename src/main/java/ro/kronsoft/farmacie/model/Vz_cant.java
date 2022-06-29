package ro.kronsoft.farmacie.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="vz_cant")
@IdClass(Vz_cant_PK.class)
public class Vz_cant {
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long id;
	
	@Id
	@Column(name="Produs")
	private String produs;
	@Id
	@Column(name="Data")

	private LocalDate data;
	@Column(name="Trimestru")
	private String trim;
	@Column(name="Total_OutD_Cant")
	private double total_OutD_Cant;
	@Column(name="Total_OutD_Val_Vanzare_FTVA")
	private double total_OutD_Val_Vanzare_FTVA;
	@Column(name="Total_OutD_Val_Marja")
	private double total_OutD_Val_Marja;
	

	public Vz_cant() {
		super();
	}


	public Vz_cant(String produs, String an,String luna,String zi, String trim, double total_OutD_Cant,
			double total_OutD_Val_Vanzare_FTVA, double total_OutD_Val_Marja) {
		super();

		this.produs = produs;
		this.data =PrelucreazaData(an,luna,zi); 
		this.trim = trim;
		this.total_OutD_Cant = total_OutD_Cant;
		this.total_OutD_Val_Vanzare_FTVA = total_OutD_Val_Vanzare_FTVA;
		this.total_OutD_Val_Marja = total_OutD_Val_Marja;
	}


//	public long getId() {
//		return id;
//	}
//
//
//	public void setId(long id) {
//		this.id = id;
//	}


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


	public String getTrim() {
		return trim;
	}


	public void setTrim(String trim) {
		this.trim = trim;
	}


	public double getTotal_OutD_Cant() {
		return total_OutD_Cant;
	}


	public void setTotal_OutD_Cant(double total_OutD_Cant) {
		this.total_OutD_Cant = total_OutD_Cant;
	}


	public double getTotal_OutD_Val_Vanzare_FTVA() {
		return total_OutD_Val_Vanzare_FTVA;
	}


	public void setTotal_OutD_Val_Vanzare_FTVA(double total_OutD_Val_Vanzare_FTVA) {
		this.total_OutD_Val_Vanzare_FTVA = total_OutD_Val_Vanzare_FTVA;
	}


	public double getTotal_OutD_Val_Marja() {
		return total_OutD_Val_Marja;
	}


	public void setTotal_OutD_Val_Marja(double total_OutD_Val_Marja) {
		this.total_OutD_Val_Marja = total_OutD_Val_Marja;
	}


	@Override
	public String toString() {
		return "Vz_cant [produs=" + produs + ", data=" + data + ", trim=" + trim + ", total_OutD_Cant="
				+ total_OutD_Cant + ", total_OutD_Val_Vanzare_FTVA=" + total_OutD_Val_Vanzare_FTVA
				+ ", total_OutD_Val_Marja=" + total_OutD_Val_Marja + "]";
	}
	public LocalDate PrelucreazaData(String An,String luna,String zi ) {
		
		String numar_luna=luna.substring(0,2);
		
		LocalDate ld = LocalDate.of(Integer.parseInt(An), Integer.parseInt(numar_luna), Integer.parseInt(zi));
		return ld;
	}
	

	public void PrelucreazaData2(String An, String luna, String zi) {
		String numar_luna = luna.substring(0, 2);

		LocalDate ld = LocalDate.of(Integer.parseInt(An), Integer.parseInt(numar_luna), Integer.parseInt(zi));
		this.data = ld;
	}
	
	public Vz_cant_PK obtineCheie() {
		Vz_cant_PK x= new Vz_cant_PK(this.produs,this.data);
		return x;
	}
			


}
