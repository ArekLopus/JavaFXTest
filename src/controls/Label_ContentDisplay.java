package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
public class Label_ContentDisplay extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Labels");
		
		Border brd = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		Insets in = new Insets(4,4,4,4);
		Image img = new Image("/helper/Smile32.png");
		
		
		
		Label l1 = new Label("Without ContentDisplay = ContentDisplay.LEFT");
		l1.setBorder(brd);
		l1.setPadding(in);
		l1.setGraphic(new ImageView(img));

		Label l2 = new Label("ContentDisplay.BOTTOM");
		l2.setBorder(brd);
		l2.setPadding(in);
		l2.setGraphic(new ImageView(img));
		l2.setContentDisplay(ContentDisplay.BOTTOM);
		
		Label l3 = new Label("ContentDisplay.CENTER");
		l3.setBorder(brd);
		l3.setPadding(in);
		l3.setGraphic(new ImageView(img));
		l3.setContentDisplay(ContentDisplay.CENTER);
		
		Label l4 = new Label("ContentDisplay.GRAPHIC_ONLY");
		l4.setBorder(brd);
		l4.setPadding(in);
		l4.setGraphic(new ImageView(img));
		l4.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		
		Label l5 = new Label("ContentDisplay.LEFT");
		l5.setBorder(brd);
		l5.setPadding(in);
		l5.setGraphic(new ImageView(img));
		l5.setContentDisplay(ContentDisplay.LEFT);
		
		Label l6 = new Label("ContentDisplay.RIGHT");
		l6.setBorder(brd);
		l6.setPadding(in);
		l6.setGraphic(new ImageView(img));
		l6.setContentDisplay(ContentDisplay.RIGHT);
		
		Label l7 = new Label("ContentDisplay.TEXT_ONLY");
		l7.setBorder(brd);
		l7.setPadding(in);
		l7.setGraphic(new ImageView(img));
		l7.setContentDisplay(ContentDisplay.TEXT_ONLY);
		
		Label l8 = new Label("ContentDisplay.TOP");
		l8.setBorder(brd);
		l8.setPadding(in);
		l8.setGraphic(new ImageView(img));
		l8.setContentDisplay(ContentDisplay.TOP);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8);
		
		Scene scene = new Scene(vb, 320, 500);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
