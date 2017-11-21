package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//-fraction property specifies the faction of the input height that is visible in the reflection.
// It is measured from the bottom. Its value can be between 0.0 and 1.0.
// A value of 0.0 means no reflection. A value of 1.0 means the entire input is visible in the reflection. reflection. The default value is 0.75.
//-topOffset specifies the distance in pixels between the bottom of the input and the top of the reflection. By default, it is 0.0.
//-topOpacity and bottomOpacity properties specify the opacity of the reflection at its top and bottom extremes.
// Their values can be between 0.0 and 1.0. The default value is 0.50 for the topOpacity and 0.0 for the bottomOpacity.
public class ReflectionTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Reflection");
		
		Reflection ref = new Reflection();
		
		Text t = new Text("Reflection");
		t.setFont(Font.font(null, FontWeight.BOLD, 36));
		t.setEffect(ref);
		
		ImageView iv = new ImageView("/helper/Smile48.png");
		iv.setEffect(ref);
		
		Slider fracSl = new Slider(0, 1, 0.7);
		fracSl.setShowTickLabels(true);
		ref.fractionProperty().bind(fracSl.valueProperty());
		
		Slider topOffSl = new Slider(0, 100, 0);
		topOffSl.setShowTickLabels(true);
		ref.topOffsetProperty().bind(topOffSl.valueProperty());
		
		Slider topOpSl = new Slider(0, 1, 0.5);
		topOpSl.setShowTickLabels(true);
		ref.topOpacityProperty().bind(topOpSl.valueProperty());
		
		Slider bottOpSl = new Slider(0, 1, 0);
		bottOpSl.setShowTickLabels(true);
		ref.bottomOpacityProperty().bind(bottOpSl.valueProperty());
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Fraction:"), fracSl);
		gp.addRow(1, new Label("TopOffset:"), topOffSl);
		gp.addRow(2, new Label("TopOpacity:"), topOpSl);
		gp.addRow(3, new Label("BottomOpacity:"), bottOpSl);
		
		HBox hb2 = new HBox(10);
		hb2.setPadding(new Insets(50, 50, 150, 50));
		hb2.getChildren().addAll(t, iv);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(hb2, gp);
		
		Scene scene = new Scene(vb1, 400, 450);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}