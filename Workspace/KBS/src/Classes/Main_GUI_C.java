package Classes;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import Controllers.KBS_C;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class Main_GUI_C implements Initializable{
	
	//-Start
	@FXML
	private Button button_Load;
	@FXML
	private GridPane grid;
	@FXML
	private Button save;
	//-End Start
	
	//-Saal 
	@FXML
	private Button new_Saal;
	@FXML
	private TextField x_int;
	@FXML
	private TextField y_int;
	@FXML
	private ListView saal_auflistung;
	@FXML
	private GridPane saalordnung_bearbeiten;
	@FXML
	private TextField saalbeschreibung_erfassen;
	private Saal selectedSaal_bearbeitung = null;
	private ArrayList<Sitz> selectedSitzplatzordnung_bearbeitung = null;
	//-End Saal 
	
	//-Film
	@FXML
	private TextField filmtitel_erfassen;
	@FXML
	private TextField bildpfad_erfassen;
	@FXML
	private TextField laengemin_erfassen;
	@FXML
	private TextArea beschreibung_erfassen;
	@FXML
	private Button film_speichern_erfassen;
	//-End Film	
	
	//-Vorstellung
	@FXML
	private ListView<Vorstellung> vorstellungen_liste_verwalten;
	private ArrayList<Vorstellung> vorstellungen_verwalten;
	private Vorstellung vorstellung_selected_verwalten;
	@FXML
	private ListView vorstellungen_real_liste_verwalten;
	private ArrayList<Vorstellung_Real> vorstellungen_real_verwalten;
	//-End Vorstellung
	
	private KBS_C hauptcontroller = new KBS_C();

	
//GUI direkte Arbeitsmethoden
	//Alarmbox ausrufezeichen
	public void alert(String titel, String header, String context){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titel);
		alert.setHeaderText(header);
		alert.setContentText(context);
		alert.showAndWait();
	}//-alert
	
	//-Ladet die Kinositzansicht in das Saalverwaltungsfenster
	public void load_sitzplatzverwaltung(){    
		this.saalordnung_bearbeiten.getChildren().clear();
		GridPane newgrid = new GridPane();
		Rectangle rec = new Rectangle();
		rec.setWidth(300);
		rec.setHeight(100);
		rec.setFill(Color.WHITE);
		newgrid.setGridLinesVisible(false);
        
        for(int reihe = 0; reihe < selectedSaal_bearbeitung.getY();reihe++){
			for(int nummer = 0; nummer < selectedSaal_bearbeitung.getX();nummer++){
		         for(int suche = 0; suche < selectedSitzplatzordnung_bearbeitung.size(); suche++){
		        	 if(selectedSitzplatzordnung_bearbeitung.get(suche).getNummer() == nummer && selectedSitzplatzordnung_bearbeitung.get(suche).getReihe() == reihe){
		        		 SitzPlatzFeld sitzplatzfeld = new SitzPlatzFeld(selectedSitzplatzordnung_bearbeitung.get(suche), false);
		        		 newgrid.add(sitzplatzfeld, nummer, reihe);
		        		 sitzplatzfeld.setOnAction(new EventHandler<ActionEvent>() {
			        		 @Override public void handle(ActionEvent e) {
			        			 if(sitzplatzfeld.getMySitz().isAktiv() == true){
			        				 sitzplatzfeld.getMySitz().setAktiv(false);
			        			 }//-if
			        			 else{
			        				 sitzplatzfeld.getMySitz().setAktiv(true);
			        			 }//-else
			        			 setSitz(sitzplatzfeld.getMySitz());
			        		 }//-override
		        		 });
		        		 break;
		        	 }//-if
		         }//-for	         
			}//-for
		}//-for
        
        saalordnung_bearbeiten.add(rec, 0, 0);
        saalordnung_bearbeiten.add(newgrid, 0, 1);
        newgrid.setAlignment(Pos.CENTER);
        saalordnung_bearbeiten.setHalignment(rec, HPos.CENTER);    
	}
	
	//Leert alle Textfelder für Neu-Eingabe
	public void erfasseFilmLeeren(){
		this.bildpfad_erfassen.setText("");
		this.filmtitel_erfassen.setText("");
		this.beschreibung_erfassen.setText("");
		this.laengemin_erfassen.setText("");
	}//-erfasseFilmLeeren
	
