package fonts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//
public class FontsAllAvailable extends Application {
	
	private ListView<String> lv = new ListView<>();
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Fonts");
		
		Text t1 = new Text("Example");
		t1.setFont(Font.font(20));
		
		lv.getSelectionModel().selectedItemProperty().addListener( (ob, ov, nv)->{
			System.out.println(nv);
			t1.setFont(new Font(nv, 20));
		});
		
		
		Button b1 = new Button("Print all Family names");
		b1.setOnAction( e->{
			for(String familyName: Font.getFamilies()) {
				lv.getItems().add(familyName);
			}
		});
		
		Button b2 = new Button("Print all Font names");
		b2.setOnAction( e->{
			for(String fullName: Font.getFontNames()) {
				lv.getItems().add(fullName);
			}
		});
		
		
		Button b3 = new Button("Clear");
		b3.setOnAction( e->{
			lv.getItems().clear();
		});
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(b1, b2, b3, lv, t1);
		
		Scene scene = new Scene(vb1, 450, 580);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}