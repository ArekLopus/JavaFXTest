package stage;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ASimpleStageTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello");
		
		Button b = new Button("abc");
		Scene scene = new Scene(b);
		
		b.setOnAction( (e) -> {
			int w = (ThreadLocalRandom.current().nextInt(200)+50);
			int h = (ThreadLocalRandom.current().nextInt(200)+50);
			stage.setWidth(w);
			stage.setHeight(h);
		} );
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}
