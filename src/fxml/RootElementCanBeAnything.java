package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//ANYTHING can be a root element
public class RootElementCanBeAnything extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		Parent root = FXMLLoader.load(getClass().getResource("RootElementCanBeAnything.fxml"));
		
		Scene scene = new Scene(root, 200,200);
		
		stage.setScene(scene);
			
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
