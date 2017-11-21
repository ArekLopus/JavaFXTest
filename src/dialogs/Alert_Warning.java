package dialogs;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Alert_Warning extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert Title");
		alert.setHeaderText("Header Text");
		alert.setContentText("Content Text");
		
		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}