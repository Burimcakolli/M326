package Controllers;

import Views.StageSceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Starter extends Application{

	
	
	public static void main(String[] args) {
		KBS_C myKBS = new KBS_C();
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		StageSceneLoader.loadScene(stage, "Main_GUI.fxml");
		stage.setTitle("KBS");
		stage.show();
	}
	
	
}

