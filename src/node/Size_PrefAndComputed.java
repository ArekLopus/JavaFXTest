package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Region and Control classes define two constants that act as sentinel values for the intrinsic sizes of nodes. Those constants are:
// • USE_COMPUTED_SIZE	• USE_PREF_SIZE
//-Both constants are of double type. The values for USE_COMPUTED_SIZE and USE_PREF_SIZE are -1 and Double.NEGATIVE_INFINITY. 
// It was not documented as to why the same constants were defined twice.
// Maybe the designers did not want to move them up in the class hierarchy, as they do not apply to all types of nodes.
//-USE_COMPUTED_SIZE - the node will compute that size automatically based on its contents and properties settings.
//-USE_PREF_SIZE - used to set the minimum and maximum sizes if they are the same as the preferred size.
public class Size_PrefAndComputed extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Size USE_COMPUTED_SIZE and USE_PREF_SIZE");

    	Button b1 = new Button("Resizable");
    	//b1.setPrefWidth(200);
    	b1.setPrefWidth(Region.USE_COMPUTED_SIZE);
    	
    	HBox hb1 = new HBox(10);
    	hb1.getChildren().addAll(b1);

    	
    	Button b2 = new Button("Resizable");
    	b2.setMinWidth(40);
    	b2.setPrefWidth(200);
    	b2.setMaxWidth(1000);
    	b2.setPrefWidth(Region.USE_PREF_SIZE);
    	
    	HBox hb2 = new HBox(10);
    	hb2.getChildren().addAll(b2);
    	
    	VBox root = new VBox(10);
    	root.getChildren().addAll(hb1, hb2);
    	
    	Scene scene = new Scene(root, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}