package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-State-based selectors are also known as pseudo-class selectors. A pseudo-class selector matches nodes based on their current states,
// Fe, matching a node that has focus or matching text input controls that are read-only.
//-A pseudo-class is preceded by a colon and is appended to an existing selector.
// Fe, .button:focused is a pseudo-class selector that matches a node with the button style class name that also has the focus;
// #openBtn:hover is another pseudo-class selector that matches a node with the ID #openBtn, when the mouse hovers over the node.
//-JavaFX CSS does not support the :first-child and :lang pseudo-classes that are supported by CSS.

//Buttons pseudo-classes: disabled, focused, hover, pressed, show-mnemonic, cancel, default, armed
public class Selectors_PseudoClass extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	//It uses => .button | .button:armed | .button:hover
    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test.css");
        
        stage.setScene(scene);
        stage.show();
    }
	
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}