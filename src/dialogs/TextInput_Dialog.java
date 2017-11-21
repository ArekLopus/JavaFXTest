package dialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class TextInput_Dialog extends Application {
	
	@Override
	public void start(Stage stage) {
		
		TextInputDialog ti = new TextInputDialog("Enter text here");
		ti.setTitle("Alert Title");
		ti.setContentText("Content Text");
		
		ti.setContentText("Enter your text here:");

		Optional<String> result = ti.showAndWait();
		
		//The result.isPresent() returns false if dialog is cancelled.
		if (result.isPresent()){
		    System.out.println("Your text: " + result.get());
		} else {
			System.out.println("Dialog canceled");
		}
		
		//We can use J8 lambda expression.
		result.ifPresent(text -> System.out.println("Your text from lambda expr: " + text));
		//System.out.println(result.orElse("Dialog canceled"));
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}