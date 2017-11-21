package dialogs;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class WithoutHeader extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert Title");
		alert.setContentText("Content Text");
		
		//No header when set to null
		alert.setHeaderText(null);
		
		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}