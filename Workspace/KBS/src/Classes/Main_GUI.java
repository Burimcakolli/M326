package Classes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_GUI extends Application implements EventHandler<ActionEvent>{
	Main_GUI_C guiC;
	Saal_GUI saal = new Saal_GUI();
	Scene scene1 = saal.scene1;
	public Stage theStage;
	public Button button_Saal;
	public BorderPane layout;
	public BorderPane layout_Saal;
	public BorderPane layout_Vorstellung;
	public Button button_Vorstellung;
	
	
		
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		theStage = primaryStage;
		theStage.setTitle("Systemverwaltung");
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
		GridPane layout_Startseite = new GridPane();
		layout_Saal = new BorderPane();
		
		layout_Startseite.setPrefWidth(1550);
		layout_Startseite.setPrefHeight(750);
		tile.setPrefHeight(680);
		tile.setPrefWidth(375);
		
		//Layout von Saal
		
		BorderPane saal = new BorderPane();
		BorderPane saalPane = new BorderPane();
		ListView<String> saalList = new ListView<String>();
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
		saal.setPrefWidth(1200);
		saal.setPrefHeight(500);
		newSaalBox.setPadding(new Insets(10, 20, 10, 1250));
		newSaalBox.setSpacing(5);
		
//		saal.getChildren().add(saalList);
		saalPane.setCenter(saalList);
		layout_Saal.setCenter(saalPane);
		layout_Saal.setRight(saal);
		layout_Saal.setBottom(newSaalBox);

	
		
		
		//Layout von Saal

		
		//Layout von Vorstellung
		ListView<String> realList = new ListView<String>();
		ListView<String> algList = new ListView<String>();
		ListView<String> formular = new ListView<String>();
		HBox realBox = new HBox();
		HBox algBox = new HBox();
		HBox formBox = new HBox();
		
		BorderPane alg = new BorderPane();
		BorderPane real = new BorderPane();
		BorderPane forms = new BorderPane();
		layout_Vorstellung = new BorderPane();
		alg.setPrefWidth(450);
		real.setPrefWidth(450);
		forms.setPrefWidth(550);
		Button save = new Button("save"), new_Alg = new Button("new"), new_Real = new Button("new");
		realBox.getChildren().add(new_Real);
		algBox.getChildren().add(new_Alg);
		formBox.getChildren().add(save);
		algBox.setPadding(new Insets(10, 20, 10, 200));
		realBox.setPadding(new Insets(10, 20, 10, 200));
		formBox.setPadding(new Insets(10, 20, 10, 450));
		layout_Vorstellung.setStyle("-fx-background-color: #FFFFFF;");
		alg.setCenter(algList);
		alg.setBottom(algBox);
		real.setCenter(realList);
		real.setBottom(realBox);
		forms.setCenter(formular);
		forms.setBottom(formBox);
		layout_Vorstellung.setLeft(alg);
		layout_Vorstellung.setCenter(real);
		layout_Vorstellung.setRight(forms);
		layout_Vorstellung.setMargin(alg, new Insets(0,25,0,0));
		layout_Vorstellung.setMargin(real, new Insets(0,25,0,25));
		layout_Vorstellung.setMargin(forms, new Insets(0,0,0,25));
		

		
		//Layout von Vorstellung
		
		
		
		Button button_Reservieren = new Button();
		button_Vorstellung = new Button();
		button_Saal = new Button();
		layout = new BorderPane();
		tile.setBottom(btn_Save);
		
		HBox buttonBox = new HBox();

		button_Reservieren.setText("Reservieren");
		button_Saal.setText("Saale");
		button_Vorstellung.setText("Vorstellung");
		buttonBox.getChildren().addAll(button_Vorstellung,button_Reservieren, button_Saal);
		buttonBox.setSpacing(5);
		buttonBox.setPadding(new Insets(10, 20, 10, 918));
		button_Vorstellung.relocate(150, 20);
		layout_Startseite.add(vorstellungList, 1, 1);
		layout_Startseite.add(leftList, 2, 1);
		layout_Startseite.add(middleList, 3, 1);
		layout_Startseite.add(rightList, 4, 1);
		layout_Startseite.add(tile, 5, 1);
		layout.setBottom(buttonBox);
		layout.setTop(menuBox);
		layout_Startseite.setVisible(true);
		
	
		layout.setCenter(layout_Startseite);
		Scene scene = new Scene(layout, 1550, 725);
		theStage.setResizable(false);
		theStage.setScene(scene);
		theStage.show();
		button_Saal.setOnAction(this);
		
		
		 this.button_Vorstellung.setOnAction(o -> {
			layout.setCenter(layout_Vorstellung);
		});	
	

	}




	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == button_Saal){
			
			layout.setCenter(layout_Saal);
		}
		
	}





	
	

	

}

