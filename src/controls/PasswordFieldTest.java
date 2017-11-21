package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/PasswordField.html
public class PasswordFieldTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Paswordfield");
		
		PasswordField pf = new PasswordField(); 
		pf.setPromptText("Enter password");
		//pf.setText("Password123");
		
		Label l1 = new Label();
		l1.setPadding(new Insets(4,4,4,4));
		l1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		l1.setPrefWidth(Double.MAX_VALUE);
		
		l1.textProperty().bind(pf.textProperty());
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(pf, l1);
		
		Scene scene = new Scene(vb, 300, 150);
		l1.requestFocus();
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
