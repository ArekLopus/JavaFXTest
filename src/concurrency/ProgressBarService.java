package concurrency;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ProgressBarService extends Application {
	
	private ProgressBar pb = new ProgressBar();
	private ProgressIndicator pi = new ProgressIndicator(0);
	
	private int counter;
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("ProgressBar and ProgressIndicator");
    	
    		
    	service.addEventHandler(WorkerStateEvent.ANY, new EventHandler<WorkerStateEvent>()  {

			@Override
			public void handle(WorkerStateEvent event) {
				
				EventType<? extends Event> eType = event.getEventType();
				
				if(WorkerStateEvent.WORKER_STATE_SCHEDULED == eType) {
					pb.progressProperty().bind(service.progressProperty());
					pi.progressProperty().bind(service.progressProperty());
					System.out.println("bind()");
				}
				
				if(WorkerStateEvent.WORKER_STATE_SUCCEEDED == eType || WorkerStateEvent.WORKER_STATE_CANCELLED == eType
						|| WorkerStateEvent.WORKER_STATE_FAILED == eType ) {
					pb.progressProperty().unbind();
					pi.progressProperty().unbind();
					System.out.println("unbind()");
				}
				
			}
		});
    	
    	service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent event) {
				System.out.println("Succeded from setOnSucceeded()");
			}
		}); 
    	
    	
		Button b1 = new Button("Start Progress");
		b1.setOnAction( e -> {
			service.restart();
		});
		
		HBox hb = new HBox();
		hb.setPrefHeight(70);
 		hb.setSpacing(10);
 		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb.setPadding(new Insets(10, 10, 10, 10));
 		hb.getChildren().addAll(pb, pi, b1);
		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().add(hb);
		
        Scene scene = new Scene(vb, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
	
    Service<Void> service = new Service<Void>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					System.out.println(Thread.currentThread().getThreadGroup());
					try {
						for(counter = 0; counter <= 100; counter++) {
							Thread.sleep(50);
							updateProgress(counter, 100);
						}
					} catch (InterruptedException e) {
						System.out.println("interrupted");
					}	
					return null;
				}
			};
		}
	};
    
}