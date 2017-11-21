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

//-If you want a node to process events of specific types, you need to register event filters and handlers for those event types to the node.
//-When the event occurs, the handle() method of the registered event filters and handlers for the node are called 
//-JavaFX provides two ways to register and unregister event filters and handlers to nodes:
//  • Using the addEventFilter(), addEventHandler(), removeEventFilter(), and removeEventHandler() methods
//  • Using the onXXX convenience properties
//-Registering the same EventHandler object as event filters as well as handlers is allowed.

//-The Node, Scene, and Window classes contain event properties to store event handlers of some selected event TYPES. 
//-The property names use the event type pattern. They are named as onXXX.
//  Fe, the onMouseClicked property stores the event handler for the mouse-clicked event type;
//  the onKeyTyped property stores the event handler for the key-typed event, and so on.
//-They only support the registration of event handlers, not event filters
//-They only support the registration of one event handler for a node. Multiple event handlers for a node -> addEventHandler().
//-These properties exist only for the commonly used events for a node type.
//-They do not provide a separate method to unregister the event handler. Setting the property to null unregisters the event handler
public class EventHandler_Register extends Application {
	
	private Button b1 = new Button("Send event");
	private Button b2 = new Button("Remove handlers");
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Event handlers");
    	
    	EventHandler<ActionEvent> eh1 = e -> {
    		System.out.println("EventHandler for Button");
		};
    	
		EventHandler<ActionEvent> ef1 = e -> {
			System.out.println("EventFilter for Button");
		};
    	
    	
    	b1.addEventHandler(ActionEvent.ANY, eh1);
    	b1.addEventFilter(ActionEvent.ANY, ef1);
    	b1.setOnAction( e-> {
    		System.out.println("EventHandler -> setOnAction");
    	});
    	
    	b2.setOnAction(e -> {
    		b1.removeEventFilter(ActionEvent.ANY, ef1);
    		b1.removeEventHandler(ActionEvent.ANY, eh1);
    	});
		
    	
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10));
 		hb1.getChildren().addAll(b1, b2);
 		
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