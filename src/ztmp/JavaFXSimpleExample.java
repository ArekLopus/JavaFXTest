package ztmp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXSimpleExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("Hello");
		
		Label message = new Label("Hello, JavaFX!");
		message.setFont(new Font(150));
		
		stage.setScene(new Scene(message));
		
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }

}
