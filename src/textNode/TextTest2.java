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

//
public class TextTest2 extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Text Node");
		
		
		Text t1 = new Text("Text Stroke test");
		t1.setFont(Font.font(null, FontWeight.BOLD, 36));
		t1.setStroke(Color.YELLOW);
		
		Text t2 = new Text("Text Fill test");
		t2.setFont(Font.font(null, FontWeight.BOLD, 36));
		t2.setFill(Color.YELLOW);
		t2.setStroke(Color.BLACK);
		
		Text t3 = new Text("Text Strikethrough test");
		t3.setFont(Font.font(36));
		t3.setStrikethrough(true);
		
		Text t4 = new Text("Text Underline test");
		t4.setFont(Font.font(36));
		t4.setUnderline(true);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1, t2, t3, t4);
		
		Scene scene = new Scene(vb1, 450, 400);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}