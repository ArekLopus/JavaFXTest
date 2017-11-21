package animation.transitions;

import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StrokeTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("StrokeTransition");
		
		Rectangle rec = new Rectangle(100, 50, Color.RED);
		rec.setStrokeWidth(10);
		
		StrokeTransition st = new StrokeTransition();
		st.setDuration(Duration.seconds(3));
		st.setShape(rec);
		st.setFromValue(Color.RED);
		st.setToValue(Color.YELLOW);
		st.setCycleCount(StrokeTransition.INDEFINITE);
		st.setAutoReverse(true);
		
		
	    
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	st.play();
	    });
	    stop.setOnAction( e->{
	    	st.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, rec);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}