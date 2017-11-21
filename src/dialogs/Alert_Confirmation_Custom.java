package dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Alert_Confirmation_Custom extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Alert Title");
		alert.setHeaderText("Alert header Text");
		alert.setContentText("Your Choice");

		ButtonType b1 = new ButtonType("Yeah?");
		ButtonType b2 = new ButtonType("What?");
		ButtonType b3 = new ButtonType("You sure?");
		ButtonType b4_ok = new ButtonType("OK", ButtonData.OK_DONE);
		ButtonType b5_cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
		//Setting all buttons
		alert.getButtonTypes().setAll(b1, b2, b3, b4_ok, b5_cancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == b1){
		    System.out.println("Yeah?");
		} else if (result.get() == b2) {
			System.out.println("What?");
		} else if (result.get() == b3) {
			System.out.println("You sure?");
		} else if (result.get() == b4_ok) {
			System.out.println("OK");
		} else {
			System.out.println("Cancel");
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}