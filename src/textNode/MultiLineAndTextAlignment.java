package textNode;

import helper.Helper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

//-A Text node is capable of displaying multiple lines of text. It creates a new line in two cases:
// • A newline character ‘\n’ in the text.
// • The Text class contains a wrappingWidth property, which is 0.0 by default. Its value is specified in pixels.
//-The lineSpacing property specifies the vertical spacing in pixels between two lines. It is 0.0 by default.
//-The textAlignment property specifies the horizontal alignment of the text lines in the bounding box. 
// TextAlignment enum: LEFT, RIGHT< CENTER, and JUSTIFY. The default is TextAlignment.LEFT.
public class MultiLineAndTextAlignment extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("MultiLine And TextAlignment");
		
		Text t1 = new Text("This text uses\n'\\n' newline character ");
		
		Text t2 = new Text("This text uses WrappingWidth property = 300 pixels\n"+Helper.TEXT_LOREM);
		t2.setWrappingWidth(300);
		
		Text t3 = new Text("This text uses TextAlignment.RIGHT\n"+Helper.TEXT_LOREM);
		t3.setWrappingWidth(200);
		t3.setTextAlignment(TextAlignment.RIGHT);
		
		Text t4 = new Text("This text uses TextAlignment.CENTER\n"+Helper.TEXT_LOREM);
		t4.setWrappingWidth(200);
		t4.setTextAlignment(TextAlignment.CENTER);
		
		Text t5 = new Text("This text uses TextAlignment.JUSTIFY\n"+Helper.TEXT_LOREM);
		t5.setWrappingWidth(200);
		t5.setTextAlignment(TextAlignment.JUSTIFY);
		
		
		HBox hb1 = new HBox(10);
		hb1.setPadding(new Insets(10));
		hb1.getChildren().addAll(t3, t4, t5);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1, t2, hb1);
		
		Scene scene = new Scene(vb1, 650, 600);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}