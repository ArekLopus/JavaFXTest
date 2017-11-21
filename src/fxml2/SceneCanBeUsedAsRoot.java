package fxml2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneCanBeUsedAsRoot extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneCanBeUsedAsRoot.fxml"));
		
		Scene scene = loader.load();
		
		stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
