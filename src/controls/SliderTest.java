package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Slider.html
//ColorPicker control allows to select a color from either a standard palette OR define their own custom color. 
public class SliderTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Slider");
		
		//Min - Max - Default 
		Slider sl1 = new Slider(0, 100, 50);
		
		sl1.setShowTickMarks(true);
		sl1.setShowTickLabels(true);
		
		sl1.setMajorTickUnit(2);
		//sl1.setMinorTickCount(2);
		
		sl1.setBlockIncrement(1);
		
		sl1.setSnapToTicks(true);
		
		Label l1 = new Label();
		l1.textProperty().bind(sl1.valueProperty().asString());
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(sl1, l1);
		
		Scene scene = new Scene(vb, 500, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
