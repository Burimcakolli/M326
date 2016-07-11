package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sammler {

//--Instanzvariablen
	private ArrayList<Texte>			texte				= new ArrayList();
	private Map<Saal,ArrayList<Sitz>> 	saale			= new HashMap();
	private ArrayList<Film> 			filme 				= new ArrayList();
	private Map<Vorstellung, ArrayList<Vorstellung_Real>> 		vorstellungen 		= new HashMap();
	private ArrayList<Vorstellung_Real> vorstellungen_real 	= new ArrayList();
	private Map<Reservation, ArrayList<Ticket>> 		reservationen 		= new HashMap();
	private MySQLConnection db = new MySQLConnection();
//--END Instanzvariablen
			
//--Konstruktoren
		
//--END Konstruktoren
	
//--Komplexere Methoden
	private void loadSaale(){
		this.setSaale(db.getAll_Saal()); 
	}//-loadSaale

	private void loadFilme(){
		this.setFilme(db.getAll_Filme());
	}//-loadFilme
	
	private void loadVorstellungen(){
		this.setVorstellungen(db.getAll_Vorstellungen());
	}//-loadVorstellungen
	
	private void loadReservationen(){
		this.setReservationen(db.getAll_Reservationen());
	}//-loadReservationen
	
//--END Komplexere Methoden
		
//--Standart Getter & Setter
	public ArrayList<Texte> getTexte() {
		return texte;
	}

	public void setTexte(ArrayList<Texte> texte) {
		this.texte = texte;
	}

	public Map<Saal, ArrayList<Sitz>> getSaale() {
		this.loadSaale();
		return saale;
	}

	public void setSaale(Map<Saal, ArrayList<Sitz>> saale) {
		this.saale = saale;
	}

	public ArrayList<Film> getFilme() {
		this.loadFilme();
		return filme;
	}

	public void setFilme(ArrayList<Film> filme) {
		this.filme = filme;
	}

	public Map<Vorstellung, ArrayList<Vorstellung_Real>> getVorstellungen() {
		this.loadVorstellungen();
		return vorstellungen;
	}

	public void setVorstellungen(Map<Vorstellung, ArrayList<Vorstellung_Real>> vorstellungen) {
		this.vorstellungen = vorstellungen;
	}

	public ArrayList<Vorstellung_Real> getVorstellungen_real() {
		return vorstellungen_real;
	}

	public void setVorstellungen_real(ArrayList<Vorstellung_Real> vorstellungen_real) {
		this.vorstellungen_real = vorstellungen_real;
	}

	public Map<Reservation, ArrayList<Ticket>>  getReservationen() {
		this.loadReservationen();
		return reservationen;
	}

	public void setReservationen(Map<Reservation, ArrayList<Ticket>>  reservationen) {
		this.reservationen = reservationen;
	}

	public MySQLConnection getDb() {
		return db;
	}

	public void setDb(MySQLConnection db) {
		this.db = db;
	}
	
	
//--END Standart Get/Setter

}//-class
