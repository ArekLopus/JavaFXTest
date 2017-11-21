package eventHandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


public class EventHandler_Basics extends Application {
	
	private Button b1 = new Button("Action event");
	private Button b2 = new Button("Mouse event");
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Event handlers");
    	
    	
    					//Type of event to react, action handler
    	b1.addEventHandler(ActionEvent.ACTION, e -> {
    		System.out.println("ActionEvent.ACTION event");
    	});
    	
    	b2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
    		System.out.println("MouseEvent.MOUSE_CLICKED event");
    	});
    	b2.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
    		System.out.println("MouseEvent.MOUSE_EXITED event");
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