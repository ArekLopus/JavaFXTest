package css;

import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-You can look up a node in a scene graph by using a selector.
//-Scene and Node classes have a lookup(String selector), which returns the reference of the first node found with the specified selector.
// If no node is found, it returns null. 
//-The method in the Scene class searches the entire scene graph. 
//-The method in the Node class searches the node on which it is called and its subnodes. 
//-The Node class also has a lookupAll(String selector) that returns a Set of all Nodes that are matched by the specified selector,
// including the node on which this method is called and its subnode.
public class Selectors_LookupNodes extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	Button b1 = new Button("Testing CSS");
    	b1.setId("my_button");
    	
    	
    	VBox vb = new VBox(10);
    	vb.setId("my_vb");
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 400, 250);
        
        
        Node n1 = scene.lookup("#my_button"); 		// reference to b1
    	Node n2 = vb.lookup("#my_button"); 			// reference to b1
    	Node n3 = b1.lookup("#my_button"); 			// reference to b1
    	Node n4 = vb.lookup("#my_vb"); 				// reference to vb
    	Node n5 = b1.lookup("#my_vb"); 				// null
    	Set<Node> set = vb.lookupAll("#my_button"); // set contains the reference to b1
        
    	System.out.println(n1.getClass().getName());
    	System.out.println(n2.getClass().getName());
    	System.out.println(n3.getClass().getName());
    	System.out.println(n4.getClass().getName());
    	System.out.println(n5);
    	System.out.println(set.toArray()[0].getClass().getName());
        
    	
    	stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}