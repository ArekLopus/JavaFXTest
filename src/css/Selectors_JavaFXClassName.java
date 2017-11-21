package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-It is allowed, but not recommended, to use the JavaFX class name as a type selector in a style.
//-A type selector differs from a class selector in that the former does not start with a period.
//-A class selector is the JavaFX class name of the node without any modification (HBOX and HBox are not the same).
//-It is not recommended to use the JavaFX class names as type selectors because the class name may be different when you subclass
// a JavaFX class. If you depend on the class name in your style sheet, the new classes will not pick up your styles.
public class Selectors_JavaFXClassName extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	//VBox {} and TextField {} used here
    	TextField tf1 = new TextField();
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(tf1);
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test3.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}