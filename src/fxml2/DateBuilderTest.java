package fxml2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DateBuilderTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DateBuilderTest.fxml"));
		
		loader.setBuilderFactory(new DateBuilderFactory());
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root, 550, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
