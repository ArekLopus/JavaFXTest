package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LinearGradientClass2 extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("LinearGradient");
    	
    	//3 color stops
    	Stop[] stops = new Stop[]{new Stop(0, Color.RED), new Stop(0.5, Color.YELLOW), new Stop(1, Color.GREEN)};
    	LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    	
    	//Half of gradient line with reflect
    	Stop[] stops2 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	LinearGradient lg2 = new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, stops2);
    	
    	//1/10 of gradient line with repeat
    	Stop[] stops3 = new Stop[]{new Stop(0, Color.RED), new Stop(1, Color.GREEN)};
    	LinearGradient lg3 = new LinearGradient(0, 0, 0.1, 0, true, CycleMethod.REPEAT, stops3);
    	
    	//A gradient line from the top left corner to the bottom right corner.
    	Stop[] stops4 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	LinearGradient lg4 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops4);
    	
    	//1/10 of gradient line with repeat with an angle.
    	Stop[] stops5 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	LinearGradient lg5 = new LinearGradient(0, 0, 0.1, 0.1, true, CycleMethod.REPEAT, stops5);
    	
    	
    	Rectangle r1 = new Rectangle(200, 100);
    	r1.setFill(lg);
    	
    	Rectangle r2 = new Rectangle(200, 100);
    	r2.setFill(lg2);
    	
    	Rectangle r3 = new Rectangle(200, 100);
    	r3.setFill(lg3);
    	
    	Rectangle r4 = new Rectangle(200, 100);
    	r4.setFill(lg4);
    	
    	Rectangle r5 = new Rectangle(200, 100);
    	r5.setFill(lg5);
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(r1, r2, r3, r4, r5);

		
        Scene scene = new Scene(vb, 400, 570);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}