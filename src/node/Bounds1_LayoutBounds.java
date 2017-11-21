package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The layoutBounds property is computed based on the geometric properties of the node in the untransformed local coordinate space of the node.
//-Effects, clip, and transformations are not included.
//-Different rules, depending on the resizable behavior of the node, are used to compute the coordinates of the upper left corner
// of the bounding box described by the layoutBounds:
// • For a resizable node (a Region, a Control, and a WebView), the coordinates for the upper left corner of the bounding box are always set
//   to (0, 0). Fe, the (minX, minY) values in the layoutBounds property are always (0, 0) for a button.
// • For a nonresizable node (a Shape, a Text, and a Group), the coordinates of the upper left corner of the bounding box are computed
//   based on the geometric properties. For a shape (a rectangle, a circle, etc.) or a Text, you can specify the (x, y) coordinates
//   of a specific point in the node relative to the untransformed coordinate space of the node.
//-The width and height in layoutBounds are the width and height of the node.
// Some nodes let you set their width and height; but some compute them automatically for you and let you override them.
//-Where do you use the layoutBounds property of a node? Containers allocate spaces to lay out child nodes based on their layoutBounds. 
public class Bounds1_LayoutBounds extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Bounds");

    	Button b1 = new Button("Close");
    	b1.setEffect(new DropShadow());
    	Button b2 = new Button("Close");
    	Button b3 = new Button("Close");
    	b3.setEffect(new DropShadow());
    	b3.setRotate(30);
    	Button b4 = new Button("Close");
    	
    	VBox root = new VBox();
    	root.getChildren().addAll(b1, b2, b3, b4);
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	//Must be after stage.show()!
    	//For a resizable node, the coordinates for the upper left corner of the bounding box are always set to (0, 0).
    	System.out.println("b1=" + b1.getLayoutBounds());
    	System.out.println("b2=" + b2.getLayoutBounds());
    	System.out.println("b3=" + b3.getLayoutBounds());
    	System.out.println("b4=" + b4.getLayoutBounds());
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}