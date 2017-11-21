package transformations;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//-A translation moves every point of a node by a fixed distance in a specified direction relative to its parent coordinate system.
// It is achieved by shifting the origin of the local coordinate system of the node to a new location.
//-Compare the use of the layoutX and layoutY properties of the Node class with the translateX and translateY properties.
// The layoutX and layoutY properties position the node in its local coordinate system without transforming the local coordinate system
// whereas the translateX and translateY properties transform the local coordinate system of the node by shifting the origin. 
//-Typically, layoutX and layoutY are used to place a node in a scene whereas translation is used for moving a node in an animation.
public class TranslationTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Translation");
		
		Group gr1 = new Group();
		
		Rectangle rec1 = new Rectangle(100, 100, Color.RED);
		rec1.setOpacity(0.5);
		Rectangle rec2 = new Rectangle(100, 100, Color.BLUE);
		rec2.setOpacity(0.5);
		
		rec2.setTranslateX(30);
		rec2.setTranslateY(30);
		
		Text t1 = new Text("Text");
		t1.setFont(Font.font(20));
		t1.setLayoutX(10);
		t1.setLayoutY(10);
		t1.setTextOrigin(VPos.TOP);
		
		gr1.getChildren().addAll(rec1, rec2, t1);
		
		gr1.setLayoutX(10);
		gr1.setLayoutY(10);
		
		
		Scene scene = new Scene(gr1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}