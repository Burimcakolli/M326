package Classes;

public class Ticket{

//--Instanzvariablen
	private int id;
	private Sitz sitzplatz;
	private Reservation reservierung;
//--END Instanzvariablen
		
//--Konstruktoren
	public Ticket(int id, Sitz sitzplatz, Reservation reservierung){
		this.setId(id);
		this.setSitzplatz(sitzplatz);
		this.setReservierung(reservierung);
	}//-Ticket von DB
	
	public Ticket(Sitz sitzplatz, Reservation reservierung){
		this.setSitzplatz(sitzplatz);
		this.setReservierung(reservierung);
	}//-Ticket noch nicht DB
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
	public Sitz getSitzplatz() {
		return sitzplatz;
	}
	public void setSitzplatz(Sitz sitzplatz) {
		this.sitzplatz = sitzplatz;
	}
	public Reservation getReservierung() {
		return reservierung;
	}
	public void setReservierung(Reservation reservierung) {
		this.reservierung = reservierung;
	}
//--END Standart Get/Setter
		
}//-class
