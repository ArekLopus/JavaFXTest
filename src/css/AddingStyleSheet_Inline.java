package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-CSS styles for a node in a scene graph may come from style sheets or an inline style.
//-The Node class has a style property that is of StringProperty type. The style property holds the inline style for a node.
//-You can use the setStyle(String inlineStyle) and getStyle() methods to set and get the inline style of a node.
//-An inline style does not contain a selector. It consists of only set property-value pairs. 
//-An inline style affects the node on which it is set. 
public class AddingStyleSheet_Inline extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("AddingStyleSheet inline");

    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
    	b1.setStyle("-fx-text-fill: blue; -fx-font-weight: bold;");
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}