//END GUI direkte Arbeitsmethoden	
	
//Eventlisteners und loaders
	//-Fügt einen neuen Saal hinzu
	public void addNewSaal(){
		Saal saal = new Saal(this.saalbeschreibung_erfassen.getText(), Integer.parseInt(this.x_int.getText()), Integer.parseInt(this.y_int.getText()));
		hauptcontroller.erfasseSaal(saal);
		this.loadSaaleAuflistung();
	}
	
	//-Ladet die angewählte Sitzplatzordnung in die View
	public void zeigeSaal(){
		this.selectedSaal_bearbeitung = (Saal) saal_auflistung.getSelectionModel().getSelectedItem();
		this.selectedSitzplatzordnung_bearbeitung = hauptcontroller.getSitzeFkSaal(this.selectedSaal_bearbeitung);	
		this.load_sitzplatzverwaltung();
	}
	
	//-Ladet die Liste der Saale neu
	public void loadSaaleAuflistung(){
		ArrayList<Saal> saale = new ArrayList<Saal>();
		for (int i = 0; i < hauptcontroller.getSaale().size(); i++) {
		    saale.add(hauptcontroller.getSaale().get(i));
		}//-for		
		ObservableList<Saal> items =FXCollections.observableArrayList (saale);
		saal_auflistung.setItems(items); 
		saal_auflistung.setCellFactory(new Callback<ListView<Saal>, ListCell<Saal>>(){
			@Override
			public ListCell<Saal> call(ListView<Saal> p){
				ListCell<Saal> cell = new ListCell<Saal>(){
					@Override
					protected void updateItem(Saal saal, boolean bln){
					super.updateItem(saal, bln);
						if(saal!=null){
							setText(saal.getBeschreibung());
						}//-if
					}			
				};
				return cell;
			}
		});
	}//-loadSaaleAuflistung
	
	public void setListView_Items_ToString(){
	//	public ListCell<>
	}

	public void loadVorstellungenAuflistung(){
		ArrayList<Vorstellung> vorstellungen = hauptcontroller.getVorstellungen();
		ObservableList<Vorstellung> items =FXCollections.observableArrayList (vorstellungen);
		vorstellungen_liste_verwalten.setItems(items); 
		//vorstellungen.setCellFactory()
	}//-loadVorstellungenAuflistung
	
	public void loadVorstellungenRealAuflistung(){
		this.vorstellung_selected_verwalten = vorstellungen_liste_verwalten.getSelectionModel().getSelectedItem();
		ArrayList<Vorstellung_Real> vorstellungen_real = hauptcontroller.getVorstellungenReal(this.vorstellung_selected_verwalten);
		ObservableList<Vorstellung_Real> items = FXCollections.observableArrayList (vorstellungen_real);
		vorstellungen_real_liste_verwalten.setItems(items);
	}//-loadVorstellungenRealAuflistung //hier
	
	//Setzt den angeglickten Sitzplatz auf Aktiv/inaktiv
	public void setSitz(Sitz sitz){
		hauptcontroller.setzeSitz(sitz);
		this.zeigeSaal();
	}//-setSitz
		
	public void addNewFilm(){
		System.out.println("erfassefilm");
		if(this.filmtitel_erfassen.getText().equals("") || this.laengemin_erfassen.getText().equals("") || this.beschreibung_erfassen.getText().equals("") ){
			this.alert("Warnung", "Felder inkorrekt", "Bitte füllen Sie alle obligatorischen Felder aus");
		}else{
			Film film = new Film(this.bildpfad_erfassen.getText(), this.filmtitel_erfassen.getText(), this.beschreibung_erfassen.getText(), Integer.parseInt(this.laengemin_erfassen.getText()));
			hauptcontroller.erfasseFilm(film);
			this.erfasseFilmLeeren();
		}//-else
	}//-addNewFilm
		
//End Eventlisteners und loaders
	
	//-Constructor
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.loadSaaleAuflistung();
		this.loadVorstellungenAuflistung();
	}

}
