package eventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class EventHandler_Define extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Event handlers");
    	
    	//Before Java 8
    	EventHandler<ActionEvent> eh1 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button pressed -> eh1");
			}
		};
    	
		//Java 8 lambda
		EventHandler<ActionEvent> eh2 = e -> {
			System.out.println("Button pressed -> eh2");
		};
		
    	
    	Button b1 = new Button("Send event");
    	b1.addEventHandler(ActionEvent.ACTION, eh1);
    	b1.addEventHandler(ActionEvent.ANY, eh2);
    	b1.addEventHandler(ActionEvent.ANY, e -> {
    		System.out.println("Button pressed -> eh3");
    	});
    	
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10));
 		hb1.getChildren().addAll(b1);
 		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		
		vb.getChildren().addAll(hb1);
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}