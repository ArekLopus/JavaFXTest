package layoutPanes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GroupRoundedRectangle extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Main window");
		
		TextField tf1 = new TextField("tf1");
		tf1.setLayoutX(50);
		tf1.setLayoutY(10);
		TextField tf2 = new TextField("tf2");
		tf2.setLayoutX(50);
		tf2.setLayoutY(50);
		TextField tf3 = new TextField("tf3");
		tf3.setLayoutX(50);
		tf3.setLayoutY(90);
		
		Rectangle blue = new Rectangle(250, 250, Color.SKYBLUE);
		blue.setArcHeight(50);
		blue.setArcWidth(50);
		
		Group g = new Group();
		g.setLayoutX(25);
		g.setLayoutY(25);
		
		g.getChildren().addAll(blue, tf1, tf2, tf3);
		
		Scene scene = new Scene(g, 300, 300);
		
		stage.setScene(scene);
		stage.show();

	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
