package layoutPanes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GroupNodeTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello");
		
		Group g = new Group();
		for (int i = 0; i < 10; i++) {
		    Rectangle r = new Rectangle();
		    r.setY(i * 20);
		    r.setX(i * 20);
		    r.setWidth(100);
		    r.setHeight(10);
		    r.setFill(Color.RED);
		    g.getChildren().add(r);
		}
		g.setClip(new Rectangle(100, 100));
		g.setLayoutX(10);
		g.setLayoutY(10);
		
		Scene scene = new Scene(g);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}
