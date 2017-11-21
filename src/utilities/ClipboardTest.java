package utilities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/Clipboard.html
//-Clipboard - Represents an operating system clipboard, on which data may be placed during, for example, cut, copy, and paste operations.
//-ClipboardContent - Data container for Clipboard data. It can hold multiple data in several data formats (HashMap internally).
// The ClipboardContent class is simply a map with convenience methods for dealing with common data types added to a clipboard. 
//-Content types are defined by the DataFormat objects. The DataFormat class defines an immutable object,
// and there are a number of static final fields for common DataFormat types. Of course application specific DataFormat types 

//-The Clipboard operates on the concept of having a single conceptual item on the clipboard at any one time -- though it may be placed on the clipboard in different formats.
// Fe, the user might select text in an HTML editor and press the ctrl+c to copy it. In this case, the same text might be available on the clipboard both as HTML and plain text.
public class ClipboardTest extends Application {
	
	private Clipboard cb = Clipboard.getSystemClipboard();
	private ClipboardContent content = new ClipboardContent();
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Clipboard");
    	
    	TextField tf = new TextField();
    	HTMLEditor he = new HTMLEditor();
    	
    	//Every time setContent is called, any previous data on the clipboard is cleared and replaced with this new content. 
    	cb.setContent(content);
    	
    	Button b1 = new Button("Set Strings in Clipboard");
    	b1.setOnAction( e -> {
    		content.putString("String from Clipboard");
    		content.putHtml("<b>Some HTML text</b>");
    		cb.setContent(content);
    		System.out.println("Clipboard used");
    		
    		//tf.setText(cb.getString());
    		//he.setHtmlText(cb.getHtml());
    		tf.setText((String) cb.getContent(DataFormat.PLAIN_TEXT));
    		he.setHtmlText((String) cb.getContent(DataFormat.HTML));
    	});
    	

    	VBox root = new VBox(5);
    	root.setPadding(new Insets(5));
    	root.getChildren().addAll(b1, tf, he);
    	
    	Scene scene = new Scene(root, 300, 300);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}