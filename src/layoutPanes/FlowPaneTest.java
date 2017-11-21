package layoutPanes;

import java.util.concurrent.ThreadLocalRandom;

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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
//FlowPane is just flow, TilePane is like FlowPane + GridPane
public class FlowPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("FlowPane");
		
		renew(stage);
	}
	
	private void renew(Stage stage) {
		FlowPane fp = new FlowPane();
		fp.setPadding(new Insets(10,10,10,10));
		fp.setHgap(8);
		fp.setVgap(8);
		
		for (int i = 0; i < 20; i++) {
			Label lbl = new Label("Lbl "+String.valueOf(i+1));
			int width = ThreadLocalRandom.current().nextInt(120);
			lbl.setPrefWidth(width < 50 ? 50 : width);
			lbl.setFont(new Font(15));
			lbl.setAlignment(Pos.CENTER);
			lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	        //TilePane.setAlignment(title, Pos.BOTTOM_RIGHT);
	        fp.getChildren().add(lbl);
	    }
		
		Button b1 = new Button("Renew ");
		b1.setOnAction( (e) -> {
			stage.close();
			renew(stage);
		});
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().add(b1);
	     
		BorderPane bp = new BorderPane();
		bp.setCenter(fp);
		bp.setBottom(vb);
		
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}