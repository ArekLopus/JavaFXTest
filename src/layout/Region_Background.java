package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//-A region may have a background that is drawn first.
public class Region_Background extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Background");
		
		Button b1 = new Button("Testing");
		Button b2 = new Button("Testing");
		
		
		Pane vb1 = new VBox(10);
		vb1.setPrefSize(200, 100);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(b1);
		
		vb1.setStyle("-fx-background-color: green; -fx-background-radius: 10; -fx-background-insets: 5;");
		
		
		Pane vb2 = new VBox(10);
		vb2.setPrefSize(200, 100);
		vb2.setPadding(new Insets(10));
		
		BackgroundFill redFill = new BackgroundFill(Color.RED, new CornerRadii(10), new Insets(5));
		Background bg = new Background(redFill);
		vb2.setBackground(bg);
		
		
		Pane vb3 = new VBox(10);
		vb3.setPrefSize(200, 100);
		vb3.setPadding(new Insets(10));
		vb3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vb3.getChildren().add(b2);
		
		Image image = new Image("/helper/Smile32.png");
		//BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, false, false);
		BackgroundImage bgImage = new BackgroundImage(image,
			BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bg3 = new Background(bgImage);
		vb3.setBackground(bg3);
		
		
		Pane vb4 = new VBox(10);
		vb4.setPrefSize(200, 100);
		vb4.setPadding(new Insets(10));
		vb4.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		vb4.setStyle("-fx-background-image: url('/helper/Smile32.png'); -fx-background-repeat: space; "
		+ "-fx-background-position: center; -fx-background-size: auto;");
		
		Pane vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb1, vb2, vb3, vb4);
		
		
		Scene scene = new Scene(vb, 450, 460);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}