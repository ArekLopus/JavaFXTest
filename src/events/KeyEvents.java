package events;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A key event is a type of input event that denotes the occurrence of a keystroke.
//-It is delivered to the node that has focus.
//-An instance of the KeyEvent class, which is declared in the javafx.scene.input package, represents a key event.
//-Key pressed, key released, and key typed are three types of key events.
//-By default, shapes are not part of the focus traversal chain and mouse clicks do not bring focus to them.
// Shape nodes can get focus by calling the requestFocus().
public class KeyEvents extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Key Events");
    	
    	TextField tf1 = new TextField();
    	tf1.addEventHandler(KeyEvent.ANY, e -> {
    		System.out.println("Code -> "+e.getCode()+", EventType -> "+e.getEventType());
    	});
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(tf1);
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}