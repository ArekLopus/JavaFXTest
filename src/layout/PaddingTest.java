package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PaddingTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello");
		
		CheckBox cb1 = new CheckBox("cb1");
		cb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		CheckBox cb2 = new CheckBox("cb2");
		cb2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		VBox vb = new VBox();
		vb.setLayoutX(10);
		vb.setLayoutY(10);
		vb.setSpacing(10);
		
		vb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		vb.setPadding(new Insets(10, 10, 10, 10));  //Top - Right - Bottom - Left
		
		vb.getChildren().addAll(cb1,cb2);
		
		Scene scene = new Scene(vb, 300, 300);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}
