package transformations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

//-In a rotation transformation, the axes are rotated around a pivot point in the coordinate space and the coordinates of points
// are mapped to the new axes.
//-The default pivot point used in a transforms sequence is the origin of the local coordinate system of the node 
// whereas the rotate property of the Node class uses the center of the untransformed layout bounds of the node as the pivot point.
public class RotationTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Rotation");
		
		Group gr1 = new Group();
		
		Rectangle rec1 = new Rectangle(100, 100, Color.RED);
		rec1.setOpacity(0.5);
		
		Rectangle rec2 = new Rectangle(100, 100, Color.BLUE);
		rec2.setOpacity(0.5);
		
		Rotate rotate = new Rotate(-45, 100, 0);
		rec2.getTransforms().addAll(rotate);
		
		
		gr1.getChildren().addAll(rec1, rec2);
		
		gr1.setLayoutX(50);
		gr1.setLayoutY(50);
		
		
		Scene scene = new Scene(gr1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}