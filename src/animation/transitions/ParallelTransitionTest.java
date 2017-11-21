package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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

public class ParallelTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("ParallelTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.seconds(3));
		tt.setNode(t1);
	    tt.setToX(120);
	    tt.setToY(100);
	    
		tt.setAutoReverse(true);
		tt.setCycleCount(Animation.INDEFINITE);
		
		ScaleTransition st = new ScaleTransition();
		st.setDuration(Duration.seconds(3));
		st.setNode(t1);
		st.setToX(2);
		st.setToY(2);
	    
		RotateTransition rt = new RotateTransition();
		rt.setDuration(Duration.seconds(3));
		rt.setNode(t1);
	    rt.setAxis(Rotate.Y_AXIS);
	    rt.setToAngle(360);
	    
	    rt.setAutoReverse(true);
		rt.setCycleCount(Animation.INDEFINITE);
		
		st.setAutoReverse(true);
		st.setCycleCount(Animation.INDEFINITE);
		
		ParallelTransition pt = new ParallelTransition();
		pt.getChildren().addAll(tt, st, rt);
		
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	pt.play();
	    });
	    stop.setOnAction( e->{
	    	pt.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, t1);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}