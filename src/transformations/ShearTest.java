package transformations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

//-A shear transformation rotates axes of the local coordinate system of the node around a pivot point,
// so the axes are no longer perpendicular. A rectangular node becomes a parallelogram after the transformation.
//-An instance of the Shear class represents a shear transformation. It contains four properties to describe the transformation.
// • x	• y  • pivotX  • pivotY
//-You can apply a shear transformation to a node using only a Shear object in the transforms sequence. 
// Unlike for other types of transformations, the Node class does not contain a property allowing you to apply shear transformation.
public class ShearTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Shear");
		
		Group gr1 = new Group();
		
		Rectangle rec1 = new Rectangle(100, 100, Color.RED);
		rec1.setOpacity(0.5);
		
		Rectangle rec2 = new Rectangle(100, 100, Color.BLUE);
		rec2.setOpacity(0.5);
		
		//Shear sh = new Shear(2, 2);
		Shear sh = new Shear(0.5, 0.5);
		
		rec2.getTransforms().addAll(sh);
		
		
		gr1.getChildren().addAll(rec1, rec2);
		
		gr1.setLayoutX(50);
		gr1.setLayoutY(50);
		
		
		Scene scene = new Scene(gr1, 450, 400);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}