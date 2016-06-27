package Classes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_GUI extends Application{

	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Systemverwaltung");
		 MenuBar menuBar = new MenuBar();
		 Menu menuMain = new Menu("Main");
		 Menu menuSaal = new Menu("Saal");
		 Menu menuVorstellung = new Menu("Vorstellung");
		 menuBar.getMenus().addAll(menuMain, menuSaal, menuVorstellung);
		VBox menuBox = new VBox();
		menuBox.getChildren().addAll(menuBar);
		ListView<String> leftList = new ListView<String>();
		ListView<String> middleList = new ListView<String>();
		ListView<String> rightList = new ListView<String>();
		ListView<String> vorstellungList = new ListView<String>();
		Button btn_Save = new Button("Speichern");
		
		btn_Save.setDisable(true);
		vorstellungList.setPrefWidth(293.75);
		leftList.setPrefWidth(293.75);
		rightList.setPrefWidth(293.75);
		middleList.setPrefWidth(293.75);
		leftList.setPrefHeight(680);
		rightList.setPrefHeight(680);
		middleList.setPrefHeight(680);
		vorstellungList.setPrefHeight(680);
		BorderPane tile = new BorderPane();
		tile.setStyle("-fx-background-color: white;");
		BorderPane.setMargin(btn_Save, new Insets(12, 12, 12, 270));
		GridPane layout2 = new GridPane();
		layout2.setPrefWidth(1550);
		layout2.setPrefHeight(750);
		tile.setPrefHeight(680);
		tile.setPrefWidth(375);
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(350));
//		layout2.getColumnConstraints().add(new ColumnConstraints(450));
		Button button_Reservieren = new Button(), button_Saal = new Button(), button_Vorstellung = new Button();
		BorderPane layout = new BorderPane();
		tile.setBottom(btn_Save);
		
		HBox buttonBox = new HBox();

		button_Reservieren.setText("Reservieren");
		button_Saal.setText("Saale");
		button_Vorstellung.setText("Vorstellung");
		buttonBox.getChildren().addAll(button_Vorstellung,button_Reservieren, button_Saal);
		buttonBox.setSpacing(5);
		buttonBox.setPadding(new Insets(10, 20, 10, 918));
		button_Vorstellung.relocate(150, 20);
		layout2.add(vorstellungList, 1, 1);
		layout2.add(leftList, 2, 1);
		layout2.add(middleList, 3, 1);
		layout2.add(rightList, 4, 1);
		layout2.add(tile, 5, 1);
		layout.setBottom(buttonBox);
		layout.setTop(menuBox);
		layout.setCenter(layout2);
		Scene scene = new Scene(layout, 1550, 725);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
