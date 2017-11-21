package utilities;

import helper.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

//
public class StringConverters extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("StringConverter");
    	
    	ObservableList<User> ol = FXCollections.observableArrayList();
    	ol.addAll(new User("Joe", "Doe"), new User("John", "Rambo"), new User("Alice", "Cooper"));
    	
    	ComboBox<User> cb = new ComboBox<>(ol);
    	cb.getSelectionModel().select(1);
    	
    	cb.setOnAction( e -> {
    		User user = cb.getSelectionModel().getSelectedItem();
    		System.out.println(user);
    	});
    	
    	
    	StringConverter<User> sc = new StringConverter<User>() {

			@Override
			public String toString(User u) {
				return u.getName()+" "+u.getSurname();
			}

			@Override
			public User fromString(String string) {
				String[] split = string.split("\\ ");
				for(User u : ol) {
					if(u.getName().equals(split[0]) && u.getSurname().equals(split[1])) {
						return u;
					}
				}
				return null;	// No conversion from String needed for CB.
			}
		};
    	
    	cb.setConverter(sc);
    	    	
    	
    	User user = sc.fromString("John Rambo");
    	String string = sc.toString(ol.get(1));
    	
    	
    	System.out.println("fromString\t-> "+user);
    	System.out.println("toString\t-> "+string);
    	
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