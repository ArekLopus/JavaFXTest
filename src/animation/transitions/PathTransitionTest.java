package animation.transitions;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("PathTransition");
		
		Text t1 = new Text("JavaFX Animation");
		t1.setFont(Font.font(24));
		t1.setTranslateX(100);
		t1.setTranslateY(100);
		
		Circle c = new Circle(50);
		c.setTranslateX(200);
		c.setTranslateY(100);
		
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setNode(t1);
		pt.setPath(c);
	    //pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		
		
		pt.setAutoReverse(true);
		pt.setCycleCount(Animation.INDEFINITE);
		
	    Button start = new Button("Start");
	    Button stop = new Button("Stop");
	    
	    start.setOnAction( e->{
	    	pt.play();
	    });
	    stop.setOnAction( e->{
	    	pt.stop();
	    });
	    CheckBox cb = new CheckBox("NONE or ORTHOGONAL_TO_TANGENT Orientation");
	    cb.selectedProperty().addListener( (ob, ov, nv)->{
	    	if(nv) {
	    		pt.stop();
	    		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	    		pt.play();
	    	} else {
	    		pt.stop();
	    		pt.setOrientation(PathTransition.OrientationType.NONE);
	    		pt.play();
	    		
	    	}
	    });
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(start, stop, cb, t1);
		
		Scene scene = new Scene(vb1, 450, 440);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}