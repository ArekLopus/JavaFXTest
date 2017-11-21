package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Separator.html
//-A horizontal or vertical separator line. The visual appearance of this separator can be controlled via CSS.
//-A horizontal separator occupies the full horizontal space allocated to it (less padding),
// and a vertical separator occupies the full vertical space allocated to it (less padding).
public class SeparatorTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Separator");
		
		Font font = new Font(20);
		
		Text t1 = new Text("Text 1");
		t1.setFont(font);
		
		Separator s0 = new Separator();
		Separator s1 = new Separator();
		
		Text t2 = new Text("Text 2");
		t2.setFont(font);
		Text t3 = new Text("Text 3");
		t3.setFont(font);
		Text t4 = new Text("Text 4");
		t4.setFont(font);
		
		Separator s2 = new Separator();
		s2.setOrientation(Orientation.VERTICAL);
		s2.setValignment(VPos.CENTER);
		Separator s3 = new Separator();
		s3.setOrientation(Orientation.VERTICAL);
		
		HBox hb = new HBox();
		//hb.setPadding(new Insets(10));
	    //hb.setSpacing(10);
		hb.getChildren().addAll(t2, s2, t3, s3, t4);
				
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(t1, s0, hb, s1);
		
		Scene scene = new Scene(vb, 320, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
