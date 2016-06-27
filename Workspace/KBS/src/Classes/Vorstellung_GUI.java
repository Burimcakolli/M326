package Classes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Vorstellung_GUI extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Vorstellungsverwaltung");
		ListView<String> realList = new ListView<String>();
		ListView<String> algList = new ListView<String>();
		ListView<String> formular = new ListView<String>();
		HBox realBox = new HBox();
		HBox algBox = new HBox();
		HBox formBox = new HBox();
		
		BorderPane alg = new BorderPane();
		BorderPane real = new BorderPane();
		BorderPane forms = new BorderPane();
		BorderPane layout = new BorderPane();
		alg.setPrefWidth(300);
		real.setPrefWidth(300);
		forms.setPrefWidth(350);
		Button save = new Button("save"), new_Alg = new Button("new"), new_Real = new Button("new");
		realBox.getChildren().add(new_Real);
		algBox.getChildren().add(new_Alg);
		formBox.getChildren().add(save);
		algBox.setPadding(new Insets(10, 20, 10, 125));
		realBox.setPadding(new Insets(10, 20, 10, 125));
		formBox.setPadding(new Insets(10, 20, 10, 225));
		layout.setStyle("-fx-background-color: #FFFFFF;");
		alg.setCenter(algList);
		alg.setBottom(algBox);
		real.setCenter(realList);
		real.setBottom(realBox);
		forms.setCenter(formular);
		forms.setBottom(formBox);
		layout.setLeft(alg);
		layout.setCenter(real);
		layout.setRight(forms);
		layout.setMargin(alg, new Insets(0,25,0,0));
		layout.setMargin(real, new Insets(0,25,0,25));
		layout.setMargin(forms, new Insets(0,0,0,25));
		Scene scene = new Scene(layout, 1050, 600);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
