package controls;

import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class ImageTest extends Application {
	
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Image");
    	
    	//-The Image class represents graphical images and is used for loading images from a specified URL. 
    	//-Supported image formats are:  BMP, GIF, JPEG, PNG
    	//-Images can be resized as they are loaded (for example to reduce the amount of memory consumed by the image).
    	// The application can specify the quality of filtering used when scaling, and whether or not to preserve the original image's aspect ratio.
    	//-All URLs supported by URL can be passed to the constructor. If the passed string is not a valid URL, 
    	// but a path instead, the Image is searched on the classpath in that case.
    	//-Use ImageView for displaying images loaded with this class. 
    	//-The same Image instance can be displayed by multiple ImageViews.
    	
    	//Image(InputStream inputStream)
    	//Image(InputStream is, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
    	//Image(String url)
    	//Image(String url, boolean backgroundLoading)
    	//Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
    	//Image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth, boolean backgroundLoading)
    	
    	InputStream input = this.getClass().getResourceAsStream("/helper/favorite16.png");
    	Image im1 = new Image(input);
    	
    	Image im2 = new Image("/helper/Smile64.png");
    	
    	//String url = "http://www.outback-australia-travel-secrets.com/image-files/australian-wildlife-pictures-4.jpg.pagespeed.ce.CSCw1Zc-hU.jpg";
    	//String url = "http://cdn.newsapi.com.au/image/v1/90beb5d6afa8b379cfd7724e26cfcb8a";
    	String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Felis_catus-cat_on_snow.jpg/1920px-Felis_catus-cat_on_snow.jpg";
    	
    	Image im3 = new Image(url, 420, 1300, true, true);	//preserveRatio and backgroundLoading
    	
    	ImageView iv1 = new ImageView(im1);
    	ImageView iv2 = new ImageView(im2);
    	ImageView iv3 = new ImageView(im3);
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(iv1, iv2, iv3);
        
        Scene scene = new Scene(vb, 440, 400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}