package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ParallelTransitionTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("ParallelTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		t1.setTranslateX(100);
		t1.setTranslateY(100);
		t1.setOpacity(0);
		
		ScaleTransition st = new ScaleTransition();
		st.setDuration(Duration.seconds(3));
		st.setNode(t1);
		st.setToX(2);
		st.setToY(2);
		st.setAutoReverse(true);
		st.setCycleCount(Animation.INDEFINITE);
		
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.seconds(3));
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.setNode(t1);
		ft.setAutoReverse(true);
		ft.setCycleCount(Animation.INDEFINITE);
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    ParallelTransition pt = new ParallelTransition();
		pt.getChildren().addAll(st, ft);
	    
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