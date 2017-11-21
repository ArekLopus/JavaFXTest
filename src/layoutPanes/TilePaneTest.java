package layoutPanes;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/TilePane.html
//A horizontal tilepane (the default) will tile nodes in rows, wrapping at the tilepane's width.
//A vertical tilepane will tile nodes in columns, wrapping at the tilepane's height. 
//TilePane is like FlowPane + GridPane, FlowPane is just flow. 
public class TilePaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TilePane");
		
		TilePane tilepane = new TilePane();
		tilepane.setPadding(new Insets(10,10,10,10));
		tilepane.setHgap(8);
		tilepane.setVgap(8);
		
		for (int i = 0; i < 20; i++) {
			Label lbl = new Label("Lbl "+String.valueOf(i+1));
			int width = ThreadLocalRandom.current().nextInt(120);
			lbl.setPrefWidth(width < 50 ? 50 : width);
			lbl.setFont(new Font(15));
			lbl.setAlignment(Pos.CENTER);
			lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	        //TilePane.setAlignment(title, Pos.BOTTOM_RIGHT);
	        tilepane.getChildren().add(lbl);
	    }
		
		
		Scene scene = new Scene(tilepane);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}