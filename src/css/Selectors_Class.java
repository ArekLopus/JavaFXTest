package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Node class defines a styleClass variable that is an ObservableList<String>.
// Its purpose is to maintain a list of JavaFX style class names for a node. 
// Note that the JavaFX class name and the style class name of a node are two different things. A JavaFX class name of a node
// is a Java class name, fe, javafx.scene.layout.VBox, which is used to create objects of that class.
//-A style class name of a node is a string name that is used in CSS styling.
//-You can assign multiple CSS class names to a node: hb.getStyleClass().addAll("hbox", "myhbox");
//-A style class selector applies the associated style to all nodes, which have the same style class name as the name of the selector.
//-A style class selector starts with a period followed by the style class name.
// Note that style class names of nodes dont start with a period.

//-Most of the commonly used controls in JavaFX have a default style class name. You can add more style class names if needed.
//-The default style class names are constructed from the JavaFX class names. The JavaFX class name is converted to lowercase
// and a hyphen is inserted in the middle of two words. If the JavaFX class name consists of only one word, the corresponding
// default style class name is created by just converting it to lowercase.
//-Fe, the default style class name is button for Button, label for Label, hyperlink for Hyperlink,
// text-field for TextField, text-area for TextArea, check-box for CheckBox.
//-JavaFX container classes, fe, Region, Pane, HBox, VBox, do not have a default style class name. If you want to style them
// using style class selectors, you need to add a style class name to them.
public class Selectors_Class extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");

    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
		vb.getStyleClass().addAll("vbox", "vbox2");
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}