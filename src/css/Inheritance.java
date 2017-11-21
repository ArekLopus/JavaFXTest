package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-JavaFX offers two types of inheritance for CSS properties:
// • Inheritance of CSS property types
// • Inheritance of CSS property values
//-In the first type of inheritance, all CSS properties declared in a JavaFX class are inherited by all its subclasses.
// Fe, the Node class declares a cursor property and its corresponding CSS property is -fx-cursor.
// Because the Node class is the superclass of all JavaFX nodes, the -fx-cursor CSS property is available for all node types.
//-In the second type of inheritance, a CSS property for a node may inherit its value from its parent. 
// The parent of a node is the CONTAINER of the node in the scene graph, not its JavaFX superclass.
// The values of some properties of a node are inherited from its parent by default, and for some, the node needs
// to specify explicitly that it wants to inherit the values of the properties from its parent.
//-You can specify inherit as the value for a CSS property of a node if you want the value to be inherited from its parent. 
//-If a node inherits a CSS property from its parent by default, you do not need to do anything, that is,
// you do not even need to specify the property value as inherit.
//-If you want to override the inherited value, you need to specify the value explicitly (overriding the parent’s value).

//-A node inherits -fx-cursor, -fx-text-alignment, and -fx-font CSS properties from its parent by default.
public class Inheritance extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Inheritance");

    	Button b1 = new Button("Testing CSS");
    	b1.setStyle("-fx-text-fill: inherit; ");
 		
    	Button b2 = new Button("Testing CSS");
    	b2.setStyle("-fx-border-color: inherit; ");
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, b2);
		vb.setStyle("-fx-text-fill: blue; -fx-font-weight: bold; -fx-border-color: red");

		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}