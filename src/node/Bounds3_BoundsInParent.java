package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The boundsInParent property of a node is in the coordinate space of its parent. 
//-It includes the geometric properties of the node, effects, clip, and transformations. It is rarely used directly in code.
public class Bounds3_BoundsInParent extends Application {
	
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
    	System.out.println("b1=" + b1.getBoundsInParent());
    	System.out.println("b2=" + b2.getBoundsInParent());
    	System.out.println("b3=" + b3.getBoundsInParent());
    	System.out.println("b4=" + b4.getBoundsInParent());
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}