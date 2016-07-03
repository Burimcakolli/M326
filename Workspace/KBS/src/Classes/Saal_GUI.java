package Classes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Saal_GUI extends Application{
	Scene scene1;
	BorderPane layout_Saal;
	Stage theStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		theStage = primaryStage;
		theStage.setTitle("SaalVerwaltung");
		ListView<String> saalList = new ListView<String>();
		BorderPane saal = new BorderPane();
		layout_Saal = new BorderPane();
		BorderPane saalPane = new BorderPane();
		HBox newSaalBox = new HBox();
		Button newSaal = new Button();
		TextField x = new TextField();
		TextField y = new TextField();
		Label lX = new Label("X");
		Label lY = new Label("Y");
		newSaal.setPrefWidth(100);
		newSaal.setText("Neuer Saal");
		newSaalBox.getChildren().addAll(lX,x, lY, y, newSaal);
		saalList.setPrefWidth(250);
		saalList.setPrefHeight(500);
		x.setPrefWidth(40);
		y.setPrefWidth(40);
		saal.setStyle("-fx-background-color: white;");
		saal.setPrefWidth(500);
		saal.setPrefHeight(500);
		newSaalBox.setPadding(new Insets(10, 20, 10, 500));
		newSaalBox.setSpacing(5);
		
//		saal.getChildren().add(saalList);
		saalPane.setCenter(saalList);
		layout_Saal.setCenter(saalPane);
		layout_Saal.setRight(saal);
		layout_Saal.setBottom(newSaalBox);
		
//		scene1 = new Scene(layout_Saal, 750, 600);
//		theStage.setResizable(false);
//		theStage.setScene(scene1);
//		theStage.show();
	}

}
