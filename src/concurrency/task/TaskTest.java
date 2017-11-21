package concurrency.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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

//-A fully observable implementation of a FutureTask.

//-As with FutureTask, a Task is a one-shot class and cannot be reused. See Service for a reusable Worker. 

//-Tasks exposes additional state and observable properties useful for programming asynchronous tasks in JavaFX,
// as defined in the Worker interface -> exception, message, progress, running, state, title, totalWork, value, workDone
//-An implementation of Task must override the call(). This method is invoked on the background thread.
// Any state which is used in this method must be safe to read and write from a background thread.

//-It is strongly encouraged that all Tasks be initialized with immutable state upon which the Task will operate.
// This should be done by providing a Task constructor which takes the parameters necessary for execution of the Task.
// Immutable state makes it easy and safe to use from any thread and ensures correctness in the presence of multiple threads. 

//-Since Task extends from FutureTask, it is very easy and natural to use a Task with the java concurrency Executor API. 
// Although ExecutorService defines several methods which take a Runnable, you should generally limit yourself to using
//  the execute() inherited from Executor.

//The impl of the call() may call the protected methods updateTitle(), updateMessage(), updateProgress(), and updateValue()
//to publish its internal state to the JavaFX application thread. 

public class TaskTest extends Application {
	
	private String message = "This value is set by a background thread";
	private Label l1 = new Label("Counter: ");
	private ExecutorService es = Executors.newCachedThreadPool();
	
	Task<Void> task1 = new Task<Void>() {
		
		@Override
		protected Void call() throws Exception {
			System.out.println("call() runs on thread:\t\t"+Thread.currentThread().getName());
			updateMessage(message);
			return null;
		}
	};
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Task Example");
    	System.out.println("As with FutureTask, a Task is a one-shot class and cannot be reused. See Service for a reusable Worker.\n");
    	
    	l1.textProperty().bind(task1.messageProperty());
    	
    	Button b1 = new Button("Start using new Thread()");
		b1.setOnAction( e -> {
			System.out.println("task instanceof FutureTask -> "+(task1 instanceof FutureTask));
			Thread th = new Thread(task1);
			th.start();
		});
		
		Button b2 = new Button("Start using ExecutorService");
		b2.setOnAction( e -> {
			System.out.println("task instanceof FutureTask -> "+(task1 instanceof FutureTask));
			es.execute(task2);
		});
		
 		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(b1, b2, l1);
		
        Scene scene = new Scene(vb, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    Task<Void> task2 = new Task<Void>() {
		
		@Override
		protected Void call() throws Exception {
			System.out.println("call() runs on thread:\t\t"+Thread.currentThread().getName());
			updateMessage(message);
			return null;
		}
	};
	
    
}