package transformations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

//-You can apply multiple transformations to a node.
//-The transformations in the transforms sequence are applied before the transformation set on the properties of the node. 
// When properties of the Node class are used, translation, rotation, and scale are applied in sequence.
//-When the transforms sequence is used, transformations are applied in the order they are stored in the sequence.
public class MultipleTransformations extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Shear");
		
		Group gr1 = new Group();
		
		Rectangle rec1 = new Rectangle(100, 100, Color.RED);
		rec1.setOpacity(0.5);
		
		Rectangle rec2 = new Rectangle(100, 100, Color.BLUE);
		rec2.setOpacity(0.5);
		
		rec2.getTransforms().addAll(
				new Scale(1.2, 1.2, 50, 25),
                new Rotate(30, 50, 25),
                new Translate(100, 0));
		
		
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