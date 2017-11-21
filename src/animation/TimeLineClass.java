package animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableMap;
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

//-A timeline animation is used for animating any properties of a node. An instance of the Timeline class represents a timeline animation. -Using a timeline animation involves the following steps:
// • Construct key frames
// • Create a Timeline object with key frames
// • Set the animation properties
// • Use the play() method to run the animation
//-You can add key frames to a Timeline at the time of creating it or after. Key frames are kept in an ObservableList<KeyFrame> object. The getKeyFrames() method returns the list. You can modify the list of key frames at any time.
// If the timeline animation is already running, you need to stop and restart it to pick up the modified list of key frames.
//-The Timeline class contains several constructors.
// • Timeline()	 • Timeline(double targetFramerate)  • Timeline(KeyFrame... keyFrames)  • Timeline(double targetFramerate, KeyFrame... keyFrames)
// The no-args constructor creates a Timeline with no key frames with animation running at the optimum rate.
// Other constructors let you specify the target frame rate for the animation, which is the number of frames per second, and the key frames.
//-Note that the order in which the key frames are added to a Timeline isn't important. Timeline will order them based on their time offset.
//-It is possible to create a Timeline animation with only one key frame. The key frame is treated as the last key frame.
// The Timeline synthesizes an initial key frame (for time = 0 seconds) using the current values for the WritableValue being animated. 
//-Every animation has two predefined cue points: “start” and “end.” They are set at the start and end of the animation. 
// The two cue points do not appears in the map returned by the getCuePoints() method. 
public class TimeLineClass extends Application {
	
	private Timeline timeline = new Timeline();
	private Button start = new Button("Start");
	private Button stop = new Button("Stop");
	private Button incRate = new Button("Increase");
	private Button decRate = new Button("Decrease");
	private Button cuePoint = new Button("Go to the end cue point");
	private Button cycles = new Button("Set CycleCount to 1");
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Timeline Animation");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, incRate, decRate, cuePoint, cycles, t1);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
		
		
	    EventHandler<ActionEvent> eh = e -> {
	    	System.out.println("The end reached, source: "+e.getSource().getClass());
	    };
	    
		double textWidth = t1.getLayoutBounds().getWidth();
	    
	    KeyValue endKeyValue = new KeyValue(t1.translateXProperty(), (scene.getWidth() - textWidth) - 20 );
	    KeyFrame endFrame = new KeyFrame(Duration.seconds(3), "The end cue point", eh, endKeyValue);
	    
	    timeline.getKeyFrames().addAll(endFrame);
	    timeline.setAutoReverse(true);
	    //timeline.setCycleCount(1);
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    
	    timeline.setOnFinished(eh);		//Wont fire if Timeline.INDEFINITE
	    
	    
	    start.setOnAction( e->{
	    	timeline.play();
	    });
	    stop.setOnAction( e->{
	    	timeline.pause();
	    });
	    incRate.setOnAction( e->{
	    	timeline.setRate(timeline.getRate() + 1);
	    });
	    decRate.setOnAction( e->{
	    	timeline.setRate(timeline.getRate() - 1);
	    });
	    cuePoint.setOnAction( e->{
	    	ObservableMap<String, Duration> cuePoints = timeline.getCuePoints();
	    	System.out.println("Cue points size: "+cuePoints.size());
	    	System.out.println("Cue points values: "+cuePoints.keySet());
	    	timeline.jumpTo("The end cue point");
	    });
	    cycles.setOnAction( e->{
	    	timeline.stop();
	    	timeline.setCycleCount(1);
	    	timeline.play();
	    });
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}