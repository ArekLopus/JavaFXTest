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


//-A Worker is an object which performs some work in one or more background threads, and who's state is observable and available
// to JavaFX applications and is usable from the main JavaFX Application thread.
//-This interface is primarily implemented by both Task and Service, providing a common API among both classes which makes it easier
// for libraries and frameworks to provide workers which work well when developing user interfaces. 
//-A Worker may or may not be reusable depending on the implementation. A Task, for example, is not reusable while a Service is. 
//-A Worker has a well defined life cycle. 

//-The Worker interface contains nine read-only properties that represent the internal state of the task.
// • title	• message	• running	• state		• progress   •  workDone	• totalWork		• value		• exception
//They can be updated using updateMessage/Progress/Title/Value methods from impl classes and used from the main JavaFX Application thread
public class WorkerInterface extends Application {
	
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Worker Interface impl by Task");
    	
     	
    	Task<Void> task = new Task<Void>() {
    		
    		@Override
    		protected Void call() throws Exception {
    			
    			for (int i = 0; i < 100; i++) {
    				Thread.sleep(50);
    				updateMessage("Progress = "+(i+1));
				}
    			
    			return null;
    		}
    	};
    	
    	task.setOnSucceeded( e -> {
    		System.out.println("This Task completed and wont run again when you press the button again.");
    	} );
    	
    	Label l1 = new Label("Upate message");
    	l1.textProperty().bind(task.messageProperty());
    	
    	Button b1 = new Button("Press to do a simple task");
		b1.setOnAction( e -> {
			Thread th = new Thread(task);
			System.out.println(th.getName());
			th.start();
		});
		
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b1, l1);
 		
 		
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