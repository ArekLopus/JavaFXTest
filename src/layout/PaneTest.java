package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-Base class for layout panes which need to expose the children list as public so that users of the subclass can freely add/remove children. 
//-This class may be used directly in cases where absolute positioning of children is required since it does not perform layout
// beyond resizing resizable children to their preferred sizes. It is the application's responsibility to position the children
// since the pane leaves the positions alone during layout
//-Pane does not clip its content by default, so it is possible that childrens' bounds may extend outside its own bounds,
// either if children are positioned at negative coordinates or the pane is resized smaller than its preferred size.

//-Pane is a subclass class of the Region class. It exposes the getChildren() of the Parent class, which is the superclass of the Region class,
// This means that instances of the Pane class and its subclasses can add any children.
//-A Pane provides the following layout features:
// • It can be used when absolute positioning is needed. By default, it positions all its children at (0, 0).
//   You need to set the positions of the children explicitly.
// • It resizes all resizable children to their preferred sizes.
//-By default, a Pane has minimum, preferred, and maximum sizes. Its minimum width is the sum of the left and right insets;
// its minimum height is the sum of the top and bottom insets. Its preferred width is the width required to display all its children
// at their current x location with their preferred widths; its preferred height is the height required to display all its children
// at their current y location with their preferred heights. Its maximum width and height are set to Double.MAX_VALUE.
public class PaneTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Pane");
		
		Label l1 = new Label("Label 1");
		Label l2 = new Label("Label 2");
		
		l1.relocate(10, 10);
		l2.relocate(70, 10);
		
		
		Pane p = new Pane();
		p.getChildren().addAll(l1, l2);
		
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(p);
		
		VBox.setMargin(l2, new Insets(50));
		
		Scene scene = new Scene(vb, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}