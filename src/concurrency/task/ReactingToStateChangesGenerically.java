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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Reacting To State Changes Generically
//Sometimes you may want to react whenever a state change happens on the Task.
//	scheduled(), running(), succeeded(), cancelled(), failed()
//Convenience methods for subclasses are called whenever the state of the Task has transitioned 
public class ReactingToStateChangesGenerically extends Application {
	
	private boolean exception = false;
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Reacting To State Changes Generically");
    	
     	
    	Task<Void> task = new Task<Void>() {
    		
            @Override protected Void call() throws Exception {
                int count;
                int max = 10;
                try {
                	for (count = 0; count < max; count++) {
                		Rectangle rec = new Rectangle();
                		
                		if(exception) {
                			System.out.println(1/0);
                		}
                		
                		rec.setFill(Color.RED);
                		rec.setWidth(100);
                		rec.setHeight(20);
                		
                		Platform.runLater( () -> {
                			((VBox)stage.getScene().getRoot()).getChildren().add(rec);
                		});
                		
                        Thread.sleep(1000);
                	}
                } catch (InterruptedException interrupted) {
                    if (isCancelled()) {
                     	System.out.println("Interrupted");
                        updateMessage("Cancelled");
                    }
                }
                
                
                return null;
            }

			@Override
			protected void scheduled() {
				super.scheduled();
				System.out.println("scheduled()");
			}

			@Override
			protected void running() {
				super.running();
				System.out.println("running()");
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				System.out.println("succeeded()");
			}

			@Override
			protected void cancelled() {
				super.cancelled();
				System.out.println("cancelled()");
			}

			@Override
			protected void failed() {
				super.failed();
				System.out.println("failed()");
			}
        };
    	
    	
    	Button b1 = new Button("Start Task");
		b1.setOnAction( e -> {
			Thread th = new Thread(task);
			th.setDaemon(true);
			th.start();
		});
		Button b2 = new Button("Cancel Task");
		b2.setOnAction( e -> {
			task.cancel();
		});
		Button b3 = new Button("Exception");
		b3.setOnAction( e -> {
			exception = true;
		});
		
		Label l1 = new Label();
		l1.textProperty().bind(task.stateProperty().asString());
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b1, b2, b3 ,l1);
 		
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