package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sammler {

//--Instanzvariablen
	private ArrayList<Texte>			texte				= new ArrayList();
	private ArrayList<Saal> 	saale			= new ArrayList<Saal>();
	private ArrayList<Sitz>	sitze = new ArrayList<Sitz>();
	private ArrayList<Film> 			filme 				= new ArrayList<Film>();
	private ArrayList<Vorstellung> 		vorstellungen 		= new ArrayList<Vorstellung>();
	private ArrayList<Vorstellung_Real> vorstellungen_real 	= new ArrayList<Vorstellung_Real>();
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
	
	private void loadVorstellungen_Real(Vorstellung vorstellung){
		this.setVorstellungen_real(db.get_Vorstellungen_RealFkVorstellung(vorstellung));
	}//-loadVorstellungen_Real
	
	private void loadReservationen(){
		this.setReservationen(db.getAll_Reservationen());
	}//-loadReservationen
	
	public ArrayList<Sitz> get_SitzFkSaal(Saal saal){
		this.setSitze(db.get_SitzFkSaal(saal));
		return this.getSitze();
	}//-Saal
	
//--END Komplexere Methoden
		
//--Standart Getter & Setter
	public ArrayList<Texte> getTexte() {
		return texte;
	}

	public void setTexte(ArrayList<Texte> texte) {
		this.texte = texte;
	}

	public ArrayList<Sitz> getSitze() {
		return sitze;
	}

	public void setSitze(ArrayList<Sitz> sitze) {
		this.sitze = sitze;
	}

	public ArrayList<Saal> getSaale() {
		this.loadSaale();
		return saale;
	}

	public void setSaale(ArrayList<Saal> saale) {
		this.saale = saale;
	}

	public ArrayList<Film> getFilme() {
		this.loadFilme();
		return filme;
	}

	public void setFilme(ArrayList<Film> filme) {
		this.filme = filme;
	}

	public ArrayList<Vorstellung> getVorstellungen() {
		this.loadVorstellungen();
		return vorstellungen;
	}

	public void setVorstellungen(ArrayList<Vorstellung> vorstellungen) {
		this.vorstellungen = vorstellungen;
	}

	public ArrayList<Vorstellung_Real> getVorstellungen_realFkVorstellung(Vorstellung vorstellung) {
		this.loadVorstellungen_Real(vorstellung);
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
