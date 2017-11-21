package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The JavaFX runtime uses the following priority rules to set the visual properties of a node:
// • Inline style (the highest priority)
// • Parent style sheets
// • Scene style sheets
// • Values set in the code using JavaFX API
// • User agent style sheets (the lowest priority)
//-A node inherits -fx-cursor, -fx-text-alignment, and -fx-font CSS properties from its parent by default.
public class PriorityRules extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Priorities");

    	Button b1 = new Button("Testing CSS");
    	b1.setStyle("-fx-font-weight: normal;");
 		
    	Button b2 = new Button("Testing CSS");
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, b2);
		vb.setStyle("-fx-font-weight: bold;");

		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}