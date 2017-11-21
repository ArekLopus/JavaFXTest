package fxmlController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NestedControllers extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(NestedControllers.class.getResource("NestedControllers.fxml"));
		
		VBox vBox = fxmlLoader.load();
		Scene scene = new Scene(vBox, 300, 300);
		
		stage.setTitle("FXML Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
