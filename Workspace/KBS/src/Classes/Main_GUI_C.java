package Classes;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
		
	public void load_GridPane(){    	
		GridPane newgrid = new GridPane();
		newgrid.setGridLinesVisible(false);
		final int numCols = 5 ;
        final int numRows = 5 ;
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
     
        SitzPlatzFeld sitzPlatzFeld = new SitzPlatzFeld(new Sitz(false, 3, 1, new Saal("Diese Saal", 10, 20)), false);
        newgrid.add(sitzPlatzFeld, 1, 1);
        grid.add(newgrid, 0, 1);
        save.setDisable(false); 
    
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
	}

}
