package eventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-An event is consumed by calling its consume(). The event class contains the method and it is inherited by all event classes. 
//-Typically, the consume() is called inside the handle() method of the event filters and handlers.
//-Consuming an event indicates to the event dispatcher that the event processing is complete
// and that the event should not travel any farther in the event dispatch chain. 
//-All event filters or handlers for the consuming node are called,
//-If a parent node does not want its child nodes to respond to an event, it can consume the event in its event filter.
// If a parent node provides a default response to an event in an event handler, a child node can provide a specific response
// and consume the event, thus suppressing the default response of the parent.
//-Typically, nodes consume most input events after providing a default response. 
public class ConsumeEvent extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Consume Event");
    	
    	CheckBox cb1 = new CheckBox("Consume?");
    	cb1.addEventHandler(EventType.ROOT, e -> {
    		e.consume();
    	});
    	
    	Button b1 = new Button("Send event");
    	b1.addEventHandler(ActionEvent.ACTION, e -> {
    		if(cb1.isSelected()) {
    			e.consume();
    		}
    		System.out.println("Button event handler");
    	});
 		
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(cb1, b1);
		
		vb.addEventHandler(ActionEvent.ACTION, e -> {
			System.out.println("VBox event handler");
		});
		
		
        Scene scene = new Scene(vb, 400, 250);
        scene.addEventHandler(ActionEvent.ACTION, e -> {
			System.out.println("Scene event handler");
		});
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}