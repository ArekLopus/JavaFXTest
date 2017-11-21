package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/HTMLEditor.html
//A control that allows for users to edit text, and apply styling to this text.
//The underlying data model is HTML, although this is not shown visually to the end-user.
public class HTMLEditorTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("HTMLEditor");
		
		String text = "<h3>Title</h3>"
				+ "<p><font color='#ff0000'>This is a paragraph.</font></p>"
				+ "<p>This is a second paragraph.</p>";
		
		HTMLEditor he = new HTMLEditor();
		he.setPrefHeight(250);
		he.setHtmlText(text);
		
		TextArea ta = new TextArea();
		ta.setPrefHeight(250);
		ta.setWrapText(true);
		
		WebView wv = new WebView();
		wv.setDisable(true);
		wv.setPrefHeight(250);
	    WebEngine we = wv.getEngine();
		
		Button b1 = new Button("Show HTML code");
		b1.setOnAction( e -> {
			ta.setText(he.getHtmlText());
			we.loadContent(he.getHtmlText());
		});
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(he, ta, wv, b1);
		
		Scene scene = new Scene(vb, 600, 800);
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
