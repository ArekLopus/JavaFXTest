package layoutPanes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/StackPane.html
//The stackpane will attempt to resize each child to fill its content area. If the child could not be sized to fill the stackpane,
//then it will be aligned within the area using the alignment property, which defaults to Pos.CENTER. 
public class StackPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("StackPane");
		
		StackPane sp = new StackPane();
	    sp.getChildren().addAll(new Rectangle(100,100,Color.YELLOW), new Label("I am not resizable"));
		
		Scene scene = new Scene(sp, 200, 200);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}