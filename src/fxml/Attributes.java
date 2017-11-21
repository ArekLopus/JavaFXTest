package fxml;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Attributes extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Attributes.fxml"));
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(Attributes.class.getResource("Attributes.fxml"));
		fxmlLoader.setResources(ResourceBundle.getBundle("fxml.Attributes"));
		
		VBox vBox = fxmlLoader.load();
		Scene scene = new Scene(vBox, 500, 350);
		
		stage.setTitle("FXML Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
