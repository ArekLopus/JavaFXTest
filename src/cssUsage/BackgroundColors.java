package cssUsage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//-A node (a Region and a Control) can have multiple background fills, which are specified using three properties:
// • -fx-background-color
// • -fx-background-radius
// • -fx-background-insets
//-The -fx-background-color property is a list of comma-separated color values. The number of colors in the list determines the number of
// rectangles that will be painted. You need to specify the radius values for four corners and insets for four sides, for each rectangle,
// using the other two properties. The number of color values must match the number of radius values and inset values.
//-The -fx-background-radius property is a list of a comma-separated set of four radius values for the rectangles to be filled.
// A set of radius values in the list may specify only one value, fe, 10, or four values separated by whitespaces, fe, 10 5 15 20.
// The radius values are specified for the top-left, top-right, bottom-right, and bottom-left corners in order.
// If only one radius value is specified, the same radius value is used for all corners.
//-The -fx-background-insets property is a list of a comma-separated set of four inset values for the rectangles to be filled.
// A set of inset values in the list may specify only one value, fe, 10, or four values separated by whitespaces, fe, 10 5 15 20.
// The inset values are specified for the top, right, bottom, and left sides in order.
// If only one inset value is specified, the same inset value is used for all sides.
public class BackgroundColors extends Application {
	
	//-The -fx-background-radius - top-left, top-right, bottom-right, and bottom-left.
	//-The -fx-background-insets - top, right, bottom, and left sides. 
	@Override
    public void start(Stage stage) {
    	stage.setTitle("BackgroundColors");

    	Pane p1 = new Pane();
		p1.setStyle("-fx-background-color: red, green, blue; -fx-background-insets: 5 5 5 5, 10 15 10 10, 15 20 15 15;"
				+ " -fx-background-radius: 5 5 5 5, 0 0 10 10, 0 20 5 10;");
		
        Scene scene = new Scene(p1, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}