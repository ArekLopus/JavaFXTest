package eventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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


public class EventHandlers extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Event handlers");
    	
    	Label l1 = new Label("");
    	l1.setPadding(new Insets(5));
    	
    	
    	Button b1 = new Button("Send event");
		b1.setOnAction( e -> {
			System.out.println("Button pressed -> setOnAction");
			System.out.println("\nEventType -> "+e.getEventType());
			System.out.println("Action Event from Button, Source -> "+e.getSource());
			System.out.println("Action Event from Button, Target -> "+e.getTarget());
		});
		
		
		b1.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				l1.setText("Button pressed");
				System.out.println("Button pressed -> addEventHandler");
			}
		});
		
		
		b1.addEventFilter(ActionEvent.ACTION, e -> {
			System.out.println("Button pressed -> addEventFilter");
		});
		
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b1, l1);
 		
 		hb1.addEventHandler(EventType.ROOT , e -> {
 			if(e.getEventType() == ActionEvent.ACTION) {
 				System.out.println("Action Event from HBox, Source -> "+e.getSource());
 				System.out.println("Action Event from HBox, Target -> "+e.getTarget());
 			}
 		});
 		
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