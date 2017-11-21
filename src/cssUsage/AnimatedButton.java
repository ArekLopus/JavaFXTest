package cssUsage;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedButton extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello");
		
		VBox vb = new VBox();
		
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
	    Button button = new Button();
	    button.setText("Cancel");
	    button.setFont(new Font("Tahoma", 24));
	    button.setEffect(new Reflection());

	    Button button2 = new Button("Just Testing");
	    
	    final Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    
	    final KeyValue kv = new KeyValue(button.opacityProperty(), 0);
	    
	    final KeyFrame kf = new KeyFrame(Duration.millis(600), kv);
	    timeline.getKeyFrames().add(kf);
	    timeline.play();
	    
		vb.getChildren().addAll(button2, button);
		
		Scene scene = new Scene(vb, 200, 200);
		scene.getStylesheets().add("/cssUsage/AnimatedButton.css");
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
