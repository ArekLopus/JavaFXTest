package transformations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

//-A translation moves every point of a node by a fixed distance in a specified direction relative to its parent coordinate system.
// It is achieved by shifting the origin of the local coordinate system of the node to a new location.
//-Compare the use of the layoutX and layoutY properties of the Node class with the translateX and translateY properties.
// The layoutX and layoutY properties position the node in its local coordinate system without transforming the local coordinate system
// whereas the translateX and translateY properties transform the local coordinate system of the node by shifting the origin. 
//-Typically, layoutX and layoutY are used to place a node in a scene whereas translation is used for moving a node in an animation.
//-The properties of the Node class use the center of the node as the pivot point.
public class ScaleTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Scale");
		
		Group gr1 = new Group();
		
		Rectangle rec1 = new Rectangle(100, 100, Color.RED);
		rec1.setOpacity(0.5);
		Rectangle rec2 = new Rectangle(100, 100, Color.BLUE);
		rec2.setOpacity(0.5);
		
		rec2.setTranslateX(110);
		rec2.setTranslateY(110);
		
		Scale sc = new Scale(2, 2);
		rec2.getTransforms().add(sc);
		
		gr1.getChildren().addAll(rec1, rec2);
		
				
		Scene scene = new Scene(gr1, 450, 350);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}