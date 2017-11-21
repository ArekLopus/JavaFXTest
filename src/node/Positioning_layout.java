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
//-It is important to keep in mind that the layoutX and layoutY properties do not specify the final position of a node.
// They are translations applied to the coordinate space of the node. You need to factor the minX and minY values of the layoutBounds when 
// you compute the value of layoutX and layoutY to position a node at a particular position.
// To position the upper left corner of the bounding box of a node at finalX and finalY, use the following formula:
//	layoutX = finalX - node.getLayoutBounds().getMinX()			layoutY = finalY - node.getLayoutBounds().getMinY()
//-Tip- The Node class has a convenience method, relocate(double finalX, double finalY), to position the node at the (finalX, finalY) location.

//-Sometimes setting the layoutX and layoutY properties of a node may not position them at the desired location inside its parent.
// If you are caught in this situation, check the parent type. Most parents, which are the subclasses of the Region class,
// use their own positioning policy, ignoring the layoutX and layoutY settings of their children. 
//-Fe, HBox and VBox use their own positioning policy and they will ignore the layoutX and layoutY values for their children.
//-If you want to have full control on positioning a node within its parent, use a Pane or a Group. A Pane is a Region, 
// which does not position its children. You will need to position the children using the layoutX and layoutY properties.
public class Positioning_layout extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Positioning - layout");

    	Rectangle r1 = new Rectangle(100, 50, Color.RED);
    	Rectangle r2 = new Rectangle(100, 50, Color.RED);
    	
    	r2.setLayoutX(100);
    	r2.setLayoutY(100);
    	
    	
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