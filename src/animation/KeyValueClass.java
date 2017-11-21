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
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

//-KeyValue class represents a key value that is interpolated for a particular interval during animation. It encapsulates three things.
// • A target	• An end value for the target	• An interpolator
//-The target is a WritableValue, which qualifies all JavaFX properties to be a target.
//-The end value is the value for the target at the end of the interval.
//-The interpolator is used to compute the intermediate key frames.
//-A key frame contains one or more key values and it defines a specific point on a timeline. 
public class KeyValueClass extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("KeyValue");
		
		
		Sphere sp = new Sphere();
		PhongMaterial pm = new PhongMaterial();
		pm.setDiffuseColor(Color.RED);
		sp.setRadius(50);
		sp.setMaterial(pm);
		
		
		Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    
	    KeyValue kv1 = new KeyValue(sp.radiusProperty(), 140, Interpolator.LINEAR);	//Linear is default
	    
	    
	    KeyFrame kf = new KeyFrame(Duration.millis(2600), kv1);
	    timeline.getKeyFrames().add(kf);	    
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	timeline.play();
	    });
	    stop.setOnAction( e->{
	    	timeline.pause();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, sp);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}