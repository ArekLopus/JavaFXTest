package concurrency;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.ScheduledService;
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
import javafx.util.Duration;

//-The ScheduledService<V> abstract class extends the Service<V> abstract class,
//and provides repeated executions of the tasks created by the service.
//-The ScheduledService<V> class controls how its tasks are repeated through the following properties:
// • delay	   • period	 	• restartOnFailure	 		 • maximumFailureCount	 	 • currentFailureCount
// • backOffStrategy		• cumulativePeriod	 		 • maximumCumulativePeriod	 • lastValue

//-The ScheduledService is typically used for use cases that involve polling.
// Fe, you may want to ping a server on a regular basis to see if there are any updates.

//-lastValue property is the value that was last successfully computed. Because a Service clears its value property on each run,
// and because the ScheduledService will reschedule a run immediately after completion (unless it enters the cancelled or failed states),
// the value property is not overly useful on a ScheduledService. In most cases you will want to instead use the value returned by lastValue.

//-Implementer Note: The Service.ready(), Service.scheduled(), Service.running(), succeeded(), Service.cancelled(), and failed() methods
// are implemented in this class. Subclasses which also override these methods must take care to invoke the super implementation.
public class ScheduledServiceTest extends Application {
	
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
	private Label br = new Label("--------------------");
	private Label dl = new Label("delay");
	private Label pr = new Label("period");
	private Label rs = new Label("restartOnFailure");
	private Label mf = new Label("maximumFailureCount");
	private Label cf = new Label("currentFailureCount");
	private Label bo = new Label("backOffStrategy");
	private Label cp = new Label("cumulativePeriod");
	private Label mc = new Label("maximumCumulativePeriod");
	private Label lv = new Label("lastValue");
	
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
	private Label lbr = new Label();
	private Label ldl = new Label();
	private Label lpr = new Label();
	private Label lrs = new Label();
	private Label lmf = new Label();
	private Label lcf = new Label();
	private Label lbo = new Label();
	private Label lcp = new Label();
	private Label lmc = new Label();
	private Label llv = new Label();

	private int counter;
	private IntegerProperty taskCountProperty = new SimpleIntegerProperty(0);
	// • delay	   • period	 	• restartOnFailure	 		 • maximumFailureCount	 	 • currentFailureCount
	// • backOffStrategy		• cumulativePeriod	 		 • maximumCumulativePeriod	 • lastValue
    private ScheduledService<Integer> service = new ScheduledService<Integer>() {
    	
		@Override
		protected Task<Integer> createTask() {
			
			setDelay(Duration.seconds(1));
			setPeriod(Duration.seconds(3));
			setRestartOnFailure(true);
			setMaximumFailureCount(10);
			setMaximumCumulativePeriod(Duration.seconds(15));
			setBackoffStrategy(LINEAR_BACKOFF_STRATEGY);
			
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
			System.out.println("succeeded() from ScheduledService");
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
		ldl.textProperty().bind(service.delayProperty().asString());
		lpr.textProperty().bind(service.periodProperty().asString());
		lrs.textProperty().bind(service.restartOnFailureProperty().asString());
		lmf.textProperty().bind(service.maximumFailureCountProperty().asString());
		lcf.textProperty().bind(service.currentFailureCountProperty().asString());
		lbo.textProperty().bind(service.backoffStrategyProperty().asString());
		lcp.textProperty().bind(service.cumulativePeriodProperty().asString());
		lmc.textProperty().bind(service.maximumCumulativePeriodProperty().asString());
		llv.textProperty().bind(service.lastValueProperty().asString());
		
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
		gp.add(br, 0, 11);
		gp.add(dl, 0, 12);
		gp.add(pr, 0, 13);
		gp.add(rs, 0, 14);
		gp.add(mf, 0, 15);
		gp.add(cf, 0, 16);
		gp.add(bo, 0, 17);
		gp.add(cp, 0, 18);
		gp.add(mc, 0, 19);
		gp.add(lv, 0, 20);
		
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
		gp.add(lbr, 1, 11);
		gp.add(ldl, 1, 12);
		gp.add(lpr, 1, 13);
		gp.add(lrs, 1, 14);
		gp.add(lmf, 1, 15);
		gp.add(lcf, 1, 16);
		gp.add(lbo, 1, 17);
		gp.add(lcp, 1, 18);
		gp.add(lmc, 1, 19);
		gp.add(llv, 1, 20);
		
		HBox hb = new HBox();
		hb.setSpacing(8);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(startB, cancelB, excB);
				
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(gp, hb);
		
        Scene scene = new Scene(vb, 480, 590);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}