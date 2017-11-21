package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-ImageInput effect works like the ColorInput effect. It passes the given image as an input to another effect.
//-The given image is not modified by this effect.
//-Typically, it is used as an input to another effect, not as an effect directly applied to a node.
public class ImageInputTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("ImageInput");
		
		ImageInput ii = new ImageInput();
		Image image = new Image("/helper/Smile128.png", 100, 100, true, true);
		ii.setSource(image);
		
		Rectangle rect = new Rectangle(100, 100);
		MotionBlur mb = new MotionBlur();
		
		mb.setInput(ii);
		
		rect.setEffect(mb);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(rect);
		
		Scene scene = new Scene(vb1, 400, 430);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}