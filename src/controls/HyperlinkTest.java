package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// A Hyperlink behaves just like a Button. 
//When a hyperlink is pressed and released a ActionEvent is sent, and your application can perform some action based on this event. 
public class HyperlinkTest extends Application {
 
	private WebView wv = new WebView();
    private WebEngine we = wv.getEngine();

    @Override
    public void start(Stage stage) {
    	stage.setTitle("Hyperlink");
    	
        Hyperlink hl1 = new Hyperlink("Go to Java APIs");
        Hyperlink hl2 = new Hyperlink("Hyperlink extends Labled so you can add an image - Click to load Java APIs");
        hl2.setGraphic(new ImageView ("/helper/Smile48.png"));
        hl2.setFont(Font.font("Arial", 15));
          
        hl1.setOnAction( e -> {
        	getHostServices().showDocument("http://www.oracle.com/technetwork/java/api-141528.html");
        });

        hl2.setOnAction( e -> {
        	System.out.println("Link was clicked");
            we.load("http://www.oracle.com/technetwork/java/api-141528.html");
        });
 
        Button b1 = new Button("Visited");
        b1.setOnAction( e -> {
        	hl1.setVisited( hl1.isVisited() ? false : true );
        });
        Button b2 = new Button("Underline");
        b2.setOnAction( e -> {
        	hl1.setUnderline( hl1.isUnderline() ? false : true  );
        });
        
        HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(hl1, b1, b2);
        
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(hb, wv, hl2);
        
        Scene scene = new Scene(vb, 1100, 800);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}