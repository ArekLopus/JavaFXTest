package controls;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollBar.html
public class ScrollBarTest extends Application {
	
	final ScrollBar sc = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    DropShadow shadow = new DropShadow();
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("ScrollBar");
    	
    	shadow.setColor(Color.YELLOW);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
 
        vb.setLayoutX(5);
        vb.setSpacing(10);
        
        for (int i = 0; i < 5; i++) {
            Rectangle rec = new Rectangle();
            rec.setWidth(100);
            rec.setHeight(100);
            rec.setFill(Color.RED);
            rec.setEffect(shadow);
            vb.getChildren().add(rec);
        }
        
        
    	Group root = new Group();
        Scene scene = new Scene(root, 180, 180);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        
        root.getChildren().addAll(vb, sc);
        
        
        sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(180);
        sc.setMax(360);
        
        sc.valueProperty().addListener( (ov, oval, nval) -> {
        	vb.setLayoutY(-nval.doubleValue());
        });
        
        
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
