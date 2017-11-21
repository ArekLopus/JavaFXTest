package node;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-Sometimes you may want to include the space needed to show the effects and transformations of a node in its layoutBounds.
//-The solution for this is easy. You need to wrap the node in a Group and the Group in a container.
//-Now the container will query the Group for its layoutBounds. The layoutBounds of a Group is the union
// of the boundsInParent for all its children.
public class Bounds1_LayoutBounds2 extends Application {
	
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
    	root.getChildren().addAll(new Group(b1), b2, new Group(b3), b4);
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	//Must be after stage.show()!
    	System.out.println("b1=" + b1.getLayoutBounds());
    	System.out.println("b2=" + b2.getLayoutBounds());
    	System.out.println("b3=" + b3.getLayoutBounds());
    	System.out.println("b4=" + b4.getLayoutBounds());
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}