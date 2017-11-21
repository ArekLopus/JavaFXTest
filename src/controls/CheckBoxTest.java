package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("CheckBox");
		
		CheckBox cb1 = new CheckBox("cb1");
		CheckBox cb2 = new CheckBox("cb2");
		
		//Although checkboxes look similar to radio buttons, they cannot be combined into toggle groups
		//to enable the selection of many options at one time
		//ToggleGroup tg = new ToggleGroup();
		
		CheckBox cb3 = new CheckBox("CheckBox with Image");
		cb3.setContentDisplay(ContentDisplay.RIGHT);
		cb3.setGraphic(new ImageView("/helper/Smile32.png"));
		cb3.setSelected(true);
		
		CheckBox cb4 = new CheckBox("Styled CheckBox");
		cb4.setStyle(
			    "-fx-border-color: lightblue; "
			    + "-fx-font-size: 18;"
			    + "-fx-border-insets: -5; "
			    + "-fx-border-radius: 5;"
			    + "-fx-border-style: dotted;"
			    + "-fx-border-width: 2;"
			);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(cb1, cb2, cb3, cb4);
		
		Scene scene = new Scene(vb, 200, 200);
		
		stage.setScene(scene);
		stage.show();
		
		cb1.selectedProperty().bindBidirectional(cb2.selectedProperty());
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}
