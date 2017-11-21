package controls;

import helper.Helper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html
public class TextAreaTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TextArea");
		
		TextArea ta1 = new TextArea(Helper.TEXT_LOREM);
		
		CheckBox cb1 = new CheckBox("Wrap text");
		cb1.selectedProperty().addListener( (ob, ov, nv) ->{
			if(nv) {
				ta1.setWrapText(true);
			} else {
				ta1.setWrapText(false);
			}
		});
		
		
		Button b1 = new Button("Append text");
		b1.setOnAction( e ->{
			ta1.appendText("\nAppended text");
			System.out.println("getParagraphs().size() -> "+ta1.getParagraphs().size());
		});
		
		
		Button b2 = new Button("Select range");
		b2.setOnAction( e ->{
			ta1.selectRange(0, 11);
		});
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(ta1, cb1, b1, b2);
		
		Scene scene = new Scene(vb, 500, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
