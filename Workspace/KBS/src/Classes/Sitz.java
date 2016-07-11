package Classes;

public class Sitz {
	
//--Instanzvariablen
	private int id;
	private boolean aktiv;
	private int reihe;
	private int nummer;
	private Saal saalangehoerig;
//--END Instanzvariablen
			
//--Konstruktoren
	public Sitz(int id, boolean aktiv, int reihe, int nummer, Saal saalangehoerig){
		this.setId(id);
		this.setAktiv(aktiv);
		this.setReihe(reihe);
		this.setNummer(nummer);
		this.setSaalangehoerig(saalangehoerig);
	}//-Sitz von DB
	
	public Sitz(int id){
		this.setId(id);
		this.setAktiv(false);
		this.setReihe(0);
		this.setNummer(0);
		this.setSaalangehoerig(null);
	}//-Für internen Modelgebrauch
	
	public Sitz(boolean aktiv, int reihe, int nummer, Saal saalangehoerig){
		this.setAktiv(aktiv);
		this.setReihe(reihe);
		this.setNummer(nummer);
		this.setSaalangehoerig(saalangehoerig);
	}//-Sitz noch nicht DB
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
	public boolean isAktiv() {
		return aktiv;
	}
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	public int getReihe() {
		return reihe;
	}
	public void setReihe(int reihe) {
		this.reihe = reihe;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public Saal getSaalangehoerig() {
		return saalangehoerig;
	}
	public void setSaalangehoerig(Saal saalangehoerig) {
		this.saalangehoerig = saalangehoerig;
	}
//--END Standart Get/Setter

}//-class
