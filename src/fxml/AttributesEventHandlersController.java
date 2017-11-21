package fxml;

import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;

public class AttributesEventHandlersController {
	
	//In general, a handler method should conform to the signature of a standard event handler; that is, it should take a single argument
	//of a type that extends javafx.event.Event and should return void.
	//The event argument often carries important and useful info about the nature of the event; however, it is optional and may be omitted if desired. 
	@FXML
	private void buttonEventHandlerWithEventArgument(ActionEvent e) {
		System.out.println("Button clicked! - controller.buttonEventHandlerWithEventArgument() -> "+e.getTarget());
	}

	@FXML
	private void buttonEventHandler() {
		System.out.println("Button clicked! - controller.buttonEventHandler()");
	}

	//To work it needs a GETTER!
	@FXML
    public EventHandler<ActionEvent> ah = e -> {
    	System.out.println("EventHandler<ActionEvent> ah property from the Controller");
    };
	
    
    @FXML
	private void buttonEventHandlerToHandleChildrenChange(ActionEvent e) {
    	//Button b = (Button)e.getTarget();
    	Control b = (Control) e.getTarget();
		VBox vb = (VBox) b.getScene().getRoot();
		vb.getChildren().add(new Button("Abc"));
	}
    
    
    @FXML
	private void handleChildrenChange(ListChangeListener.Change c) {
		System.out.println("Children changed -> handleChildrenChange - controller.handleChildrenChange()");
	}

    
    @FXML
	private void buttonEventHandlerToHandlePropertyChange(ActionEvent e) {
    	Control btn = (Control) e.getTarget();
    	VBox vb = (VBox) btn.getScene().getRoot();
    	vb.setSpacing(10);
	}
    
    @FXML
    public void handlePropertyChange(ObservableValue value, Object oldValue, Object newValue) {
        System.out.println("VBox's Spacing property changed!");
    }
	
    
	@FXML
	public void initialize() {
		System.out.println("Controller initialized.");
		
	}
	
	
	public EventHandler<ActionEvent> getAh() {
		return ah;
	}

	public void setAh(EventHandler<ActionEvent> ah) {
		this.ah = ah;
	}
	
	
}
