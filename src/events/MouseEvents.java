package events;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//
public class MouseEvents extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Mouse Events");
    	
    	Button b1 = new Button("Send event");
    	b1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
    		System.out.println("Mouse clicked, "+e.getScreenX()+", "+e.getScreenY());
    		System.out.println("Mouse clicked, "+e.getButton()	);
    	});
 		
    	b1.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
    		System.out.println("Mouse entered");
    	});
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}