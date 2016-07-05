package Classes;

//Die Klasse ist für jegliche Textausgaben via GUI/TUI Zuständig
public class Texte {
	
//--Instanzvariablen
	private int id;
	private String textinhalt;
//--END Instanzvariablen	
		
//--Konstruktoren
	public Texte(int id, String textinhalt){
		this.setId(id);
		this.setTextinhalt(textinhalt);
	}//-Texte von DB
	
	public Texte(String textinhalt) {
		this.setTextinhalt(textinhalt);
	}//-Texte noch nicht DB
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
	public String getTextinhalt() {
		return textinhalt;
	}
	public void setTextinhalt(String textinhalt) {
		this.textinhalt = textinhalt;
	}
//--END Standart Get/Setter

}//-Class
