package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//The Shadow effect creates a shadow with blurry edges of its input.
//Unlike DropShadow and InnerShadow, it modifies the original input itself to convert it into a shadow.
public class ShadowTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("InnerShadow effect");
		
		Shadow sh = new Shadow();
		
		Rectangle rect = new Rectangle(100, 50, Color.GRAY);
		
		rect.setEffect(sh);
		
		Slider widthSl = new Slider(-100, 100, 10);
		sh.widthProperty().bind(widthSl.valueProperty());
		Slider heightSl = new Slider(-100, 100, 10);
		sh.heightProperty().bind(heightSl.valueProperty());
		
		Slider radiusSl = new Slider(0, 127, 10);
		sh.radiusProperty().bind(radiusSl.valueProperty());
		
		ColorPicker cp = new ColorPicker(Color.BLACK);
		sh.colorProperty().bind(cp.valueProperty());
		
		ComboBox<BlurType> cb = new ComboBox<>();
		cb.getItems().addAll(BlurType.ONE_PASS_BOX, BlurType.TWO_PASS_BOX, BlurType.THREE_PASS_BOX, BlurType.GAUSSIAN);
		cb.setValue(sh.getBlurType());
		sh.blurTypeProperty().bind(cb.valueProperty());
		
		//Create a Glow effect using a Shadow
		Text text1 = new Text("Glow effect using a Shadow");
		text1.setFont(Font.font(24));
		Text text2 = new Text("Glow effect using a Shadow");
		text2.setFont(Font.font(24));
		Shadow shadow = new Shadow();
		shadow.setColor(Color.RED);
		text2.setEffect(shadow);
		StackPane sp = new StackPane(text1, text2);
		Separator sep1 = new Separator();
		Separator sep2 = new Separator();
		
		HBox vb1 = new HBox(10);
		vb1.setPadding(new Insets(50, 0, 50, 150));
		vb1.getChildren().addAll(rect);
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Radius:"), radiusSl);
		gp.addRow(1, new Label("Color:"), cp, new Label("Blur Type:"), cb);
		
		VBox vb2 = new VBox(10);
		vb2.setPadding(new Insets(10));
		Label l1 = new Label("Unlike DropShadow, it modifies the original input itself to convert it into a shadow.");
		l1.setFont(Font.font(11));
		vb2.getChildren().addAll(l1, vb1, gp, sep1, sp, sep2);
		
		Scene scene = new Scene(vb2, 430, 330);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}