package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A descendant selector is used to match nodes that are descendants of another node in the scene graph.
//-A descendant selector consists of two or more selectors separated by whitespaces.
//-The term descendant in this context means a child at any level (immediate or nonimmediate). 
//-A descendant selector comes in handy when you want to style parts of JavaFX controls.
// Many controls in JavaFX consist of subnodes, which are JavaFX nodes.
// In the JavaFX CSS Reference Guide, those subnodes are listed as substructures.
// Fe, a CheckBox consists of a LabeledText (not part of the public API) with a style class name of text and a StackPane with a style class
// name of box. The box contains another StackPane with the style class name of mark. 
// You can use these pieces of information for the substructure of the CheckBox class to style the subparts. 
public class Selectors_Descendant extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	//button at any level inside VBox ->     .vbox .button {    -fx-text-fill: brown;    }
    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
    	
    	Button b2 = new Button("Testing CSS");
    	b2.setOnAction(e -> { System.out.println("Button pressed"); });
    	
    	//.check-box .text  and  .check-box .box 
    	CheckBox cb1 = new CheckBox("Styled checkbox");
    	
		VBox vb2= new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.getChildren().addAll(new Button("Inside another VBox"));
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, b2, vb2, cb1);
		
		vb.getStyleClass().add("vbox");
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test4.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}