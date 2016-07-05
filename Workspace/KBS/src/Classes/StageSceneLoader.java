package Classes;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageSceneLoader {
	public static void loadScene(Stage stage, String resourceName) throws IOException {
		URL resource = StageSceneLoader.class.getResource(resourceName);
		Parent root = FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

}
