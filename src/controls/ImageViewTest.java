package controls;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//-The ImageView is a Node used for painting images loaded with Image class. 
//-This class allows resizing the displayed image (with or without preserving the original aspect ratio)
// and specifying a viewport into the source image for restricting the pixels displayed by this ImageView. 
public class ImageViewTest extends Application {
	
	private Button b1 = new Button("Rotate");
	private Button b2 = new Button("Scale <");
	private Button b3 = new Button("Scale >");

	@Override
    public void start(Stage stage) {
    	stage.setTitle("ImageView");
    	
    	InputStream input = this.getClass().getResourceAsStream("/helper/favorite16.png");
    	Image im1 = new Image(input);
    	
    	Image im2 = new Image("/helper/Smile64.png");
    	
    	String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Felis_catus-cat_on_snow.jpg/1920px-Felis_catus-cat_on_snow.jpg";
    	
    	Image im3 = new Image(url, true);


    	ImageView iv1 = new ImageView(im1);
    	ImageView iv2 = new ImageView(im2);
    	
    	//resizes the image to have width of 420 while preserving the ratio and using
        //higher quality filtering method; this ImageView is also cached to improve performance
    	ImageView iv3 = new ImageView(im3);
        iv3.setFitWidth(420);
        iv3.setPreserveRatio(true);
        iv3.setSmooth(true);
        iv3.setCache(true);
        iv3.fitWidthProperty().bind(stage.widthProperty().subtract(40));
        
        iv3.setOnMouseMoved( e -> {
        	b2.setText("X: "+e.getX());
        	b3.setText("Y: "+e.getY());
        });
        iv3.setOnMouseExited( e -> {
        	b2.setText("Scale <");
        	b3.setText("Scale >");
        });
        
        //defines a viewport into the source image (achieving a "zoom" effect) 
        ImageView iv4 = new ImageView();
        iv4.setImage(im3);
        Rectangle2D viewportRect = new Rectangle2D(430, 240, 250, 250);
        iv4.setViewport(viewportRect);
        
        
    	
    	b1.setOnAction( e -> {
    		iv2.setRotate(iv2.getRotate()+45);
    	} );
    	
    	b2.setOnAction( e -> {
    		iv4.setScaleX(iv4.getScaleX() * 0.9);
    		iv4.setScaleY(iv4.getScaleY() * 0.9);
    	} );

    	b3.setOnAction( e -> {
    		iv4.setScaleX(iv4.getScaleX() * 1.1);
    		iv4.setScaleY(iv4.getScaleY() * 1.1);
    	} );
    	
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(iv1, iv2, iv3, iv4, b1, b2, b3);
        
        Scene scene = new Scene(vb, 440, 770);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}