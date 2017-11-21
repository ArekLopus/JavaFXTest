package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//TilePane is a GridPAne + Flow Pane
public class TilePaneTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TilePane");
		
		TilePane tilepane = new TilePane();
		tilepane.setPadding(new Insets(10,10,10,10));
		tilepane.setHgap(8);
		tilepane.setVgap(8);
		
		for (int i = 0; i < 20; i++) {
			Label lbl = new Label("Label "+String.valueOf(i+1));
			lbl.setFont(new Font(20));
			lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	        //TilePane.setAlignment(title, Pos.BOTTOM_RIGHT);
	        tilepane.getChildren().add(lbl);
	    }
		
		Button b1 = new Button("Different dimensions");
		b1.setOnAction( (e) -> {
			stage.setWidth(dimx[counter]);
			stage.setHeight(dimy[counter]);
			if(counter == 3) {
				counter = 0;
			} else {
				counter++;
			}
		});
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().add(b1);
	     
		BorderPane bp = new BorderPane();
		bp.setCenter(tilepane);
		bp.setBottom(vb);
		
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}
	
	private int counter = 0;
	private int[] dimx = {200, 370, 870, 450};
	private int[] dimy = {490, 310, 170, 255};
	
	public static void main(String[] args) {
		launch(args);
	}
	
}