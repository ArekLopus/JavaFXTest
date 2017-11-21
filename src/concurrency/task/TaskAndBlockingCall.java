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

//A blocking call may thrown an InterruptedException, and because an InterruptedException may occur as a result
//of the Task being cancelled, we need to be sure to handle the InterruptedException and check on the cancel state.

//-Task implementation which have blocking calls should recognize that an interrupted thread may be the signal for a cancelled task
// and should double check the isCancelled() to ensure that the InterruptedException was thrown due to the cancellation of the Task. 
public class TaskAndBlockingCall extends Application {
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Task and blocking call");
    	
     	
    	Task<Integer> task = new Task<Integer>() {
            @Override protected Integer call() throws Exception {
                int count;
                int max = 10;
                for (count = 0; count < max; count++) {
                    if (isCancelled()) {
                        updateMessage("Cancelled");
                        break;
                    }
                    updateMessage("Iteration " + count);
                    updateProgress(count+1, max);

                    //When we block the thread, we need to check the interrupted exception for cancellation!
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interrupted) {
                        if (isCancelled()) {
                        	System.out.println("Interrupted");
                            updateMessage("Cancelled");
                            break;
                        }
                    }
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
		l1.textProperty().bind(task.stateProperty().asString());
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b, b2 ,l1);
 		
 		
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