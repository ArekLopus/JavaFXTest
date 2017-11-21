package dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Alert_Confirmation extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Alert Title");
		alert.setHeaderText("Alert header Text");
		alert.setContentText("Your Choice");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    System.out.println("Ok pressed");
		} else {
			System.out.println("Cancel pressed");
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}