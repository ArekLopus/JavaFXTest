package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
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

//The executor is an additional read write property of type Executor to the nine read-only properties of the Worker interface. 
public class ServiceWithExecutor extends Application {
	
	private ExecutorService es = Executors.newCachedThreadPool();
	
	private ProgressBar pb = new ProgressBar();
	private boolean exception = false;
	private int counter;
	
	private Label ti = new Label("titleProperty");
	private Label ex = new Label("exceptionProperty");
	private Label ec = new Label("executorProperty");
	private Label ru = new Label("runningProperty");
	private Label st = new Label("stateProperty");
	private Label tw = new Label("totalWorkProperty");
	private Label vp = new Label("valueProperty");
	private Label wd = new Label("workDoneProperty");
	private Label me = new Label("messageProperty");
	
	private Label lti = new Label();
	private Label lex = new Label();
	private Label lec = new Label();
	private Label lru = new Label();
	private Label lst = new Label();
	private Label ltw = new Label();
	private Label lvp = new Label();
	private Label lwd = new Label();
	private Label lme = new Label();

	private Service<Integer> service = new Service<Integer>() {
    	
    	@Override
		protected Task<Integer> createTask() {
    		
    		setExecutor(es);
			
    		return new Task<Integer>() {
			
				int sum = 0;
				
				@Override
				protected Integer call() throws Exception {
					updateTitle("Service Test");
					updateMessage("Execution strted, thread:"+Thread.currentThread().getName());
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
					updateMessage("Execution finished, thread:"+Thread.currentThread().getName());
					return sum;
				}
			};
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
		
		gp.add(lti, 1, 1);
		gp.add(lex, 1, 2);
		gp.add(lec, 1, 3);
		gp.add(lru, 1, 4);
		gp.add(lst, 1, 5);
		gp.add(ltw, 1, 6);
		gp.add(lvp, 1, 7);
		gp.add(lwd, 1, 8);
		gp.add(lme, 1, 9);
		
		HBox hb = new HBox();
		hb.setSpacing(8);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(startB, cancelB, excB);
				
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(gp, hb);
		
        Scene scene = new Scene(vb, 865, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}