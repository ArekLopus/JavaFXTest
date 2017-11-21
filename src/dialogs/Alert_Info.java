package dialogs;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Alert_Info extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert Title");
		alert.setHeaderText("Alert header Text");
		alert.setContentText("Content Text");

		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}