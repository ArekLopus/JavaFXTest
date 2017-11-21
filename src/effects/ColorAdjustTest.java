package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-ColorAdjust effect adjusts the hue, saturation, brightness, and contrast of pixels by the specified delta amount.
// Typically, the effect is used on an ImageView node to adjust the color of an image.
public class ColorAdjustTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("ColorAdjust");
		
		ColorAdjust ca = new ColorAdjust();
		
		Rectangle r1 = new Rectangle(100, 100);
		r1.setEffect(ca);
		
		ImageView iv = new ImageView("/helper/Smile128.png");
		iv.setEffect(ca);
		
		Slider hueSl = new Slider(-1, 1, 0);
		hueSl.setShowTickLabels(true);
		ca.hueProperty().bind(hueSl.valueProperty());
		
		Slider saturationSl = new Slider(-1, 1, 0);
		saturationSl.setShowTickLabels(true);
		ca.saturationProperty().bind(saturationSl.valueProperty());
		
		Slider brightnessSl = new Slider(-1, 1, 0);
		brightnessSl.setShowTickLabels(true);
		ca.brightnessProperty().bind(brightnessSl.valueProperty());
		
		Slider contrastSl = new Slider(-1, 1, 0);
		contrastSl.setShowTickLabels(true);
		ca.contrastProperty().bind(contrastSl.valueProperty());
		
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Hue:"), hueSl);
		gp.addRow(1, new Label("Saturation:"), saturationSl);
		gp.addRow(3, new Label("Brightness:"), brightnessSl);
		gp.addRow(4, new Label("Contrast:"), contrastSl);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(iv, gp);
		
		Scene scene = new Scene(vb1, 400, 430);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}