package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-Every node has a size (width and height), which may be changed. That is, every node can be resized.
//-There are two types of nodes: resizable nodes and nonresizable nodes. Aren’t the previous two sentences contradictory?
// The answer is yes and no. It is true that every node has the potential to be resized. However, by a resizable node,
// it is meant that a node can be resized by its parent during layout. Fe, a button is a resizable node and a rectangle is a nonresizable node.
//-When a button is placed in a container, fe, in an HBox, the Hbox determines the best size for the button. The HBox resizes the button
// depending on how much space is needed for the button to display and how much space is available to the HBox.
//-When a rectangle is placed in an Hbox, the HBox does not determine its size; rather, it uses the size of the rectangle specified by the app.
//-Tip A resizable node can be resized by its parent during a layout. A nonresizable node is not resized by its parent during a layout.
//-If you want to resize a nonresizable node, you need to modify its properties that affect its size. Fe, to resize a rectangle,
// you need to change its width and height properties.
//-Regions, Controls, and WebView are examples of resizable nodes. Group, Text, and Shapes are examples of nonresizable nodes.

//-The isResizable() in the Node class returns true for a resizable node; it returns false for a nonresizable node.
public class Size_Basics extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Size");

    	Rectangle r1 = new Rectangle(200, 50, Color.RED);
    	Button b1 = new Button("Resizable");
    	b1.setPrefWidth(200);
    	
    	System.out.println("Rectangle resizable? -> "+r1.isResizable());
    	System.out.println("Button resizable? -> "+b1.isResizable());
    	
    	HBox root = new HBox(10);
    	root.getChildren().addAll(r1, b1);
    	
    	Scene scene = new Scene(root, 420, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}