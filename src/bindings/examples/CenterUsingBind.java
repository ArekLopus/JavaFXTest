package bindings.examples;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CenterUsingBind extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		
		Text text = new Text("JavaFX Hello World");
		text.setTextOrigin(VPos.TOP);
		text.setFont(Font.font(null, FontWeight.BOLD, 18));
		
		Scene scene = new Scene(new Group(text), 400, 100);
		stage.setMinWidth(200);
		stage.setMinHeight(100);
		
		stage.setMaxWidth(800);
		stage.setMaxHeight(400);
		
		text.layoutXProperty().bind(scene.widthProperty().subtract(text.prefWidth(-1)).divide(2));
		text.layoutYProperty().bind(scene.heightProperty().subtract(text.prefHeight(-1)).divide(2));
		
		stage.setScene(scene);
		stage.show();
	}
}