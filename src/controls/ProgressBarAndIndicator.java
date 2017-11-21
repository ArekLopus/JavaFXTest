package controls;

import java.util.Arrays;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


//From 0.0 to 1.0 (0 - 100 pr)
//No value or a negative value sets the progress in the indeterminate mode. 
public class ProgressBarAndIndicator extends Application {
	
	private int counter = 0;
	private double[] progState = new double[] {-1.0, 0.0, 0.3, 0.66, 1.0};
	private HBox[] hbs = new HBox[progState.length];
	
	private ProgressBar pb = new ProgressBar();
	private ProgressIndicator pi = new ProgressIndicator(0);
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("ProgressBar and ProgressIndicator");
    	
    	for(int i = 0; i < progState.length; i++) {
    		Label l = new Label();
    		l.setText("Progress: "+progState[i]);
    		l.setPrefWidth(80);
    		
    		ProgressBar pb = new ProgressBar(progState[i]);
    		ProgressIndicator pi = new ProgressIndicator(progState[i]);
    		
    		HBox hb = new HBox();
    		hb.setSpacing(10);
    		hb.setPadding(new Insets(10, 10, 10, 10));
    		hb.getChildren().addAll(l, pb, pi);
    		hbs[i] = hb;
    	}
    	
    	
		Button b1 = new Button("Start Progress");
		b1.setOnAction( e -> {
			backgroundThread.restart();
		});
		
		HBox hb = new HBox();
 		hb.setSpacing(10);
 		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb.setPadding(new Insets(10, 10, 10, 10));
 		hb.getChildren().addAll(pb, pi, b1);
		System.out.println("pb.isIndeterminate() -> "+pb.isIndeterminate());
		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		Arrays.stream(hbs).forEach(vb.getChildren()::add);
		vb.getChildren().add(hb);
		
        Scene scene = new Scene(vb, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
	
	Service<Void> backgroundThread = new Service<Void>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					
					//this.progressProperty()
					
					for(counter = 0; counter < 100; counter++) {
						try {
							Thread.sleep(50);
							Platform.runLater(new Runnable() {
				                 @Override public void run() {
			                    	 pb.setProgress((double)counter/100);
			                    	 pi.setProgress((double)counter/100);
				                 }
				            });
							
						} catch (InterruptedException e) {
							System.out.println("interrupted");
						}	
					}
					
					return null;
				}
			};
		}
	};
    
}