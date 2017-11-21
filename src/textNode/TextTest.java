package textNode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//-A text node is an instance of the Text class that is used to render text.
//-A Text is a Shape, which allows you to use all properties and methods of the Shape class on a Text node.
// Fe, you can apply a fill color and a stroke to a Text node.
//-Because Text is a node, you can use features of the Node class: fe, applying effects and transformations.
// You can also set text alignment, font family, font size, text wrapping style, etc.
//-By default, a system default font is used to render.
public class TextTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Text Node");
		
		
		Text t1 = new Text();
		t1.setText("JavaFX text");
		
		Text t2 = new Text("JavaFX text");
		t2.setFont(Font.font(24));
		
		Text t3 = new Text("JavaFX text");
		t3.setStroke(Color.BLACK);
		t3.setFill(Color.YELLOW);
		t3.setFont(Font.font("Arial", FontWeight.BOLD, 36));
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1, t2, t3);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}