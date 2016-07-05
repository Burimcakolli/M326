package Classes;

import java.util.Date;

public class Reservation {
	
//--Instanzvariablen
	private int id;
	private String telnumer;
	private Date erfassungsdatum;
	private Vorstellung_Real gebuchte_Vorstellung;
//--END Instanzvariablen
		
//--Konstruktoren
	public Reservation(int id, String telnummer, Date erfassungsdatum, Vorstellung_Real gebuchte_Vorstellung){
		this.setId(id);
		this.setTelnumer(telnummer);
		this.setErfassungsdatum(erfassungsdatum);
		this.setGebuchte_Vorstellung(gebuchte_Vorstellung);
	}//-Reservation von DB
	
	public Reservation(String telnummer, Date erfassungsdatum, Vorstellung_Real gebuchte_Vorstellung){
		this.setTelnumer(telnummer);
		this.setErfassungsdatum(erfassungsdatum);
		this.setGebuchte_Vorstellung(gebuchte_Vorstellung);
	}//-Reservation noch nicht DB
	
//--END Konstruktoren

//--Komplexere Methoden
		//-#LeCodes
//--END Komplexere Methoden
		
//--Standart Getter & Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelnumer() {
		return telnumer;
	}
	public void setTelnumer(String telnumer) {
		this.telnumer = telnumer;
	}
	public Date getErfassungsdatum() {
		return erfassungsdatum;
	}
	public void setErfassungsdatum(Date erfassungsdatum) {
		this.erfassungsdatum = erfassungsdatum;
	}
	public Vorstellung_Real getGebuchte_Vorstellung() {
		return gebuchte_Vorstellung;
	}
	public void setGebuchte_Vorstellung(Vorstellung_Real gebuchte_Vorstellung) {
		this.gebuchte_Vorstellung = gebuchte_Vorstellung;
	}
//--END Standart Get/Setter

}//-class
