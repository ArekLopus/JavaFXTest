package animation;

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

public class MovingShere extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Point Light");
		
		Sphere sp = new Sphere();
		PhongMaterial pm = new PhongMaterial();
		pm.setDiffuseColor(Color.RED);
		sp.setRadius(50);
		sp.setMaterial(pm);
		
		
		Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    KeyValue kv = new KeyValue(sp.translateXProperty(), 340);
	    KeyFrame kf = new KeyFrame(Duration.millis(1600), kv);
	    timeline.getKeyFrames().add(kf);
	    
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	timeline.playFrom(Duration.ZERO);;
	    });
	    stop.setOnAction( e->{
	    	timeline.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp, start, stop);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}