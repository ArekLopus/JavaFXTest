package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-You can also specify a linear color gradient in string format using the static method LinearGradient.valueOf(String colorString).
//-Typically, the string format is used to specify a linear color gradient in a CSS file. It has the following syntax:
//	linear-gradient([gradient-line], [cycle-method], color-stops-list)
//-The arguments within square brackets ([ and ]) are optional. If you do not specify an optional argument. 
//-The default value for the gradient-line argument is “to bottom.” 
//-The default value for the cycle-method argument is NO_CYCLE. 
//-You can specify the gradient line in two ways:
//  • Using two points—the starting point and the ending point  • Using a side or s corner
//-The syntax for using two points for the gradient line is:
//	from point-1 to point-2
//-The coordinates of the points may be specified in percentage of the area or in actual measurement in pixels. 
// For a 200px wide by 100px tall rectangle, a horizontal gradient line may be specified in the following two ways:
//		from 0% 0% to 100% 0%
// or	from 0px 0px to 200px 0px
//-The syntax for using a side or a corner is:
//	to side-or-corner
 //The side-or-corner value may be top, left, bottom, right, top left, bottom left, bottom right, or top right. 
//-When you define the gradient line using a side or a corner, you specify only the ending point.
// The starting point is inferred. Fe, the value “to top” infers the starting point as “from bottom”;
// the value “to bottom right” infers the starting point as “from top left,” and so forth.
// If the gradient-line value is missing, it defaults to “to bottom.”
//-The valid values for the cycle-method are repeat and reflect. If it is missing, it defaults to NO_CYCLE.
//-The color-stops-list argument is a list of color stops. A color stop consists of a web color name and, optionally,
// a position in pixels or percentage from the starting point. Examples of lists of color stops are:
//  • white, black						• white 0%, black 100%	
//  • white 0%, yellow 50%, blue 100%	• white 0px, yellow 100px, red 200px
//-When you do not specify positions for the first and the last color stops, the positions for the first one defaults to 0%
// and the second one to 100%. So, the color stop lists "white, black" and "white 0%, black 100%" are fundamentally the same.
//-If you do not specify positions for any of the color stops in the list, they are assigned positions in such a way that they are
// evenly placed between the starting point and the ending point. The following two lists of color stops are the same:
//  • white, yellow, black, red, green
//  • white 0%, yellow 25%, black 50%, red 75%, green 100%
public class LinearGradient_String extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("LinearGradient");
    	
    	//linear-gradient([gradient-line], [cycle-method], color-stops-list)
    	
    	//LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	LinearGradient lg = LinearGradient.valueOf("linear-gradient(to right, white, black)");
    	
    	//3 color stops
    	//LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, Color.RED), new Stop(0.5, Color.YELLOW), new Stop(1, Color.GREEN)});
    	LinearGradient lg1 = LinearGradient.valueOf("linear-gradient(to right, red, yellow, green)");
    	
    	//Half of gradient line with reflect
    	//LinearGradient lg2 = new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	LinearGradient lg2 = LinearGradient.valueOf("linear-gradient(from 0% 0% to 50% 0% , reflect, white, black)");
    	
    	//1/10 of gradient line with repeat
    	//LinearGradient lg3 = new LinearGradient(0, 0, 0.1, 0, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.RED), new Stop(1, Color.GREEN)});
    	LinearGradient lg3 = LinearGradient.valueOf("linear-gradient(from 0% 0% to 10% 0% , repeat, red, green)");
    	
    	//A gradient line from the top left corner to the bottom right corner.
    	//LinearGradient lg4 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	LinearGradient lg4 = LinearGradient.valueOf("linear-gradient(from 0% 0% to 100% 100% , white, black)");
    	
    	//1/10 of gradient line with repeat with an angle.
    	//LinearGradient lg5 = new LinearGradient(0, 0, 0.1, 0.1, true, CycleMethod.REPEAT, new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)});
    	LinearGradient lg5 = LinearGradient.valueOf("linear-gradient(from 0% 0% to 10% 10%, repeat, white, black)");
    	
    	Rectangle r = new Rectangle(200, 100);
    	r.setFill(lg);
    	
    	Rectangle r1 = new Rectangle(200, 100);
    	r1.setFill(lg1);
    	
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
		vb.getChildren().addAll(r, r1, r2, r3, r4, r5);

		
        Scene scene = new Scene(vb, 400, 680);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}