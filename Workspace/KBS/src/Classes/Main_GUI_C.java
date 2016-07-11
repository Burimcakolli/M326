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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main_GUI_C implements Initializable{
	@FXML
	private Button button_Load;
	@FXML
	private GridPane grid;
	@FXML
	private Button save;
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
	
	private KBS_C hauptcontroller = new KBS_C();
	ObservableList<Map<Saal, ArrayList<Sitz>>> saale =FXCollections.observableArrayList (hauptcontroller.getSaale());
	
	private Saal selectedSaal_bearbeitung = null;
	private ArrayList<Sitz> selectedSitzplatzordnung_bearbeitung = null;
	
	public void load_sitzplatzverwaltung(){    
		System.out.println("olaf");
		GridPane newgrid = new GridPane();
		Rectangle rec = new Rectangle();
		rec.setWidth(300);
		rec.setHeight(100);
		rec.setFill(Color.WHITE);
		newgrid.setGridLinesVisible(false);
      //  newgrid.setMaxHeight();
      // newgrid.setMaxWidth(100);
        
        for(int reihe = 0; reihe < selectedSaal_bearbeitung.getY();reihe++){
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / reihe);
            newgrid.getRowConstraints().add(rowConst);
			for(int nummer = 0; nummer < selectedSaal_bearbeitung.getX();nummer++){
				 ColumnConstraints colConst = new ColumnConstraints();
		         colConst.setPercentWidth(100.0 / nummer);
		         newgrid.getColumnConstraints().add(colConst);
		         for(int suche = 0; suche < selectedSitzplatzordnung_bearbeitung.size(); suche++){
		        	 if(selectedSitzplatzordnung_bearbeitung.get(suche).getNummer() == nummer && selectedSitzplatzordnung_bearbeitung.get(suche).getReihe() == reihe){
		        		 newgrid.add(new SitzPlatzFeld(selectedSitzplatzordnung_bearbeitung.get(suche), false), nummer, reihe);
		        		 break;
		        	 }//-if
		         }//-for	         
			}//-for
		}//-for
               
        saalordnung_bearbeiten.add(rec, 0, 0);
        saalordnung_bearbeiten.add(newgrid, 0, 1);
        saalordnung_bearbeiten.setHalignment(newgrid, HPos.CENTER);
        saalordnung_bearbeiten.setHalignment(rec, HPos.CENTER);
        save.setDisable(false); 
    
	}
	
	public void addNewSaal(){
		System.out.println("Neuer Saal erstellt");
	}
	
	public void zeigeSaal(){
		Map<Saal, ArrayList<Sitz>> selectedObject = (Map) saal_auflistung.getSelectionModel().getSelectedItem();
		for (Map.Entry<Saal, ArrayList<Sitz>> entry : selectedObject.entrySet()) {
			this.selectedSaal_bearbeitung = (Saal) entry.getKey();
		    this.selectedSitzplatzordnung_bearbeitung = (ArrayList<Sitz>) entry.getValue();
		}//-for
		this.load_sitzplatzverwaltung();
	}
	
	public void loadSaaleAuflistung(){
		String items_String = "";
		saal_auflistung.setItems(saale); 
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.loadSaaleAuflistung();
	}

}
