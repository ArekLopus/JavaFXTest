package textNode;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//
public class TextOriginTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TextOrigin");
		
		Line l = new Line(0, 2, 950, 2);
		
		Text t1 = new Text(10, 0, "VPos.CENTER Text Node");
		t1.setTextOrigin(VPos.CENTER);
		t1.setFont(Font.font(20));
		
		Text t2 = new Text(245, 0, "VPos.TOP Text Node");
		t2.setTextOrigin(VPos.TOP);
		t2.setFont(Font.font(20));
		
		Text t3 = new Text(450, 0, "VPos.BOTTOM Text Node");
		t3.setTextOrigin(VPos.BOTTOM);
		t3.setFont(Font.font(20));
		
		Text t4 = new Text(700, 0, "VPos.BASELINE Text Node");
		t4.setTextOrigin(VPos.BASELINE);
		t4.setFont(Font.font(20));
		
		Group root = new Group();
		root.getChildren().addAll(t1, t2, t3, t4, l);
		
		root.setTranslateY(100);
		
		Scene scene = new Scene(root, 950, 220);
		
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}