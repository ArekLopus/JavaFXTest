package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
public class ButtonTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Buttons");
		
		Button b1 = new Button("Smile :)");
		//b1.setPadding(new Insets(5,5,5,5));
		
		Button b2 = new Button("Smile with CSS :)");
		b2.setStyle("-fx-background-color: yellow; -fx-border-color: black; -fx-font-size: 2em; -fx-text-fill: red;");
		
		Button b3 = new Button("Smile :)");
		b3.setPrefWidth(150);
		b3.setWrapText(true);
		b3.setText("This is a very long text that we want to wrap");
		
		Button b4 = new Button();
		b4.setMnemonicParsing(true);
		b4.setText("Mnemonic _Smile, press ALT :)");
		
		Button b5 = new Button("Smile with image :)");
		ImageView iv = new ImageView("/helper/Smile128.png");
		b5.setGraphic(iv);
		
		Button b6 = new Button("Smile with shadow :)");
		DropShadow shadow = new DropShadow();
		b6.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            b6.setEffect(shadow);
		        }
		});
		b6.setOnMouseExited( e -> {
			b6.setEffect(null);
		});
		
		
		TextField tf = new TextField("Button pressed -> ");
		tf.setEditable(false);
		tf.setFocusTraversable(false);
		tf.setTranslateY(25);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(b1, b2, b3, b4, b5, b6, tf);
		
		Scene scene = new Scene(vb, 300, 460);
		
		EventHandler<ActionEvent> ev = e -> {
			tf.setText("Button pressed -> "+((Button)e.getSource()).getText());
		}; 
		b1.setOnAction(ev);
		b2.setOnAction(ev);
		b3.setOnAction(ev);
		b4.setOnAction(ev);
		b5.setOnAction(ev);
		b6.setOnAction(ev);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
