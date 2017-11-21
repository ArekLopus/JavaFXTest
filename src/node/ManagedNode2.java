package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//-Sometimes you may want to use the space that is used by a node if the node becomes invisible. Suppose you have an HBox with several buttons.
// When one of the buttons becomes invisible, you want to slide all buttons from right to left. You can achieve a slide-up effect in VBox.
// Achieving sliding effects in HBox and Vbox (or any other containers with relative positioning) is easy
// by binding the managed property of the node to the visible property: 	b2.managedProperty().bind(b2.visibleProperty());
public class ManagedNode2 extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("");
    	
    	Button b1 = new Button("Button 1");
    	Button b2 = new Button("Button 2");
    	Button b3 = new Button("Set Visible Button2");
    	b3.setOnAction( e -> {
    		if(b2.isVisible()) {
    			b2.setVisible(false);
    		} else {
    			b2.setVisible(true);
    		}
    		
    	});
    	
    	b2.setVisible(false);
    	b2.managedProperty().bind(b2.visibleProperty());
    	
    	HBox hb1 = new HBox(10);
    	hb1.getChildren().addAll(b1, b2, b3);
    	
    	
    	Scene scene = new Scene(hb1, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}