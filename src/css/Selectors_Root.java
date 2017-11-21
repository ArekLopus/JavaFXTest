package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The root node of a scene is assigned a style class named "root".
//-You can use the root style class selector for CSS properties that are inherited by other nodes.
//-The root node is the parent of all nodes in a scene graph. 
//-Storing CSS properties in the root node is preferred because they can be looked up from any node in the scene graph.
public class Selectors_Root extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");

    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
    	//it uses .root class by default, no need to use vb.getStyleClass().add
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test2.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}