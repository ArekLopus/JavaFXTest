package utilities;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Mnemonics are not supported on all platforms.
//Mnemonic characters in the text for controls are not underlined, at least on Windows, until the Alt key is pressed.

//-JavaFX provides the following four classes in the javafx.scene.input package to set mnemonics for all types of controls programmatically:
// • Mnemonic    • KeyCombination    • KeyCharacterCombination    • KeyCodeCombination
//-An object of the Mnemonic class represents a mnemonic.
// An object of the KeyCombination class, which is declared abstract, represents the key combination for a mnemonic.
//-The KeyCharacterCombination and KeyCodeCombination classes are subclasses of the KeyCombination class.
// Use the former to construct a key combination using a character; use the latter to construct a key combination using a key code.
//-Note that not all keys on the keyboard represent characters. The KeyCodeCombination class lets you create a key combination for any key on the keyboard.
public class Mnemonics extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Mnemonic");
    	
    	EventHandler<ActionEvent> eh = e -> {
    		System.out.println("Mnemonic used");
		};
    	
    	Button b1 = new Button("_Press ALT + P to use MnemonicParsing");
    	b1.setMnemonicParsing(true);
    	b1.setOnAction(eh);
    	
    	Button b2 = new Button("Press ALT + C to use Mnemonic");
    	b2.setOnAction(eh);
    	
    	VBox root = new VBox(5);
    	root.setPadding(new Insets(5));
    	root.getChildren().addAll(b1, b2);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	// Create a KeyCombination for Alt + C
    	KeyCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN);
    	//KeyCombination kc2 = new KeyCharacterCombination("C", KeyCombination.ALT_DOWN);
    	Mnemonic mnemonic = new Mnemonic(b2, kc1);
    	scene.addMnemonic(mnemonic);
    	
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
	//setAccelerator(KeyCombination) - Method in class javafx.scene.control.MenuItem

	
    
}