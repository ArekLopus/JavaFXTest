package node;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-The Node class has two properties, layoutX and layoutY, to define translation of its coordinate space along the x axis and y axis.
//-The Node class has translateX and translateY properties that do the same thing.
//-The final translation of the coordinate space of a node is the sum of the two:
//	finalTranslationX = layoutX + translateX		finalTranslationY = layoutY + translateY
//-Why do you have 2 props to define translations of the same kind? They exist to achieve the similar results in different situations.
//-Use layoutX and layoutY to position a node for a stable layout.
//-Use translateX and translateY to position a node for a dynamic layout, for example, during animation.
public class Positioning_translate extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Positioning - translate");

    	Rectangle r1 = new Rectangle(100, 50, Color.RED);
    	Rectangle r2 = new Rectangle(100, 50, Color.RED);
    	
    	r2.setTranslateX(100);
    	r2.setTranslateY(100);
    	
    	
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