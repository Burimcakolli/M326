package Classes;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SitzPlatzFeld extends Button{
	private Sitz mySitz;
	private boolean besetzt_Sitz = false;
	private String userPath = System.getProperty("user.dir");
	private Image inaktiv_Bild;
	private Image frei_Bild;
	private Image besetzt_Bild;
	
	public SitzPlatzFeld(Sitz mySitz, boolean besetzt){
		this.setUserPath(this.getUserPath().replace("\\", "/"));
		this.setMySitz(mySitz);
		this.setBesetzt_Sitz(besetzt);
		this.setInaktiv_Bild(new Image(getClass().getResourceAsStream("/Views/Icons/KinoStuhlInaktiv.PNG")));
		this.setFrei_Bild(new Image(getClass().getResourceAsStream("/Views/Icons/KinoStuhlFrei.PNG")));
		this.setBesetzt_Bild(new Image(getClass().getResourceAsStream("/Views/Icons/KinoStuhlBesetzt.PNG")));
		System.out.println("Ich wurde erzeugt");
		if(this.mySitz.isAktiv() == true){
			System.out.println("ist Aktiv");
			
		}//-if
		else{
			System.out.println("ist Inaktiv");
			this.setGraphic(new ImageView(this.getInaktiv_Bild()));
		}
			
	}
	
	public SitzPlatzFeld(){
		System.out.println("Wurde erzeugt");
	}
	
	
	public String getUserPath() {
		return userPath;
	}

	public void setUserPath(String userPath) {
		this.userPath = userPath;
	}


	public Image getInaktiv_Bild() {
		return inaktiv_Bild;
	}
	public void setInaktiv_Bild(Image inaktiv_Bild) {
		this.inaktiv_Bild = inaktiv_Bild;
	}

	public Image getFrei_Bild() {
		return frei_Bild;
	}

	public void setFrei_Bild(Image frei_Bild) {
		this.frei_Bild = frei_Bild;
	}

	public Image getBesetzt_Bild() {
		return besetzt_Bild;
	}

	public void setBesetzt_Bild(Image besetzt_Bild) {
		this.besetzt_Bild = besetzt_Bild;
	}

	public Sitz getMySitz() {
		return mySitz;
	}
	public void setMySitz(Sitz mySitz) {
		this.mySitz = mySitz;
	}
	public boolean isBesetzt_Sitz() {
		return besetzt_Sitz;
	}
	public void setBesetzt_Sitz(boolean besetzt_Sitz) {
		this.besetzt_Sitz = besetzt_Sitz;
	}

}//-Class
