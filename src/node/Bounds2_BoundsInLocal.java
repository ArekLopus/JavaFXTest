package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The boundsInLocal property is computed in the untransformed coordinate space of the node. 
//-It includes the geometric properties of the node, effects, and clip. Transformations applied to a node are not included. 
//-When do you use the boundsInLocal of a node? You would use boundsInLocal when you need to include the effects and the clip of a node. 
public class Bounds2_BoundsInLocal extends Application {
	
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
    	System.out.println("b1=" + b1.getBoundsInLocal());
    	System.out.println("b2=" + b2.getBoundsInLocal());
    	System.out.println("b3=" + b3.getBoundsInLocal());
    	System.out.println("b4=" + b4.getBoundsInLocal());
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}