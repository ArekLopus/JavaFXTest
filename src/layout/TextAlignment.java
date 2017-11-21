package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 
public class TextAlignment extends Application {
 
	
	private TextField tf = new TextField("java.com");
	private Label l1 =  new Label("Loading status: ");
	private Button b1 = new Button("Click to download");
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("ProgressBar");
    	
        l1.setPrefWidth(160);
        l1.setPrefHeight(25);
        //l1.setAlignment(Pos.CENTER_LEFT);
        l1.setAlignment(Pos.CENTER_RIGHT);

        
        HBox hb = new HBox();
        hb.setPrefHeight(100);
		hb.setSpacing(10);
		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(tf, l1, b1);
 
        Scene scene = new Scene(hb, 1100, 700);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}