package Classes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main_GUI extends Application{

	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Systemverwaltung");
		ListView<String> leftList = new ListView<String>();
		ListView<String> middleList = new ListView<String>();
		ListView<String> rightList = new ListView<String>();
		leftList.setPrefWidth(400);
		rightList.setPrefWidth(325);
		middleList.setPrefWidth(325);
		leftList.setPrefHeight(680);
		rightList.setPrefHeight(680);
		middleList.setPrefHeight(680);
		GridPane tile = new GridPane();
		tile.setStyle("-fx-background-color: white;");
		GridPane layout2 = new GridPane();
		layout2.setPrefWidth(1500);
		layout2.setPrefHeight(750);
		tile.setPrefHeight(680);
		tile.setPrefWidth(450);
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(450));
		Button button = new Button(), button1 = new Button();
		BorderPane layout = new BorderPane();
		HBox buttonBox = new HBox();
		button.setText("irgendwas");
		button1.setText("irgendwas");
		buttonBox.getChildren().addAll(button, button1);
		buttonBox.setSpacing(5);
		buttonBox.setPadding(new Insets(10, 20, 10, 1250));
		
		layout2.add(leftList, 1, 1);
		layout2.add(middleList, 2, 1);
		layout2.add(rightList, 3, 1);
		layout2.add(tile, 4, 1);
		layout.setBottom(buttonBox);
		layout.setCenter(layout2);
		Scene scene = new Scene(layout, 1500, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

