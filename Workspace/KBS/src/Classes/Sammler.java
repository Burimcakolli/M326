package Classes;

import java.util.ArrayList;

public class Sammler {

//--Instanzvariablen
	private ArrayList<Texte>			texte				= new ArrayList();
	private ArrayList<Sitz> 			sitzplaetze 		= new ArrayList();
	private ArrayList<Saal> 			saale				= new ArrayList();
	private ArrayList<Film> 			filme 				= new ArrayList();
	private ArrayList<Vorstellung> 		vorstellungen 		= new ArrayList();
	private ArrayList<Vorstellung_Real> vorstellungen_real 	= new ArrayList();
	private ArrayList<Reservation> 		reservationen 		= new ArrayList();
	private ArrayList<Ticket> 			tickets				= new ArrayList();	
//--END Instanzvariablen
			
//--Konstruktoren
		
//--END Konstruktoren

//--Komplexere Methoden
	//-#LeCodes
//--END Komplexere Methoden
		
//--Standart Getter & Setter
	public ArrayList<Texte> getTexte() {
		return texte;
	}
	public void setTexte(ArrayList<Texte> texte) {
		this.texte = texte;
	}
	public ArrayList<Sitz> getSitzplaetze() {
		return sitzplaetze;
	}
	public void setSitzplaetze(ArrayList<Sitz> sitzplaetze) {
		this.sitzplaetze = sitzplaetze;
	}
	public ArrayList<Saal> getSaale() {
		return saale;
	}
	public void setSaale(ArrayList<Saal> saale) {
		this.saale = saale;
	}
	public ArrayList<Film> getFilme() {
		return filme;
	}
	public void setFilme(ArrayList<Film> filme) {
		this.filme = filme;
	}
	public ArrayList<Vorstellung> getVorstellungen() {
		return vorstellungen;
	}
	public void setVorstellungen(ArrayList<Vorstellung> vorstellungen) {
		this.vorstellungen = vorstellungen;
	}
	public ArrayList<Vorstellung_Real> getVorstellungen_real() {
		return vorstellungen_real;
	}
	public void setVorstellungen_real(ArrayList<Vorstellung_Real> vorstellungen_real) {
		this.vorstellungen_real = vorstellungen_real;
	}
	public ArrayList<Reservation> getReservationen() {
		return reservationen;
	}
	public void setReservationen(ArrayList<Reservation> reservationen) {
		this.reservationen = reservationen;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
//--END Standart Get/Setter

}//-class
