package concurrency.task;

import javafx.application.Application;
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

//Checking for isCancelled() in the loop body is critical, otherwise the developer may cancel the task,
//but the task will continue running and updating both the progress and returning the incorrect result from the end of the call().
//A correct implementation of a Task will always check for cancellation. 
public class TaskAndCancellation extends Application {
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Tasks Cancellation");
    	
     	
    	Task<Integer> task = new Task<Integer>() {
            @Override protected Integer call() throws Exception {
                int count;
                int max = 30_000_000;
                for (count = 0; count < max; count++) {
                    if (isCancelled()) {
                        updateMessage("Cancelled");
                        break;
                    }
                    updateMessage("Iteration " + count);
                    updateProgress(count, max);
                }
                return count;
            }
        };
    	
    	
    	task.setOnSucceeded( e -> {
    		System.out.println("Result: "+task.getValue());
    		
    	} );
    	
    	
    	Button b = new Button("Start Task");
		b.setOnAction( e -> {
			Thread th = new Thread(task);
			th.setDaemon(true);
			System.out.println(th.getName());
			th.start();
		});
		
		Button b2 = new Button("Cancel Task");
		b2.setOnAction( e -> {
			task.cancel();
		});
		
		Label l1 = new Label();
		Label l2 = new Label();
		l1.textProperty().bind(task.stateProperty().asString());
		l2.textProperty().bind(task.messageProperty());
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b, b2 ,l1, l2);
 		
 		
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