package bindInContNumbers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		Parent root = FXMLLoader.load(getClass().getResource("Abc.fxml"));
		
		Button b = new Button("Testing");
		b.setLayoutX(14.0);
		b.setLayoutY(177.0);
		((AnchorPane) root).getChildren().add(b);
		
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
