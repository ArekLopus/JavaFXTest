package transformations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

//-There are two ways to create a Transform instance.
// • Use one of the factory methods of the Transform class—fe, the Transform.translate() for creating a Translate object, etc.
// • Use the specific class to create a specific type of transform—fe, the Translate class for a translation, the Rotate class for a rotation, etc.
//-There are two ways to apply a transformation to a node.
// • Use the specific properties in the Node class. Fe, use the translateX, translateY, and translateZ properties of the Node class
//   to apply a translation to a node. Note that you cannot apply a shear transformation this way.
// • Use the transforms sequence of a node. The getTransforms() of the Node class returns an ObservableList<Transform>.
//   Populate this list with all the Transform objects. The Transforms will be applied in sequence. You can apply a shear transformation only using this method.
//-Sometimes, it is possible to use both of the foregoing methods to apply transformations, and in that case,
// the transformations in the transforms sequence are applied before the transformation set on the properties of the node.
public class Transforms extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Transforms");
		
		Text t1 = new Text("Test text");
		Text t2 = new Text("Test text");
		
		Translate tr1 = Transform.translate(10, 10);
		Translate tr2 = new Translate(10, 10);
		
		t1.setTranslateX(10);
		t1.setTranslateY(10);
		
		t2.getTransforms().addAll(tr1, tr2);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1, t2);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}