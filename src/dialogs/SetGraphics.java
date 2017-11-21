package dialogs;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SetGraphics extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert Title");
		alert.setHeaderText("Alert header Text");
		alert.setContentText("Content Text");
		
		ImageView image = new ImageView("/helper/Smile128.png");
		alert.setGraphic(image);
		
		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}