package fxml2;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NamespaceContainsAllNodes extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NamespaceContainsAllNodes.fxml"));
		
		loader.setBuilderFactory(new ItemBuilderFactory());

		Parent root = loader.load();
		
		Scene scene = new Scene(root, 450, 400);
		stage.setScene(scene);
        stage.show();
        
        System.out.println("---------------------------------------");
        ObservableMap<String,Object> namespace = loader.getNamespace();
        namespace.entrySet().forEach(System.out::println);
        System.out.println("---------------------------------------");
        
        System.out.println(scene.lookup("VBox"));
        System.out.println(scene.lookup("#str1"));
        System.out.println(scene.lookup("#controller"));
        //System.out.println(loader.); 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
