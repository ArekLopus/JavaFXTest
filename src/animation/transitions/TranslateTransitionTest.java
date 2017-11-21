package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TranslateTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TranslateTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.seconds(3));
		tt.setNode(t1);
	    tt.setToX(100);
	    tt.setToY(100);
	    
		tt.setAutoReverse(true);
		tt.setCycleCount(Animation.INDEFINITE);
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	tt.play();
	    });
	    stop.setOnAction( e->{
	    	tt.stop();
	    });
	    
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, t1);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}