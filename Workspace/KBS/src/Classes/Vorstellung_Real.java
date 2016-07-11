package Classes;

import java.util.Date;

public class Vorstellung_Real {

//--Instanzvariablen
	private int id;
	private Date abspiel_zeit_effektiv;
	private Saal spielt_in_saal;
	private Vorstellung vorstellungsinfos;
//--END Instanzvariablen
		
//--Konstruktoren
	public Vorstellung_Real(int id, Date abspiel_zeit_effektiv, Saal spielt_in_saal, Vorstellung vorstellungsinfos){
		this.setId(id);
		this.setAbspiel_zeit_effektiv(abspiel_zeit_effektiv);
		this.setSpielt_in_saal(spielt_in_saal);
		this.setVorstellungsinfos(vorstellungsinfos);
	}//-Vorstellung_Real von DB
	
	public Vorstellung_Real(int id){
		this.setId(id);
		this.setAbspiel_zeit_effektiv(null);
		this.setSpielt_in_saal(null);
		this.setVorstellungsinfos(null);
	}//-Vorstellung_Real für internen Modelgebrauch
	
	public Vorstellung_Real(Date abspiel_zeit_effektiv, Saal spielt_in_saal, Vorstellung vorstellungsinfos){
		this.setAbspiel_zeit_effektiv(abspiel_zeit_effektiv);
		this.setSpielt_in_saal(spielt_in_saal);
		this.setVorstellungsinfos(vorstellungsinfos);
	}//-Vorstellung_Real noch nicht DB
	
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
	public Date getAbspiel_zeit_effektiv() {
		return abspiel_zeit_effektiv;
	}
	public void setAbspiel_zeit_effektiv(Date abspiel_zeit_effektiv) {
		this.abspiel_zeit_effektiv = abspiel_zeit_effektiv;
	}
	public Saal getSpielt_in_saal() {
		return spielt_in_saal;
	}
	public void setSpielt_in_saal(Saal spielt_in_saal) {
		this.spielt_in_saal = spielt_in_saal;
	}
	public Vorstellung getVorstellungsinfos() {
		return vorstellungsinfos;
	}
	public void setVorstellungsinfos(Vorstellung vorstellungsinfos) {
		this.vorstellungsinfos = vorstellungsinfos;
	}
//--END Standart Get/Setter
	
}//-class
