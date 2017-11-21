package animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//-A key frame defines the target state of a node at a specified point on the timeline.
// The target state is defined by the key values associated with the key frame.
//-A key frame encapsulates four things.
//	• An instant on the timeline	• A set of KeyValues	• A name	• An ActionEvent handler
//-The instant on the timeline with which the key frame is associated is defined by a Duration, which is an offset of the key frame on the timeline.
// • The set of KeyValues defines the end value of the target for the key frame.
//-A key frame may optionally have a name that can be used as a cue point to jump to the instant defined by it during an animation.
//-Optionally, you can attach an ActionEvent handler to a KeyFrame. It is called when the time for a key frame arrives during animation.
public class KeyFrameClass extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("KeyValue");
		
		Text msg = new Text("JavaFX Animation");
		msg.setFont(Font.font(24));
		
		Timeline timeline = new Timeline();
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.setAutoReverse(true);
	    
	    EventHandler<ActionEvent> ehForKeyFrame = e -> {
	    	System.out.println("The end reached, source: "+e.getSource().getClass());
	    };
	    
	    
	    
	    KeyValue initKeyValue = new KeyValue(msg.translateXProperty(), 0.0);
	    KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), 100.0);
	    
	    KeyValue initKeyValue2 = new KeyValue(msg.translateYProperty(), 0.0);
	    KeyValue endKeyValue2 = new KeyValue(msg.translateYProperty(), 100.0);
	    
	    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue, initKeyValue2);
	    KeyFrame endFrame = new KeyFrame(Duration.seconds(3), ehForKeyFrame, endKeyValue, endKeyValue2);
	    
	    timeline.getKeyFrames().addAll(initFrame, endFrame);	    
		
	    
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
		vb1.getChildren().addAll(start, stop, msg);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}