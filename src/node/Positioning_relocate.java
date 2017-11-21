package node;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//The Node class has a convenience method, relocate(double finalX, double finalY), to position the node at the (finalX, finalY) location.
public class Positioning_relocate extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Positioning - relocate");

    	Rectangle r1 = new Rectangle(100, 50, Color.RED);
    	Rectangle r2 = new Rectangle(100, 50, Color.RED);
    	
    	r2.relocate(100,100);
    	
    	
    	Group root = new Group();
    	root.getChildren().addAll(r1, r2);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}