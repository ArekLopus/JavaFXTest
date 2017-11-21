package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scripting extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scripting.fxml"));
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(Scripting.class.getResource("Scripting.fxml"));
		
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
