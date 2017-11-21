package concurrency;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


//java.lang.IllegalStateException: Not on FX application thread; currentThread = Thread-4
//The user interface cannot be directly updated from a non-application thread.
//Instead, use Platform.runLater() or task's update
public class DontUpdateUIFromNonAppThread extends Application {
	
	private int counter = 100;
	
	private Label l1 = new Label("Counter: ");
	private Label l2 = new Label("Counter: ");
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("ProgressBar and ProgressIndicator");
    	
    	Task<Void> task1 = new Task<Void>() {
    		////Throws: java.lang.IllegalStateException: Not on FX application thread; currentThread = Thread-4
    		@Override
    		protected Void call() throws Exception {
				l1.setText("Counter: "+counter);
    			return null;
    		}
    		
    	};

    	Task<Void> task2 = new Task<Void>() {
    		
    		@Override
    		protected Void call() throws Exception {
    			Platform.runLater( () -> {
    				l2.setText("Counter: "+counter);
    			});
    			return null;
    		}
    	};
    	
		Button b1 = new Button("Wrong");
		b1.setOnAction( e -> {
			new Thread(task1).start();;
		});
		
		Button b2 = new Button("Right");
		b2.setOnAction( e -> {
			new Thread(task2).start();;
		});
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b1, l1);
		
 		HBox hb2 = new HBox();
 		hb2.setSpacing(10);
 		hb2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb2.setPadding(new Insets(10, 10, 10, 10));
 		hb2.getChildren().addAll(b2, l2);
 		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(hb1, hb2);
		
        Scene scene = new Scene(vb, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}