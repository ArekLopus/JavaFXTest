package utilities;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

//https://docs.oracle.com/javase/8/javafx/api/javafx/util/Callback.html
//-The Callback interface is designed to allow for a common, reusable interface to exist for defining APIs that requires a call back in certain situations.
//-This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
//-Callback is defined with two generic parameters:
// the first parameter specifies the type of the object passed in to the call method,
// the second parameter specifying the return type of the method.

//Callback<P,R>	intf -> 	R rall(P param)
public class CallbackIntf extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Callback interface");
    	
    	ObservableList<String> ol = FXCollections.observableArrayList();
    	ol.addAll("One","Two","Three","Four");
    	
    	ComboBox<String> cb = new ComboBox<>(ol);
    	cb.setValue("One");

    	cb.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				ListCell<String> lc = new ListCell<String>() {

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						setText(item); 
					    setGraphic(null); 
					    setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(10), new Insets(1))));
					    setTextFill(Color.BLUE);
					}
				};
				return lc;
			}
		});
    	
    	
    	//Another example - FXMLLoader with custom controller loader
    	FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			public Object call(Class<?> cl) {
				
				try {
					Object contrInstance = cl.newInstance();
					return contrInstance;
				} catch (InstantiationException | IllegalAccessException ex) {
		            throw new IllegalStateException("Cant instantiate a controller: " + cl, ex);
		        }
			}
		});
    	
    	
    	VBox root = new VBox(5);
    	root.setPadding(new Insets(5));
    	root.getChildren().addAll(cb);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}