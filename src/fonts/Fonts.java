package fonts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//-An instance of the Font class represents a font. The Font class provides two constructors:
// • Font(double size)	• Font(String name, double size)
//-The first constructor creates a Font object of the specified size that belongs to the “System” font family.
//-The second one creates a Font object of the specified full name of the font and the specified size. The size is specified in points.
//-If the full font name is not found, the default “System” font will be created.
//-It is hard to remember or know the full names for all variants of a font. To address this, the Font class provides
//factory methods to create fonts using a font family name, styles, and size:
// • font(double size)   • font(String family)  • font(String family, double size)  • font(String family, FontPosture posture, double size)
// • font(String family, FontWeight weight, double size)  • font(String family, FontWeight weight, FontPosture posture, double size)
//-The font() methods let you specify the family name, font weight, font posture, and font size. If only the family name is provided,
// the default font size is used, which depends on the platform and the desktop setting of the user.
//-The font weight specifies how bold the font is. Its value is one of the constants of the FontWeight enum:
// THIN, EXTRA_LIGHT, LIGHT, NORMAL, MEDIUM, SEMI_BOLD, BOLD, EXTRA_BOLD, BLACK.
// The constant THIN represents the thinnest font and the constant BLOCK the thickest font.
//-The posture of a font specifies whether it is italicized. It is represented by the FontPosture enum: REGULAR and ITALIC.
public class Fonts extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Fonts");
		
//		Font f1 = new Font("Arial", 10);
//		Font f2 = new Font("Arial Italic", 10);
//		Font f3 = new Font("Arial Bold Italic", 10);
//		Font f4 = new Font("Arial Narrow Bold", 30);
		
		//Or
		Font f11 = Font.font("Arial", 24);
		Font f22 = Font.font("Arial", FontWeight.BOLD, 24);
		Font f33 = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 24);
		Font f44 = Font.font("Arial", FontWeight.THIN, 24);
		Font f55 = Font.font("Arial", FontWeight.BLACK, 24);
		
		
		
		Text t1 = new Text();
		t1.setText("Arial font 24");
		t1.setFont(f11);
		
		
		Text t2 = new Text();
		t2.setText("Arial font Bold 24");
		t2.setFont(f22);
		
		Text t3 = new Text();
		t3.setText("Arial font Bold Italic 24");
		t3.setFont(f33);
		
		Text t4 = new Text();
		t4.setText("Arial font Thin 24");
		t4.setFont(f44);
		
		Text t5 = new Text();
		t5.setText("Arial font Black 24");
		t5.setFont(f55);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1, t2, t3, t4, t5);
		
		Scene scene = new Scene(vb1, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}