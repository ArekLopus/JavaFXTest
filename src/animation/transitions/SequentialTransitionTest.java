package animation.transitions;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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

public class SequentialTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("SequentialTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		
		TranslateTransition tt = new TranslateTransition();
		tt.setDuration(Duration.seconds(2));
		tt.setNode(t1);
	    tt.setToX(100);
	    tt.setToY(100);
		tt.setCycleCount(1);
		tt.setOnFinished( e->{ System.out.println("TranslateTransition 1 finished"); });
		
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(1));
		pt.setOnFinished( e->{ System.out.println("PauseTransition finished"); });

		
		TranslateTransition tt2 = new TranslateTransition();
		tt2.setDuration(Duration.seconds(2));
		tt2.setNode(t1);
	    tt2.setToX(150);
		tt2.setCycleCount(1);
		tt2.setOnFinished( e->{ System.out.println("TranslateTransition 2 finished"); });
		
		
		SequentialTransition st = new SequentialTransition();
		st.getChildren().addAll(tt, pt, tt2);
		
		
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
		vb1.getChildren().addAll(start, stop, t1);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}