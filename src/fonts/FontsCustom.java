package fonts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//http://www.fontfiles.com/
public class FontsCustom extends Application {
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Fonts");
		
		System.out.println(this.getClass().getResource("/helper/7hours.ttf").toString());
		
		Font f = Font.loadFont(this.getClass().getResource("/helper/7hours.ttf").toString(), 24);
		//Font f = Font.loadFont(new FileInputStream(new File("D:/Download/7hours.ttf")), 24);
		//Font f = Font.loadFont(this.getClass().getResource("/helper/7hours.ttf").openStream(), 24);
		
		Text t1 = new Text();
		t1.setText("7hours font 24");
		t1.setFont(f);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}