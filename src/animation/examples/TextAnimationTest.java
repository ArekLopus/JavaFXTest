package animation.examples;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TextAnimationTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello");
		
		String message = "Abracadabra";
		Text text = new Text(message);
		
		text.setLayoutY(100);
		text.setTextOrigin(VPos.TOP);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		text.setWrappingWidth(400);
		text.setFill(Color.rgb(187, 5, 0));
		text.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));
		
		Group g = new Group(text);
		g.setLayoutX(300);
		g.setLayoutY(200);
		
		g.setClip(new Rectangle(200, 200));
		
//		RotateTransition rt = new RotateTransition(Duration.millis(30000), g);
//	    rt.setByAngle(180);
//	    rt.setCycleCount(4);
//	    rt.setAutoReverse(true);
//	 
//	    rt.play();
		
		
		//TranslateTransition transTransition = new TranslateTransition(new Duration(7500), text);
		TranslateTransition transTransition = new TranslateTransition(new Duration(2000), text);
		transTransition.setToY(-200);
		transTransition.setInterpolator(Interpolator.EASE_BOTH);
		transTransition.setCycleCount(Timeline.INDEFINITE);
		transTransition.play();
		
		Scene scene = new Scene(g);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}
