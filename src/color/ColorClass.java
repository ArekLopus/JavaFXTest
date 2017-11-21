package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-The Color class represents a solid uniform color from the RGB color space. 
//-Every color has an alpha value defined between 0.0 to 1.0 or 0 to 255. An alpha value of 0.0 or 0 means the color is completely transparent,
//and an alpha value of 1.0 or 255 denotes a completely opaque color. 
//-By default, the alpha value is set to 1.0. You can have an instance of the Color class in three ways:
//	• Using the constructor  	• Using one of the factory methods  	• Using one of the color constants declared in the Color class
//-The Color class has only one constructor that lets you specify the RGB and opacity in the range of 1,0 and 1.0:
//	public Color(double red, double green, double blue, double opacity)
//-You can use the following static methods in the Color class to create Color objects.
// The double values need to be between 0.0 and 1.0 and int values between 0 and 255:
// • Color color(double red, double green, double blue)		
// • Color color(double red, double green, double blue, double opacity)
// • Color hsb(double hue, double saturation, double brightness)
// • Color hsb(double hue, double saturation, double brightness, double opacity)
// • Color rgb(int red, int green, int blue)
// • Color rgb(int red, int green, int blue, double opacity)
//-The valueOf() and web() factory methods let you create Color objects from strings in web color value formats. 
//-The Color class defines about 140 color constants, fe, RED, WHITE, TAN, BLUE, among others.
// Colors defined by these constants are completely opaque.
public class ColorClass extends Application {
	
	@SuppressWarnings("unused")
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Color");
    	
   		Color blue1 = Color.valueOf("blue");
   		Color blue2 = Color.web("blue");
    	Color blue3 = Color.web("#0000FF");
    	Color blue4 = Color.web("0X0000FF");
    	Color blue5 = Color.web("rgb(0, 0, 255)");
    	Color blue6 = Color.web("rgba(0, 0, 255, 0.5)"); 
    	
    	Rectangle r1 = new Rectangle(100, 50);
    	r1.setFill(blue1);
    	
    	Rectangle r2 = new Rectangle(100, 50);
    	r2.setFill(blue2);
    	
    	Rectangle r3 = new Rectangle(100, 50);
    	r3.setFill(blue3);
    	
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