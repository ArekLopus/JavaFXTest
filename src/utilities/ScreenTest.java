package utilities;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Screen.html
//-Although it is not mentioned in the API doc for the Screen class, you cannot use this class until the JavaFX launcher has started.
// That is, you cannot get screen descriptions in a non-JavaFX application.
//-This is the reason that you would write the code in the start() method of a JavaFX application class.
// There is no requirement that the Screen class needs to be used on the JavaFX Application Thread. You could also write the same code in the init() method of your class.
public class ScreenTest extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Screen class");
    	
    	Screen scr = Screen.getPrimary();
    	ObservableList<Screen> scrs = Screen.getScreens();
    	
    	System.out.println("Screens: "+scrs.size());
    	System.out.println("Screens DPI: "+scr.getDpi());
    	System.out.println("getBounds(): "+scr.getBounds());
    	System.out.println("getVisualBounds(): "+scr.getVisualBounds());
    	
    	
    	VBox root = new VBox(5);
    	root.setPadding(new Insets(5));
    	root.getChildren().addAll();
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}