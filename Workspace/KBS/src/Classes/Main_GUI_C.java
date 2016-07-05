package Classes;
import java.net.URL;
import java.util.ResourceBundle;

import Controllers.KBS_C;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
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
	
	private KBS_C hauptcontroller = new KBS_C();
		
	public void load_GridPane(){    	
		GridPane newgrid = new GridPane();
		Rectangle rec = new Rectangle();
		rec.setWidth(300);
		rec.setHeight(100);
		rec.setFill(Color.WHITE);
		newgrid.setGridLinesVisible(false);
		final int numCols = 10 ;
        final int numRows = 10 ;
        newgrid.setMaxHeight(100);
        newgrid.setMaxWidth(100);
        
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            newgrid.getColumnConstraints().add(colConst);
            
           
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            newgrid.getRowConstraints().add(rowConst);  

         
        }
     
        grid.add(rec, 0, 0);
        grid.add(newgrid, 0, 1);
        grid.setHalignment(rec, HPos.CENTER);
        save.setDisable(false); 
    
	}
	
	public void addNewSaal(){
		System.out.println("Neuer Saal erstellt");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
	}

}
