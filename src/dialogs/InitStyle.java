package dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//To get an icon of the main window -> alert.initOwner(stage);
public class InitStyle extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Dialogs modality");
		
		Button b1 = new Button("initStyle(StageStyle.UTILITY)");
		
		b1.setOnAction( (e) -> {
			showDialogModal(stage, "Modal Dialog");
		});
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(10);
		hb.getChildren().addAll(b1);
		
		bp.setCenter(hb);
		
		Scene scene = new Scene(bp, 400, 300);
		stage.setScene(scene);
		stage.show();
		
	}
	
	private void showDialogModal(Stage stage, String message) {
		Alert alert = new Alert(AlertType.CONFIRMATION, message);
		
		alert.initOwner(stage);
		alert.initStyle(StageStyle.UTILITY);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    System.out.println("Modal Ok pressed");
		} else {
			System.out.println("Modal Cancel pressed");
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	
}