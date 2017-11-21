package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A resizable node may specify a range for its size (width and height), which should be taken into account by an honoring container
// for laying out the node. A resizable node specifies three types of sizes that constitute the range of its size:
//   • Preferred size		  • Minimum size		  • Maximum size
//-The preferred size of a node is its ideal width and height to display its contents. Fe, a button in its preferred size would be
// big enough to display all its contents, based on the current properties such as the image, text, font, and text wrapping. 
//-The minimum size of a node is the smallest width and height that it would like to have. Fe, a button in its minimum size would be
// big enough to display the image and an ellipsis for its text.
//-The maximum size of a node is the largest width and height that it would like to have. In the case of a button,
// the maximum size of a button is the same as its preferred size.

//-The Region and Control classes have six properties of the DoubleProperty type
// to define preferred, minimum, and maximum values for their width and height:
//  • prefWidth	 • prefHeight  • minWidth  • minHeight  • maxWidth  • maxHeight
//-By default, these properties are set to the sentinel value USE_COMPUTED_SIZE. That means, nodes compute these sizes automatically.
// You can set one of these properties to override the intrinsic size of a node.

//-In most cases, the internally computed values for preferred, minimum, and maximum sizes of nodes are fine.
// Use these properties to override the internally computed sizes only if they do not meet the needs of your application. 
//-If you need to bind the size of a node to an expression, you would need to bind the prefWidth and prefHeight properties.
public class Size_MinMaxPref extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Size Min, Max, Perf");

    	Button b1 = new Button("Resizable");
    	b1.setPrefWidth(100);
    	
    	Button b2 = new Button("Resizable");
    	b2.setMinWidth(40);
    	b2.setPrefWidth(200);
    	b2.setMaxWidth(1000);
    	
    	VBox hb1 = new VBox(10);
    	hb1.getChildren().addAll(b1, b2);
    	
    	
    	Scene scene = new Scene(hb1, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}