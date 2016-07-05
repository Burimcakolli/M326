package Classes;

import java.util.Date;

public class Vorstellung {

//--Instanzvariablen
	private int id;
	private Film laufender_film;
	private int zusatzlaenge_min;
	private Date start_datum;
	private Date end_datum;
//--END Instanzvariablen
		
//--Konstruktoren
	public Vorstellung(int id, Film laufender_film, int zusatzlaenge_min, Date start_datum, Date end_datum){
		this.setId(id);
		this.setLaufender_film(laufender_film);
		this.setZusatzlaenge_min(zusatzlaenge_min);
		this.setStart_datum(start_datum);
		this.setEnd_datum(end_datum);
	}//-Vorstellung von DB
	
	public Vorstellung(Film laufender_film, int zusatzlaenge_min, Date start_datum, Date end_datum){
		this.setLaufender_film(laufender_film);
		this.setZusatzlaenge_min(zusatzlaenge_min);
		this.setStart_datum(start_datum);
		this.setEnd_datum(end_datum);
	}//-Vorstellung noch nicht DB
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
	public Film getLaufender_film() {
		return laufender_film;
	}
	public void setLaufender_film(Film laufender_film) {
		this.laufender_film = laufender_film;
	}
	public int getZusatzlaenge_min() {
		return zusatzlaenge_min;
	}
	public void setZusatzlaenge_min(int zusatzlaenge_min) {
		this.zusatzlaenge_min = zusatzlaenge_min;
	}
	public Date getStart_datum() {
		return start_datum;
	}
	public void setStart_datum(Date start_datum) {
		this.start_datum = start_datum;
	}
	public Date getEnd_datum() {
		return end_datum;
	}
	public void setEnd_datum(Date end_datum) {
		this.end_datum = end_datum;
	}

	//--END Standart Get/Setter
	
}//-class
