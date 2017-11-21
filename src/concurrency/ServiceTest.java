package concurrency;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A Service creates and manages a Task that performs the work on the background thread
// Once a Service is started, it will schedule its Task and listen for changes to the state of the Task. 
//-If an Executor is specified on the Service, then it will be used to actually execute the service.
// Otherwise, a daemon thread will be created and executed.

//The Service knows about the JavaFX Application thread and is designed to relieve the application developer
//from the burden of managing multithreaded code that interacts with the user interface.
//As such, all of the methods and state on the Service are intended to be invoked exclusively from the JavaFX Application thread.
//However, once the Service has been initialized and started, it may only thereafter be used from the FX thread

//-The Service<V> abstract class implements the Worker and EventTarget interfaces.
//-The Service<V> abstract class is an impl of the Worker intf that is meant to be reused.
// It extends Worker’s state model by allowing its state to be reset to Worker.State.READY. 
//-The executor is an additional read write property of type Executor to the nine read-only properties of the Worker interface. 
//-It also has the event handler properties and the protected event callback methods just like the Task class.

//-The Service<V> object’s nine Worker properties are bound to that of the Task’s.
public class ServiceTest extends Application {
	
	private ProgressBar pb = new ProgressBar();
	private boolean exception = false;

	private Label ti = new Label("titleProperty");
	private Label ex = new Label("exceptionProperty");
	private Label ec = new Label("executorProperty");
	private Label ru = new Label("runningProperty");
	private Label st = new Label("stateProperty");
	private Label tw = new Label("totalWorkProperty");
	private Label vp = new Label("valueProperty");
	private Label wd = new Label("workDoneProperty");
	private Label me = new Label("messageProperty");
	private Label tc = new Label("Number of runs");
	
	private Label lti = new Label();
	private Label lex = new Label();
	private Label lec = new Label();
	private Label lru = new Label();
	private Label lst = new Label();
	private Label ltw = new Label();
	private Label lvp = new Label();
	private Label lwd = new Label();
	private Label lme = new Label();
	private Label ltc = new Label();

	private int counter;
	private IntegerProperty taskCountProperty = new SimpleIntegerProperty(0);

    private Service<Integer> service = new Service<Integer>() {
    	
		@Override
		protected Task<Integer> createTask() {
			return new Task<Integer>() {
			
				int sum = 0;
				
				@Override
				protected Integer call() throws Exception {
					updateTitle("Service Test");
					updateMessage("Execution strted");
					try {
						for(counter = 0; counter <= 100; counter++) {
							if(exception == true) {
								exception = false;
								updateMessage("Exception Thrown");
								System.out.println(1/0);
							}
							int sleepTime = (ThreadLocalRandom.current().nextInt(4)+1)*10;
							Thread.sleep(sleepTime);
							sum += sleepTime;
							updateProgress(counter, 100);
						}
					} catch (InterruptedException e) {
						System.out.println("interrupted");
					}
					updateMessage("Execution finished");
					
					Platform.runLater( ()->{
						taskCountProperty.set(taskCountProperty.get()+1);;
					});
					
					return sum;
				}
			};
		}
		
    	@Override
		protected void succeeded() {
			super.succeeded();
			System.out.println("succeeded() from Service");
		}
	};
	
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Service");
    	
    	service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent event) {
				System.out.println("Succeded from setOnSucceeded(), service.getValue(): "+service.getValue());
			}
		}); 
    	
    	
		Button startB = new Button("Start Progress");
		startB.setOnAction( e -> {
			service.restart();
		});
		Button cancelB = new Button("Cancel Progress");
		cancelB.setOnAction( e -> {
			service.cancel();
		});
		Button excB = new Button("Throw an exception");
		excB.setOnAction( e -> {
			exception = true;
		});
		
		pb.progressProperty().bind(service.progressProperty());
		lti.textProperty().bind(service.titleProperty());
		lex.textProperty().bind(service.exceptionProperty().asString());
		lec.textProperty().bind(service.executorProperty().asString());
		lru.textProperty().bind(service.runningProperty().asString());
		lst.textProperty().bind(service.stateProperty().asString());
		ltw.textProperty().bind(service.totalWorkProperty().asString());
		lvp.textProperty().bind(service.valueProperty().asString());
		lwd.textProperty().bind(service.workDoneProperty().asString());
		lme.textProperty().bind(service.messageProperty());
		ltc.textProperty().bind(taskCountProperty.asString());
		
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10));
		gp.setVgap(5);
		gp.setHgap(10);
		
		gp.add(pb, 0, 0);
		
		gp.add(ti, 0, 1);
		gp.add(ex, 0, 2);
		gp.add(ec, 0, 3);
		gp.add(ru, 0, 4);
		gp.add(st, 0, 5);
		gp.add(tw, 0, 6);
		gp.add(vp, 0, 7);
		gp.add(wd, 0, 8);
		gp.add(me, 0, 9);
		gp.add(tc, 0, 10);
		
		gp.add(lti, 1, 1);
		gp.add(lex, 1, 2);
		gp.add(lec, 1, 3);
		gp.add(lru, 1, 4);
		gp.add(lst, 1, 5);
		gp.add(ltw, 1, 6);
		gp.add(lvp, 1, 7);
		gp.add(lwd, 1, 8);
		gp.add(lme, 1, 9);
		gp.add(ltc, 1, 10);
		
		HBox hb = new HBox();
		hb.setSpacing(8);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(startB, cancelB, excB);
				
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(gp, hb);
		
        Scene scene = new Scene(vb, 365, 320);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}