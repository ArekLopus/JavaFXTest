package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//
public class RadialGradient_String extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("RadialGradient");
    	
    	//RadialGradient(d focusAngle, d focusDistance, d centerX, d centerY, d radius, b proportional, cycleMethod, stops)
    	//radial-gradient([focus-angle], [focus-distance], [center], radius, [cycle-method], color-stops-list)
    	//String colorValue = "radial-gradient(focus-angle 45deg, focus-distance 50%, center 50% 50%, radius 50%, white 0%, black 100%)";
    	
    	//RadialGradient rg = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 50%, white 0%, black 100%)";
    	RadialGradient rg = RadialGradient.valueOf(colorValue);
    	Circle c1 = new Circle(50, 50, 50);
    	c1.setFill(rg);
    	
    	
    	
    	//RadialGradient rg2 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue2 = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 20%, white, black)";
    	RadialGradient rg2 = RadialGradient.valueOf(colorValue2);
    	Circle c2 = new Circle(50, 50, 50);
    	c2.setFill(rg2);
    	
    	//RadialGradient rg3 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue3 = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 20%, repeat, white, black)";
    	RadialGradient rg3 = RadialGradient.valueOf(colorValue3);
    	Circle c3 = new Circle(50, 50, 50);
    	c3.setFill(rg3);
    	
    	//RadialGradient rg4 = new RadialGradient(60, 0.2, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue4 = "radial-gradient(focus-angle 60deg, focus-distance 20%, center 50% 50%, radius 20%, repeat, white, black)";
    	RadialGradient rg4 = RadialGradient.valueOf(colorValue4);
    	Circle c4 = new Circle(50, 50, 50);
    	c4.setFill(rg4);
    	
    	//RadialGradient rg5 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue5 = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 50%, repeat, white, black)";
    	RadialGradient rg5 = RadialGradient.valueOf(colorValue5);
    	Rectangle r1 = new Rectangle(200, 100);
    	r1.setFill(rg5);
    	
//???no proportional???
    	//RadialGradient rg6 = new RadialGradient(0, 0, 100, 50, 50, false, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue6 = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 50%, repeat, white, black)";
    	RadialGradient rg6 = RadialGradient.valueOf(colorValue6);
    	Rectangle r2 = new Rectangle(200, 100);
    	r2.setFill(rg6);
    	
    	//RadialGradient rg7 = new RadialGradient(0, 0, 0.5, 0.5, 0.2, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	String colorValue7 = "radial-gradient(focus-angle 0deg, focus-distance 0%, center 50% 50%, radius 20%, repeat, white, black)";
    	RadialGradient rg7 = RadialGradient.valueOf(colorValue7);
    	//Polygon t1 = new Polygon(0.0, 0.0, 0.0, 100.0, 100.0, 100.0);
    	Polygon t1 = new Polygon(0.0, 0.0, 0.0, 100.0, 200.0, 100.0);
    	t1.setFill(rg7);
    	
    	//Stop[] stops8 = new Stop[]{new Stop(0, Color.WHITE), new Stop(0.40, Color.GRAY), new Stop(0.60, Color.TAN), new Stop(1, Color.BLACK)};
    	//RadialGradient rg8 = new RadialGradient(-30, 1.0, 0.5, 0.5, 0.5, true, CycleMethod.REPEAT, stops8);
    	String colorValue8 = "radial-gradient(focus-angle -30deg, focus-distance 100%, center 50% 50%, radius 50%, repeat, white, gray, tan, black)";
    	RadialGradient rg8 = RadialGradient.valueOf(colorValue8);
    	Circle c5 = new Circle(50, 50, 50);
    	c5.setFill(rg8);
    	
    	Circle c6 = new Circle(50, 50, 50);
    	c6.setStyle("-fx-fill: radial-gradient(radius 180%, burlywood, derive(burlywood, -30%), derive(burlywood, 30%)); ");
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(c1, c2, c3, c4, r1, r2, t1, c5, c6);

		
        Scene scene = new Scene(vb, 400, 1000);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}