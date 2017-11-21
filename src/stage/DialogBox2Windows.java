package stage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogBox2Windows {

	public static void showDialog(String title, String message) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		
		Label l = new Label(message);
		Button b = new Button("Close");
		b.setOnAction( e -> stage.close() );
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(l, b);
		
		Scene scene = new Scene(vb);
		
		stage.setScene(scene);
		
		stage.showAndWait();
	}
}
