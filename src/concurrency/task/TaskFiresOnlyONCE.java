package concurrency.task;

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


//Task when starts can not be run again!
//Use Service for multi runs.
public class TaskFiresOnlyONCE extends Application {
	
	private int counter = 100;
	
	private Label l1 = new Label("Counter: ");
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Task fires only once");
    	
     	Task<Void> task = new Task<Void>() {
    		
    		@Override
    		protected Void call() throws Exception {
    			
   				Platform.runLater( () -> {
   					l1.setText("Counter: "+counter);
    			});
    			return null;
    		}
    	};
    	
    	task.setOnSucceeded( e -> {
    		System.out.println("This Task completed and wont run again when you press the button again.");
    	} );
    	
    	
    	Button b = new Button("Right");
		b.setOnAction( e -> {
			Thread th = new Thread(task);
			System.out.println(th.getName());
			th.start();
		});
		
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b, l1);
 		
 		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(hb1);
		
        Scene scene = new Scene(vb, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}