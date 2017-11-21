package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A selector can use the combination of a style class and an ID.
// In this case, the selector matches all nodes with the specified style class and ID. 
public class Selectors_IdAddClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");

    	// .button#my_button  has higher specificity than  #my_button.button  here
    	Button b1 = new Button("Testing CSS");
    	b1.setId("my_button");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test4.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}