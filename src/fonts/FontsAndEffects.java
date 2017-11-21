package fonts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//http://docs.oracle.com/javafx/2/text/jfxpub-text.htm
public class FontsAndEffects extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Fonts and Effects");
		
		Text t1 = new Text("Testing Effects");
		t1.setFont(Font.font(100));
		
		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.rgb(254, 235, 66, 0.3));
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		ds.setRadius(5);
		ds.setSpread(0.2);

		blend.setBottomInput(ds);

		DropShadow ds1 = new DropShadow();
		ds1.setColor(Color.web("#f13a00"));
		ds1.setRadius(20);
		ds1.setSpread(0.2);

		Blend blend2 = new Blend();
		blend2.setMode(BlendMode.MULTIPLY);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.web("#feeb42"));
		is.setRadius(9);
		is.setChoke(0.8);
		blend2.setBottomInput(is);

		InnerShadow is1 = new InnerShadow();
		is1.setColor(Color.web("#f13a00"));
		is1.setRadius(5);
		is1.setChoke(0.4);
		blend2.setTopInput(is1);

		Blend blend1 = new Blend();
		blend1.setMode(BlendMode.MULTIPLY);
		blend1.setBottomInput(ds1);
		blend1.setTopInput(blend2);

		blend.setTopInput(blend1);

		t1.setEffect(blend);		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t1);
		
		Scene scene = new Scene(vb1, 680, 250);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}