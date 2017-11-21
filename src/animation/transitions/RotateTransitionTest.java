package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotateTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("RotateTransition");
		
		Text t1 = new Text("JavaFX X-AXIS Anim");
		t1.setFont(Font.font(24));
		t1.setTranslateX(100);
		t1.setTranslateY(0);
		
		Text t2 = new Text("JavaFX Y-AXIS Anim");
		t2.setFont(Font.font(24));
		t2.setTranslateX(100);
		t2.setTranslateY(15);
		
		Text t3 = new Text("JavaFX Z-AXIS Anim");
		t3.setFont(Font.font(24));
		t3.setTranslateX(100);
		t3.setTranslateY(120);
		
		RotateTransition rt1 = new RotateTransition();
		rt1.setDuration(Duration.seconds(3));
		rt1.setNode(t1);
	    rt1.setAxis(Rotate.X_AXIS);
	    rt1.setToAngle(180);
	    
	    RotateTransition rt2 = new RotateTransition();
		rt2.setDuration(Duration.seconds(3));
		rt2.setNode(t2);
	    rt2.setAxis(Rotate.Y_AXIS);
	    rt2.setToAngle(180);
	    
	    RotateTransition rt3 = new RotateTransition();
		rt3.setDuration(Duration.seconds(3));
		rt3.setNode(t3);
	    rt3.setAxis(Rotate.Z_AXIS);
	    rt3.setToAngle(180);
	    
	    
		rt1.setAutoReverse(true);
		rt1.setCycleCount(Animation.INDEFINITE);
		rt2.setAutoReverse(true);
		rt2.setCycleCount(Animation.INDEFINITE);
		rt3.setAutoReverse(true);
		rt3.setCycleCount(Animation.INDEFINITE);
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	rt1.play();
	    	rt2.play();
	    	rt3.play();
	    });
	    stop.setOnAction( e->{
	    	rt1.stop();
	    	rt2.stop();
	    	rt3.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, t1, t2, t3);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}