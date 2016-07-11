/*******************
 * @author Burim & Toshiki
 * Erstellt: 21.06.2016 
 * Auftrag : TBZ 
 *******************/
package Classes;

public class Saal {

//--Instanzvariablen
	private int id;
	private String beschreibung;
	private int x;
	private int y;
//--END Instanzvariablen
	
//--Konstruktoren
	public Saal(int id, String beschreibung, int x, int y){
		this.setId(id);
		this.setBeschreibung(beschreibung);
		this.setX(x);
		this.setY(y);	
	}//-Contstructor von DB
		
	public Saal(int id){
		this.setId(id);
		this.setBeschreibung(null);
		this.setX(0);
		this.setY(0);	
	}//-Contstructor für internen Modelgebrauch
			
	public Saal(String beschreibung, int x, int y){
		this.setBeschreibung(beschreibung);
		this.setX(x);
		this.setY(y);
	}//-Contstructor noch nicht DB
	
//--END Konstruktoren

//--Komplexere Methoden
	//-#LeCodes
//--END Komplexere Methoden
	
//--Standart Getter & Setter
	public int getId() {
		return id;
	}//-getId
	public void setId(int id) {
		this.id = id;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
//--END Standart Get/Setter
	
}//-Saal
