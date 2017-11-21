package animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KeyValueClass2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("KeyValue");
		
		
		Button b1 = new Button("Test Button");
		b1.setTextFill(Color.GREEN);
		
		Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    
	    KeyValue kv1 = new KeyValue(b1.scaleXProperty(), 2);
	    KeyValue kv2 = new KeyValue(b1.scaleYProperty(), 2);
	    KeyValue kv3 = new KeyValue(b1.textFillProperty(), Color.RED);
	    
	    KeyFrame kf = new KeyFrame(Duration.millis(1600), kv1, kv2, kv3);
	    timeline.getKeyFrames().add(kf);	    
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	timeline.play();
	    });
	    stop.setOnAction( e->{
	    	timeline.pause();
	    });
	    
		StackPane sp = new StackPane();
		sp.setPrefHeight(100);
		sp.getChildren().add(b1);
	    
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, sp);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}