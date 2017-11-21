package node;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-Every node maintains an observable map of user-defined properties (key/value pairs). You can use it to store any useful information.
//-Suppose you have a TextField that lets the user manipulate a person’s name. You can store the originally retrieved person’s name
// from the DB as the property of the TextField. You can use the property later to reset the name or to generate to update the name in the DB.
//-Another use of the properties would be to store micro help text. When a node receives the focus, you can read its micro help property 
// and display it, for example, in a status bar, to help the user understand the use of the node.

//-The getProperties() of the Node class returns an ObservableMap<Object, Object> in which you can add or remove properties for the node.
//-The Node class has two convenience methods, setUserData(Object value) and getUserData(), to store a user-defined value as a property
// for a node. The value specified in the setUserData() uses the same ObservableMap to store the data that are returned by the getProperties()
// The Node class uses an internal Object as the key to store the value. 
public class StoringUserData extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Storing User Data");

    	Button b1 = new Button("Test Button");
    	b1.setPrefWidth(100);
    	
    	b1.setUserData("This is user data");
    	ObservableMap<Object, Object> props = b1.getProperties();
    	props.put("MyKey", "MyValue");
    	
    	System.out.println("props.size() -> "+props.size());
    	System.out.println("props.values()[0] -> "+props.values().toArray()[0]);
    	System.out.println("props.values()[1] -> "+props.values().toArray()[1]);
    	System.out.println("b1.getUserData() -> "+b1.getUserData());
    	
    	VBox hb1 = new VBox(10);
    	hb1.getChildren().addAll(b1);
    	
    	
    	Scene scene = new Scene(hb1, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}