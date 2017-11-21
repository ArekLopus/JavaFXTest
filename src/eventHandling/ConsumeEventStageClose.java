package eventHandling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsumeEventStageClose extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Consume Event");
    	
    	CheckBox cb1 = new CheckBox("Consume window close event?");
    	cb1.setSelected(true);
    	
    	stage.setOnCloseRequest( e -> {
    		System.out.println("Close requested, event -> "+e.getEventType());
    		if(cb1.isSelected()) {
				e.consume();		//We can consume an event if we dont want to really close a window.
				System.out.println("Stage Close event was consumed");
			}
			
		});
    	
    	VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(cb1);
		
		Scene scene = new Scene(vb, 400, 250);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}