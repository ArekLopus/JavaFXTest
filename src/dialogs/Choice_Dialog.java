package dialogs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

public class Choice_Dialog extends Application {
	
	@Override
	public void start(Stage stage) {
		
		List<String> choices = Arrays.asList("Choice 1", "Choice 2", "Choice 3", "Choice 4");
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Choice 1", choices);
		dialog.setTitle("Title Text");
		dialog.setHeaderText("Header Text");
		dialog.setContentText("Make your choice:");

		//The result.isPresent() returns false if dialog is cancelled.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    System.out.println("Your choice: " + result.get());
		} else {
			System.out.println("Dialog canceled");
		}

		//We can use J8 lambda expression.
		result.ifPresent(choice -> System.out.println("Your choice: " + choice));
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}