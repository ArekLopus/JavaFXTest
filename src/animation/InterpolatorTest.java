package animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//-An interpolator plays an important role in an animation. Its job is to compute the key values for the intermediate key frames during animation.
//-JavaFX provides some standard interpolators that are commonly used in animations.
// They are available as constants in the Interpolator class or as its static methods.
//  • Linear	• Discrete 	• Ease-in  • Ease-out 	• Ease-both	• Spline  • Tangent
public class InterpolatorTest extends Application {
	
	public static final Interpolator MY_INPLTR = new Interpolator() {

        @Override
        protected double curve(double t) {
        	if(t > 0.5 && t < 0.7) {
        		return t / 1.2;
        	}
        	return t;
        }

    };
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Interpolators");
		
		
		Text t1 = new Text("JavaFX - EASE_BOTH");
		t1.setFont(Font.font(24));
		
		Text t2 = new Text("JavaFX - LINEAR_INT");
		t2.setFont(Font.font(24));
		
		Text t3 = new Text("JavaFX - MY_INPLTOR");
		t3.setFont(Font.font(24));
		
		Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    
	    KeyValue kv1 = new KeyValue(t1.translateXProperty(), 200, Interpolator.EASE_BOTH);
	    KeyFrame kf = new KeyFrame(Duration.millis(5000), kv1);
	    timeline.getKeyFrames().add(kf);	    
		
	    
	    Timeline timeline2 = new Timeline();
	    timeline2.setCycleCount(Timeline.INDEFINITE);
	    timeline2.setAutoReverse(true);
	    
	    KeyValue kv2 = new KeyValue(t2.translateXProperty(), 200, Interpolator.LINEAR);
	    KeyFrame kf2 = new KeyFrame(Duration.millis(5000), kv2);
	    timeline2.getKeyFrames().add(kf2);
	    

	    Timeline timeline3 = new Timeline();
	    timeline3.setCycleCount(Timeline.INDEFINITE);
	    timeline3.setAutoReverse(true);
	    
	    KeyValue kv3 = new KeyValue(t3.translateXProperty(), 200, MY_INPLTR);
	    KeyFrame kf3 = new KeyFrame(Duration.millis(5000), kv3);
	    timeline3.getKeyFrames().add(kf3);

	    
	    
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	timeline.play();
	    	timeline2.play();
	    	timeline3.play();
	    });
	    stop.setOnAction( e->{
	    	timeline.pause();
	    	timeline2.pause();
	    	timeline3.pause();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, t1, t2, t3);
		
		Scene scene = new Scene(vb1, 450, 220);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}