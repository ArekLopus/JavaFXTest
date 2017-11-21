package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-An asterisk (*) is used as a universal selector, which matches any node. 
//-The universal selector has the lowest specificity.
//-When the universal selector does not appear by itself, it can be ignored. Fe, the selectors *.button and .button are the same.
public class Selectors_Universal extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");

    	Button b1 = new Button("Testing CSS");
    	b1.setId("my_button");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
    	
    	//Universal selector used here
    	Button b2 = new Button("Testing CSS");
    	b2.setOnAction(e -> { System.out.println("Button pressed"); });
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, b2);
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test4.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}