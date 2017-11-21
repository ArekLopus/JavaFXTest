package dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Madality extends Application {
	
	private TextField tf = new TextField();
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Dialogs modality");
		
		Button b1 = new Button("Modal");
		Button b2 = new Button("Not Modal");
		
		b1.setOnAction( (e) -> {
			showDialogModal("Modal Dialog");
		});
		b2.setOnAction( (e) -> {
			showDialogNonModal("Nonmodal Dialog");
		});
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(10);
		hb.getChildren().addAll(b1,b2, tf);
		
		bp.setCenter(hb);
		
		Scene scene = new Scene(bp, 400, 300);
		stage.setScene(scene);
		stage.show();
		
	}
	
	private void showDialogModal(String message) {
		Alert alert = new Alert(AlertType.CONFIRMATION, message);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    tf.setText("Modal Ok pressed");
		} else {
			tf.setText("Modal Cancel pressed");
		}
	}
	private void showDialogNonModal(String message) {
		Alert alert = new Alert(AlertType.CONFIRMATION, message);
		alert.initModality(Modality.NONE);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			tf.setText("NonModal Ok pressed");
		} else {
			tf.setText("NonModal Cancel pressed");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}