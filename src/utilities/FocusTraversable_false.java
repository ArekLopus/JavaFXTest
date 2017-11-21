package utilities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-Specifies whether this Node should be a part of focus traversal cycle.
// When this property is true focus can be moved to this Node and from this Node using regular focus traversal keys.
// On a desktop such keys are usually TAB for moving focus forward and SHIFT+TAB for moving focus backward.
// When a Scene is created, the system gives focus to a Node whose focusTraversable variable is true and that is eligible to receive the focus,
// unless the focus had been set explicitly via a call to requestFocus().
public class FocusTraversable_false extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("setFocusTraversable()");
		
		TextField tf = new TextField("Only Button 3 can get the focus");
		Button b1 = new Button("Button 1");
		b1.setFocusTraversable(false);
		Button b2 = new Button("Button 2");
		b2.setFocusTraversable(false);
		Button b3 = new Button("Button 3");
		
		b1.setOnAction( e->{
			tf.setText("Button 1 has no focus");
		});
		b2.setOnAction( e->{
			tf.setText("Button 2 has no focus");
		});
		b3.setOnAction( e->{
			tf.setText("Button 3 has focus");
		});
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(tf, b1, b2, b3);
		
		Scene scene = new Scene(vb, 300, 300);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
