package fxmlCustomLoaders;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlInject extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		MyFXMLLoader fxmlLoader = new MyFXMLLoader("/fxmlCustomLoaders/MyProps.properties");
		
		fxmlLoader.setLocation(this.getClass().getResource("FXMLInjectionExample.fxml"));
		fxmlLoader.setResources(ResourceBundle.getBundle("fxmlCustomLoaders.MyResourceBundle"));
		
		VBox vBox = fxmlLoader.load();
		Scene scene = new Scene(vBox);
		
		stage.setTitle("FXML Injection Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}