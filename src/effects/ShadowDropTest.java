package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShadowDropTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("DropShadow effect");
		
		DropShadow ds = new DropShadow();
		
		Rectangle rect = new Rectangle(100, 50, Color.GRAY);
		
		rect.setEffect(ds);
		
		Slider offsetXSl = new Slider(-100, 100, 10);
		ds.offsetXProperty().bind(offsetXSl.valueProperty());
		Slider offsetYSl = new Slider(-100, 100, 10);
		ds.offsetYProperty().bind(offsetYSl.valueProperty());
		
		Slider radiusSl = new Slider(0, 127, 10);
		ds.radiusProperty().bind(radiusSl.valueProperty());
		
		Slider spreadSl = new Slider(0.0, 1.0, 0);
		ds.spreadProperty().bind(spreadSl.valueProperty());
		
		ColorPicker cp = new ColorPicker(Color.BLACK);
		ds.colorProperty().bind(cp.valueProperty());
		
		ComboBox<BlurType> cb = new ComboBox<>();
		cb.getItems().addAll(BlurType.ONE_PASS_BOX, BlurType.TWO_PASS_BOX, BlurType.THREE_PASS_BOX, BlurType.GAUSSIAN);
		cb.setValue(ds.getBlurType());
		ds.blurTypeProperty().bind(cb.valueProperty());
		
		HBox vb1 = new HBox(10);
		vb1.setPadding(new Insets(50, 0, 50, 150));
		vb1.getChildren().addAll(rect);
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("OffsetX:"), offsetXSl, new Label("OffsetY:"), offsetYSl);
		gp.addRow(1, new Label("Radius:"), radiusSl, new Label("Spread:"), spreadSl);
		gp.addRow(2, new Label("Color:"), cp, new Label("Blur Type:"), cb);
		
		VBox vb2 = new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.getChildren().addAll(vb1, gp);
		
		Scene scene = new Scene(vb2, 430, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}