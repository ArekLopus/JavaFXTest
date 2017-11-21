package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-The Paint class is an abstract class and it is the base class for other color classes.
//-It contains only one static method that takes a String argument and returns a Paint instance.
// The returned Paint instance would be of the Color, LinearGradient, or RadialGradient class:
//-A uniform color, an image pattern, a linear and a radial color gradient are instances of the 
// Color, ImagePattern, LinearGradient, and RadialGradient classes, respectively.
// The Stop class and the CycleMethod enum are used while working with color gradients.
//-Typically, methods for setting the color attribute of a node take the Paint type as an argument,
// allowing you to use any of the four color patterns (Color, ImagePattern, LinearGradient, and RadialGradient).
public class PaintClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Paint");

    	Rectangle r1 = new Rectangle(100, 50);
    	Paint red = Paint.valueOf("red");
    	r1.setFill(red);
    	
    	Rectangle r2 = new Rectangle(100, 50);
    	Paint lg = Paint.valueOf("linear-gradient(to bottom right, red, black)" );
    	r2.setFill(lg);
    	
    	Rectangle r3 = new Rectangle(100, 50);
    	Paint rg = Paint.valueOf("radial-gradient(radius 100%, red, blue, black)");
    	r3.setFill(rg);
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(r1, r2, r3);
		
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}