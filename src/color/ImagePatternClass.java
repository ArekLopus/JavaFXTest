package color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//
public class ImagePatternClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("ImagePattern");
    	
    	Image im = new Image("/helper/fruit16.png");
    	
    	ImagePattern ip1 = new ImagePattern(im);
    	ImagePattern ip2 = new ImagePattern(im, 0.0, 0.0, 1.0, 1.0, true);
    	ImagePattern ip3 = new ImagePattern(im, 0, 0, 0.25, 0.25, true);
    	
    	Rectangle r1 = new Rectangle(100, 100);
    	r1.setFill(ip1);
    	
    	Rectangle r2 = new Rectangle(100, 100);
    	r2.setFill(ip2);
    	
    	Rectangle r3 = new Rectangle(100, 50);
    	r3.setFill(ip3);
    	
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