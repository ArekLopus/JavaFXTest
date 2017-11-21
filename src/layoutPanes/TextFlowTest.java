package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/TextFlow.html
//TextFlow is special layout designed to lay out rich text. It can be used to layout several Text nodes in a single text flow. 
//It uses the text and the font of each Text node inside of it plus it own width and text alignment to determine the location for each child. 
//-A TextFlow also lets you embed nodes other than Text nodes.
public class TextFlowTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TextFlow");
		
		Text text1 = new Text("Big italic red text");
	    text1.setFill(Color.RED);
	    text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
	    Text text2 = new Text(" little bold blue text");
	    text2.setFill(Color.BLUE);
	    text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
	    
	    TextFlow tf1 = new TextFlow(text1, text2);
		
	    TextFlow tf2 = new TextFlow(new Text("This is a text node "), new RadioButton("Radio Button"));

	    
	    VBox vb = new VBox(10, tf1, tf2);
	    vb.setPadding(new Insets(10));
	    
		Scene scene = new Scene(vb);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}