package controls;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewManipulateDOM extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		WebView wv = new WebView();
	    WebEngine we = wv.getEngine();
	    we.loadContent("<h3 id='h3'>This is a HTML content</h3>");
	    
	    
	    Button b1 = new Button("Change HTML");
	    b1.setOnAction( e -> {
	    	Document document = we.getDocument();
	    	Element el = document.getElementById("h3");
	    	System.out.println(el.getTagName());
	    	el.setTextContent("We can manipulate DOM!");
	    });
	    

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(wv, b1);
		
		Scene scene = new Scene(vb, 300, 160);
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
