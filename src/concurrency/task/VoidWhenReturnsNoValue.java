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

//Sometimes there isn't anything to return. In such a case, you can use the Void type.
//This is a special type in the Java language which can only be assigned the value of null.
public class VoidWhenReturnsNoValue extends Application {
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Task update scene graph");
    	
     	
    	Task<Void> task = new Task<Void>() {
            @Override protected Void call() throws Exception {
            	Rectangle rec = new Rectangle();
            	
            	rec.setFill(Color.RED);
            	rec.setWidth(100);
            	rec.setHeight(20);
                		
            	Platform.runLater( () -> {
            		((VBox)stage.getScene().getRoot()).getChildren().add(rec);
            		//vb.getChildren().add(rec);			//DOES NOT WORK!
            	});
                		
                return null;
            }
        };
    	
    	
    	Button b = new Button("Start Task");
		b.setOnAction( e -> {
			Thread th = new Thread(task);
			th.setDaemon(true);
			th.start();
		});
		
		Label l1 = new Label();
		l1.textProperty().bind(task.stateProperty().asString());
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b, l1);
 		
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