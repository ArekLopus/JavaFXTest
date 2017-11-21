package stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Stage2windows extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Main window");
		stage.setOnCloseRequest( e -> System.out.println("Close requested"));
		
		Button b = new Button("Open new window");
		b.setOnAction( e -> DialogBox2Windows.showDialog("My dialog", "My message")); 
		
		StackPane sp = new StackPane();
		sp.getChildren().add(b);
		
		Scene scene = new Scene(sp, 300, 300);
		
		stage.setScene(scene);
		
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
