package layoutPanes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html
public class ScrollPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("ScrollPane");
		
		Rectangle rect = new Rectangle(500, 500, Color.RED);
		ScrollPane s1 = new ScrollPane();
		s1.setPrefSize(300, 300);
		s1.setContent(rect);
		
		Scene scene = new Scene(s1);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}