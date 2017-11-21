package fxmlController;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//It is often preferable to define more complex application logic in a compiled, strongly-typed language such as Java. 
//-The fx:controller attribute allows a caller to associate a "controller" class with an FXML document.
//A controller is a compiled class that implements the "code behind" the object hierarchy defined by the document.
//The controller can define an initialize() which will be called once on an implementing controller when the contents of its associated document have been completely loaded
//	public void initialize();	   or when class implements Initializable 		public void initialize(URL url, ResourceBundle rb);
//-This allows the implementing class to perform any necessary post-processing on the content. It also provides the controller with access to the resources
//that were used to load the document and the location that was used to resolve relative paths within the document (commonly equivalent to the location of the document itself).

//@FXML
//If fields and event handler methods are declared as public they can be set or invoked by the loader.
//In practice, this is not often an issue, since a controller is generally only visible to the FXML loader that creates it.
//@javafx.fxml.FXML annotation can be used to restrict visibility for controller fields or handler methods.
//This annotation marks a protected or private class member as accessible to FXML. 
//-Note that the @FXML annotation can currently only be used with trusted code. Because the FXML loader relies on reflection to set member fields and invoke member methods,
//it must call setAccessible() on any non-public Field. setAccessible() is a privileged operation that can only be executed in a secure context.
//This may change in a future release.

//-The FXMLLoader class is responsible for actually loading an FXML source file and returning the resulting object graph.
//-Note that the output of an FXMLLoader#load() operation is an instance hierarchy that reflects the actual named classes in the document,
// not org.w3c.dom nodes representing those classes.
//-Internally, FXMLLoader uses the javax.xml.stream API (also known as the Streaming API for XML, or StAX) to load an FXML document
public class Example extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		//FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Example.fxml"), ResourceBundle.getBundle("fxmlController.example"));
		FXMLLoader fxmlLoader = new FXMLLoader();
		
		fxmlLoader.setResources(ResourceBundle.getBundle("fxmlController.Example"));
		fxmlLoader.setLocation(this.getClass().getResource("Example.fxml"));
		
		Parent root = fxmlLoader.load();

		ExampleController controller = (ExampleController)fxmlLoader.getController();
		if(controller != null) {
			System.out.println("Controller loader -> "+controller.getClass().getName());
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
