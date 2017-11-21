package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FillTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("FillTransition");
		
		Rectangle rec = new Rectangle(100, 50, Color.RED);
		
		FillTransition ft = new FillTransition();
		ft.setDuration(Duration.seconds(3));
		//ft.setFromValue(Color.RED);
		ft.setToValue(Color.YELLOW);
		ft.setShape(rec);
		
		ft.setAutoReverse(true);
		ft.setCycleCount(Animation.INDEFINITE);
	    
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	ft.play();
	    });
	    stop.setOnAction( e->{
	    	ft.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, rec);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}