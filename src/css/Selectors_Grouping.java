package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-If the same CSS properties apply to multiple selectors, you have two choices:
// • You can use multiple styles by duplicating the property declarations.
// • You can group all selectors into one style, separating the selectors by a comma.
public class Selectors_Grouping extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	// .text-field, .label {   -fx-text-fill: red;    }
    	Label l1 = new Label("This is a label");
    	TextField tf1 = new TextField("This is a text field");
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(l1, tf1);

		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test4.css");
        l1.requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}