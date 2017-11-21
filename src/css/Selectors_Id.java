package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Node class has an id property of the StringProperty type, which can be used to assign a unique id to each node in a scene graph.
//-The uniqueness of an id in a scene graph is the responsibility of the developer. It is not an error to set a duplicate id for a node.
//-You do not use the id property of a node directly in your code, except when you are setting it.
// It is mainly used for styling nodes using ID selectors.
//-An ID selector in a style sheet is preceded by the pound (#) sign. 

//-In cases where there are multiple selectors matching a node, JavaFX uses the specificity of selectors to determine which selector will be used.
// In cases where a class selector and an ID selector are used, the ID selector has higher specificity.
public class Selectors_Id extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");

    	Button b1 = new Button("Testing CSS");
    	//the ID selector has higher specificity so color from it is used instead of .button class
    	b1.setId("my_button");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test3.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}