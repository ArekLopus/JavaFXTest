package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("FadeTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.seconds(3));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setNode(t1);
	    
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
		vb1.getChildren().addAll(start, stop, t1);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}