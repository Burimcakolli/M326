package Classes;

public class Film {
	
//--Instanzvariablen
	private int id;
	private String bild_pfad;
	private String titel;
	private String beschreibung;
	private int laenge_min;
//--END Instanzvariablen
			
//--Konstruktoren
	public Film(int id, String bild_pfad, String titel, String beschreibung, int laenge_min){
		this.setId(id);
		this.setBild_pfad(bild_pfad);
		this.setTitel(titel);
		this.setBeschreibung(beschreibung);
		this.setLaenge_min(laenge_min);
	}//-Film von DB
	
	public Film(String bild_pfad, String titel, String beschreibung, int laenge_min){
		this.setBild_pfad(bild_pfad);
		this.setTitel(titel);
		this.setBeschreibung(beschreibung);
		this.setLaenge_min(laenge_min);
	}//-Film noch nicht in DB
	
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
	public String getBild_pfad() {
		return bild_pfad;
	}
	public void setBild_pfad(String bild_pfad) {
		this.bild_pfad = bild_pfad;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public int getLaenge_min() {
		return laenge_min;
	}
	public void setLaenge_min(int laenge_min) {
		this.laenge_min = laenge_min;
	}
//--END Standart Get/Setter

}//-class
