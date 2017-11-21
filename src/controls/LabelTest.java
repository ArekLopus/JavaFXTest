package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class LabelTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Labels");
		
		Border brd = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		Insets in = new Insets(4,4,4,4);
		
		Label l1 = new Label("Label");
		l1.setPadding(in);
		l1.setBorder(brd);
		
		Label l2 = new Label("Label with CSS");
		l2.setStyle("-fx-background-color: yellow; -fx-border-color: black; -fx-font-size: 2em; -fx-text-fill: red;");
		l2.setPadding(in);
		
		Label l3 = new Label("Smile :)");
		l3.setBorder(brd);
		l3.setPadding(in);
		l3.setPrefWidth(150);
		l3.setWrapText(true);
		l3.setText("This is a very long text that we want to wrap");
		
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		
		Label l4 = new Label();
		l4.setBorder(brd);
		l4.setPadding(in);
		l4.setMnemonicParsing(true);
		l4.setText("_Mnemonic for TF1 (ALT + m)");
		l4.setLabelFor(tf1);
		
		Label l5 = new Label();
		l5.setBorder(brd);
		l5.setPadding(in);
		l5.setMnemonicParsing(true);
		l5.setText("M_nemonic for TF2 (ALT + n)");
		l5.setLabelFor(tf2);
		
		Label l6 = new Label("Label with image");
		l6.setBorder(brd);
		l6.setPadding(in);
		ImageView iv = new ImageView("/helper/Smile64.png");
		l6.setGraphic(iv);
		
		Label l7 = new Label("Rotated");
		l7.setBorder(brd);
		l7.setPadding(in);
		l7.setRotate(90);
		l7.setTranslateY(10);
		
		Label l8 = new Label("Scale Effect");
		l8.setBorder(brd);
		l8.setPadding(in);
		l8.setTranslateX(20);
		l8.setTranslateY(30);
		l8.setOnMouseEntered( e -> {
			l8.setScaleX(1.5);
	        l8.setScaleY(1.5);
		}); 
		l8.setOnMouseExited( e -> {
			l8.setScaleX(1);
	        l8.setScaleY(1);
		}); 
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l1, l2, l3, l4, tf1, l5, tf2, l6, l7, l8);
		
		Scene scene = new Scene(vb, 300, 550);
		
		
		
		
//		EventHandler<ActionEvent> ev = e -> {
//			tf.setText("Button pressed -> "+((Button)e.getSource()).getText());
//		}; 
//		b2.setOnAction(ev);

		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
