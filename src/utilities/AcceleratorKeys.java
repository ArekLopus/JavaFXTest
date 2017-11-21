package utilities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Scene class supports accelerator keys. An accelerator key, when pressed, executes a Runnable task.
//-Notice the difference between mnemonics and accelerator keys.
// A mnemonic is associated with a control, and pressing its key combination sends an ActionEvent to the control.
// An accelerator key is not associated with a control, but rather to a task.
//-The Scene class maintains an ObservableMap<KeyCombination, Runnable>, whose reference can be obtained using the getAccelerators() method.
//-The SHORTCUT key represents the shortcut key on the platform—Ctrl on Windows and Meta on Mac
public class AcceleratorKeys extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Key Accelerators");
    	
    	Button b1 = new Button("Press CTRL + X to use Key Accelerator");
    	
    	b1.setOnAction( e -> {
    		System.out.println("Mnemonic used");
    	});
    	
    	VBox root = new VBox(5);
    	root.setPadding(new Insets(5));
    	root.getChildren().addAll(b1);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    	//An accelerator key is not associated with a control, but rather to a task.
    	KeyCombination kc = new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN);
    	Runnable task = () -> System.out.println("Ctrl + X Key Accelerator used");
    	scene.getAccelerators().put(kc, task);
    	
    	//Adding to the Scene gives you a Scene-wide ability to call a global command like help
    	KeyCombination kc2 = new KeyCodeCombination(KeyCode.F1, KeyCombination.ALT_ANY);
    	Runnable task2 = () -> System.out.println("F1 Key Accelerator used");
    	scene.getAccelerators().put(kc2, task2);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
	//setAccelerator(KeyCombination) - Method in class javafx.scene.control.MenuItem

	
    
}