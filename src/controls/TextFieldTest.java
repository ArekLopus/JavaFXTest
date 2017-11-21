package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
//Some helpful methods that you can use with text fields.
// - copy()– transfers the currently selected range in the text to the clipboard, leaving the current selection.
// - cut()– transfers the currently selected range in the text to the clipboard, removing the current selection.
// - paste()– transfers the contents in the clipboard into this text, replacing the current selection.
public class TextFieldTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TextField");
		
		Label l1 = new Label("TextField example");
		
		TextField tf1 = new TextField();
		tf1.setPromptText("This is a prompt not a value");
		
		tf1.focusedProperty().addListener( (ob, oval, nval) -> {
			if (nval) {
	            System.out.println("Focused");
	            l1.textProperty().bind(tf1.textProperty());
	        } else {
	            System.out.println("Not Focused");
	            l1.textProperty().unbind();
	            l1.setText("TextField example");
	        }
		});
		
		
		TextField tf2 = new TextField("Copy - Cut - Paste");
		Button b1 = new Button("Copy");
		b1.setFocusTraversable(false);
		Button b2 = new Button("Cut");
		b2.setFocusTraversable(false);
		Button b3 = new Button("Paste");
		b3.setFocusTraversable(false);
		
		b1.setOnAction( e->{
			tf2.copy();
		});
		b2.setOnAction( e->{
			tf2.cut();
		});
		b3.setOnAction( e->{
			tf2.paste();
		});
		
		
		TextField tf3 = new TextField();
		Button b4 = new Button("Submit");
		b4.setOnAction( e->{
			if(tf3.getText().isEmpty()) {
				System.out.println("Enter some text!");
			} else {
				System.out.println("OK");
			}
		});
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l1, tf1, tf2, b1, b2, b3, tf3, b4);
		
		Scene scene = new Scene(vb, 300, 300);
		l1.requestFocus();
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
