package fonts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//-The font family is a string value that can be the actual font family available on the system,
// fe, "Arial", "Times", or generic family names, fe, "serif", "sans-serif", "monospace".
//-The font size can be specified in units such as px, em, pt, in, cm. If the unit for the font size is omitted, px (pixels) is assumed.
//-The font style can be normal, italic, or oblique.
//-The font weight can be specified as normal, bold, bolder, lighter, 100, 200, 300, 400, 500, 600, 700, 800, or 900.
public class FontsCss extends Application {

//	Font Properties
//	Most classes that use text will support the following font properties.
//	In some cases a similar set of properties will be supported but with a different prefix instead of "-fx-font".
//	CSS Property 	Values 			Default 	Comments
//	-fx-font 		<font> 			inherit 	shorthand property for font-size, font-family, font-weight and font-style
//	-fx-font-family <font-family> 	inherit 	 
//	-fx-font-size 	<font-size> 	inherit 	 
//	-fx-font-style 	<font-style> 	inherit 	 
//	-fx-font-weight <font-weight> 	inherit
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Fonts CSS");
		
		Text t = new Text("Using CSS id");
		t.setId("my-id");
		
		Text t1 = new Text("Using CSS class");
		t1.setFont(Font.font(null, FontWeight.BOLD, 50));
		t1.getStyleClass().add("my-font");
		
		Text t2 = new Text("Using CSS setStyle");
		t2.setStyle("-fx-font: bold 36 Arial; -fx-strikethrough: true; -fx-fill: radial-gradient(radius 120%, red, yellow, black);");

		Text t3 = new Text("Using CSS setStyle");
		t3.setStyle("-fx-font-size:36; -fx-font-style: italic; -fx-font-weight: bold; -fx-font-family: 'Times New Roman';");
		
		//The same using -fx-font shorthand property
		Text t4 = new Text("Using CSS setStyle");
		t4.setStyle("-fx-font: bold italic 36 'Times New Roman';");
		
		Text t5 = new Text ("Stroke and Fill");
		t5.setId("fancytext");
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t, t1, t2, t3, t4, t5);
		
		Scene scene = new Scene(vb1, 450, 400);
		scene.getStylesheets().add("/helper/fonts.css");
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}