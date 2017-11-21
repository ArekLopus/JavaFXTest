package node;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// 
public class BoundsBasics extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Bounds");

    	Rectangle rect1 = new Rectangle(0, 0, 100, 50);
    	rect1.setFill(Color.RED);
    	
    	Rectangle rect2 = new Rectangle(100, 100, 100, 50);
    	rect2.setFill(Color.RED);
    	//rect2.setEffect(new DropShadow());
    	//rect2.setRotate(30);
    	
    	Group root = new Group();
    	root.getChildren().addAll(rect1, rect2);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    	//Must be after stage.show()!
    	System.out.println("rect1=" + rect1.getLayoutBounds());
    	System.out.println("rect1=" + rect1.getBoundsInLocal());
    	System.out.println("rect1=" + rect1.getBoundsInParent());
    	
    	System.out.println("\nrect2=" + rect2.getLayoutBounds());
    	System.out.println("rect2=" + rect2.getBoundsInLocal());
    	System.out.println("rect2=" + rect2.getBoundsInParent());
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}