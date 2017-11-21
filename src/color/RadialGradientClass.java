package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//
public class RadialGradientClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("RadialGradient");
    	
    	
    	Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);
    	Circle c1 = new Circle(50, 50, 50);
    	c1.setFill(rg);
    	
    	Stop[] stops2 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg2 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.NO_CYCLE, stops2);
    	Circle c2 = new Circle(50, 50, 50);
    	c2.setFill(rg2);
    	
    	Stop[] stops3 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg3 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, stops3);
    	Circle c3 = new Circle(50, 50, 50);
    	c3.setFill(rg3);
    	
    	Stop[] stops4 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg4 = new RadialGradient(60, 0.2, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, stops4);
    	Circle c4 = new Circle(50, 50, 50);
    	c4.setFill(rg4);
    	
    	Stop[] stops5 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg5 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, stops5);
    	Rectangle r1 = new Rectangle(200, 100);
    	r1.setFill(rg5);
    	
    	Stop[] stops6 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg6 = new RadialGradient(0, 0, 100, 50, 50, false, CycleMethod.REPEAT, stops6);
    	Rectangle r2 = new Rectangle(200, 100);
    	r2.setFill(rg6);
    	
    	Stop[] stops7 = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	RadialGradient rg7 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, stops7);
    	//Polygon t1 = new Polygon(0.0, 0.0, 0.0, 100.0, 100.0, 100.0);
    	Polygon t1 = new Polygon(0.0, 0.0, 0.0, 100.0, 200.0, 100.0);
    	t1.setFill(rg7);
    	
    	Stop[] stops8 = new Stop[]{new Stop(0, Color.WHITE), new Stop(0.40, Color.GRAY),	new Stop(0.60, Color.TAN), new Stop(1, Color.BLACK)};
    	RadialGradient rg8 = new RadialGradient(-30, 1.0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, stops8);
    	Circle c5 = new Circle(50, 50, 50);
    	c5.setFill(rg8);
    	
    	
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(c1, c2, c3, c4, r1, r2, t1, c5);

		
        Scene scene = new Scene(vb, 400, 890);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}