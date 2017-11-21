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

//-In JavaFX, an instance of the LinearGradient class represents a linear color gradient. The class has the following two constructors. The types of their last arguments are different:
// • LinearGradient(double startX, double startY, double endX, double endY, boolean proportional, CycleMethod cycleMethod, List<Stop> stops)
// • LinearGradient(double startX, double startY, double endX, double endY, boolean proportional, CycleMethod cycleMethod, Stop... stops)
//-The startX and startY arguments define the x and y coordinates of the starting point of the gradient line.
//-The endX and endY arguments define the x and y coordinates of the ending point of the gradient line. 
//-The proportional arg affects the way the coordinates of the starting and ending points are treated.
// If it is true, the starting and ending points are treated relative to a unit square.
// Otherwise, they are treated as absolute value in the local coordinate system.
// -In relative form, the region is treated as a unit square. The coordinates of the upper left are (0.0, 0.0) 
//  and the lower right are (1.0, 1.0). Other points in the regions will have x and y coordinates between 0.0 and 1.0.
//  If you specify the starting point as (0.0, 0.0) and the ending point as (1.0, 0.0). It defines a horizontal gradient line from the left to right.
//  The starting and ending points of (0.0, 0.0) and (0.0, 1.0) define a vertical gradient line from top to bottom.
//  The starting and ending points of (0.0, 0.0) and (0.5, 0.0) define a horizontal gradient line from left to middle of the region.
// -When the proportional argument is false, the coordinate values for the starting and ending points are treated as absolute values
//  with respect to the local coordinate system. Suppose you have a rectangle of width 200 and height 100.
//  The starting and ending points of (0.0, 0.0) and (200.0, 0.0) define a horizontal gradient line from left to right.
//  The starting and ending points of (0.0, 0.0) and (200.0, 100.0) define a diagonal gradient line from the top left to bottom right corner. 
//-The cycleMethod argument defines how the regions outside the color gradient bounds, defined by the starting and ending points, should be filled. Suppose you define the starting and ending points with the proportional argument set to true as (0.0, 0.0) and (0.5, 0.0), respectively. This covers only the left half of the region. How should the right half of the region be filled? You specify this behavior using the cycleMethod argument. Its value is one of the enum constants defined in the CycleMethod enum:
// • CycleMethod.NO_CYCLE	• CycleMethod.REFLECT	• CycleMethod.REPEAT
// The cycle method of NO_CYCLE fills the remaining region with the terminal color. If you have defined color a stop point only from the left to the middle of a region, the right half will be filled with the color that is defined for the middle of the region. Suppose you define a color gradient for only the middle half of a region, leaving the 25% at the left side and 25% at the right side undefined. The NO_CYCLE method will fill the left 25% region with the color that is defined at the 25% distance from left and the right 25% region with the color defined at the 25% distance from right. The color for the middle 50% will be determined by the color-stop points.
// The cycle method of REFLECT fills the remaining regions by reflecting the color gradient, as start-to-end and end-to-start, from the nearest filled region.
// The cycle method of REPEAT repeats the color gradient to fill the remaining region.
//-The stops argument defines the color-stop points along the gradient line. A color-stop point is represented by an instance of the Stop class, which has only one constructor: 
//	Stop(double offset, Color color)
// The offset value is between 0.0 and 1.0. It defines the relative distance of the stop point along the gradient line from the starting point. Fe, an offset of 0.0 is the starting point, an offset of 1.0 is the ending point, an offset of 0.5 is in the middle of the starting and ending points, and so forth. You define at least two stop points with two different colors to have a color gradient. There are no limits on the number of stop points you can define for a color gradient.
public class LinearGradientClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("LinearGradient");
    	
    	
    	Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
    	LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    	
    	Rectangle r1 = new Rectangle(200, 100);
    	r1.setFill(lg);
    	
    	//If we want to set the proportional argument value to false, to have the same effect
    	LinearGradient lg2 = new LinearGradient(0, 0, 200, 0, false, CycleMethod.NO_CYCLE, stops);
    	
    	Rectangle r2 = new Rectangle(200, 100);
    	r2.setFill(lg2);
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(r1, r2);

		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}