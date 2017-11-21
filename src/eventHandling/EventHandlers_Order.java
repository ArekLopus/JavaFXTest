package eventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//-There are some execution order rules for event filters and handlers for both similar and different nodes:
// • Event filters are called before event handlers. Event filters are executed from the topmost parent to the event target in the parent-child order. Event handlers are executed in the reverse order of the event filters. That is, the execution of the event handlers starts at the event target and moves up in the child-parent order.
// • For the same node, event filters and handlers for a specific event type are called before the event filters and handlers
//   for generic types. Suppose you have registered event handlers to a node for MouseEvent.ANY and MouseEvent.MOUSE_CLICKED.
//   Event handlers for both event types are capable of handling mouse-clicked events. When the mouse is clicked on the node,
//   the event handler for the MouseEvent.MOUSE_CLICKED event type is called before the event handler for the MouseEvent.ANY event type.
//   Note that a mouse-pressed event and a mouse-released event occur before a mouse-clicked event occurs.
//   In our example, these events will be handled by the event handler for the MouseEvent.ANY event type.
// • The order in which the event filters and handlers for the same event type for a node are executed is not specified.
//   There is one exception to this rule.
//   Event handlers registered to a node using the addEventHandler() are executed before the event handlers registered using the setOnXXX() convenience methods.
public class EventHandlers_Order extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Event handlers");
    	
    	Label l1 = new Label("");
    	l1.setPadding(new Insets(5));
    	
    	
    	Button b1 = new Button("Send event");
		b1.setOnAction( e -> {
			System.out.println("Button pressed -> setOnAction");
		});
		
		b1.addEventHandler(ActionEvent.ACTION, e -> {
			System.out.println("Button pressed -> ActionEvent.ACTION");
		});
		
		b1.addEventHandler(ActionEvent.ANY, e -> {
			System.out.println("Button pressed -> ActionEvent.ANY");
		});
		
		b1.addEventFilter(ActionEvent.ACTION, e -> {
			System.out.println("Button pressed -> EventFilter - MouseEvent.ANY");
		});
		
		
		HBox hb1 = new HBox();
 		hb1.setSpacing(10);
 		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
 		hb1.setPadding(new Insets(10, 10, 10, 10));
 		hb1.getChildren().addAll(b1, l1);
 		
 		
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