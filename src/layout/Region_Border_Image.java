package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A Region can have a border, which consists of strokes, images, or both.
//-The following CSS properties define border images for a Region.
// • -fx-border-image-source	• -fx-border-image-repeat	• -fx-border-image-slice
// • -fx-border-image-width 	• -fx-border-image-insets
//-The -fx-border-image-source property is a CSS URL for the image. For multiple images, use a comma-separated list of URLs.
//-The -fx-border-image-repeat property specifies how a slice of the image will cover the corresponding part of the Region.
//You can specify the property separately for the x-axis and y-axis. Valid values:
// • no-repeat	• repeat	• round	• space
//-The no-repeat value specifies that the image slice should be scaled to fill the area without repeating it. 
//-The repeat value specifies that the image should be repeated (tiled) to fill the area.
//-The round value specifies that the image should be repeated (tiled) to fill the area using a whole number of tiles, and if necessary, scale the image to use the whole number of tiles.
//-The space value specifies that the image should be repeated (tiled) to fill the area using a whole number of tiles without scaling the image and by distributing the extra space uniformly around the tiles.
//-The -fx-border-image-slice property specifies inward offsets from the top, right, bottom, and left edges of the image to divide it into nine slices. The property can be specified as a number literal or a percentage of the side of the image. If the word fill is present in the value, the middle slice of the image is preserved and is used to fill the middle region of the border image area; otherwise, the middle slice is discarded.
//-The -fx-border-image-width property specifies the inward offsets from four sides of the border image area to divide the border image area into nine regions. Note that we divide the border image area into nine regions, not the Region. The property can be specified as a number literal or a percentage of the side of the border image area.
//-The -fx-border-image-insets property specifies the distance between the edges of the Region and the edges of the border image area on four sides. A positive inset is measured from the edge of the Region toward its center. A negative inset is measured outward from the edge of the Region.

//-The BorderImage class, which is immutable, represents a border image in a Border. 
//-All properties for the border image are specified in the constructor:
//	BorderImage(Image image, BorderWidths widths, Insets insets, BorderWidths slices, boolean filled, 
//		    BorderRepeat repeatX, BorderRepeat repeatY)
//-The BorderRepeat enum contains STRETCH, REPEAT, SPACE, and ROUND constants that are used to indicate how the image slices are repeated in the x and y directions to fill the regions of the border image area.
public class Region_Border_Image extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Image Border");
		
		Button b1 = new Button("Testing");	Button b2 = new Button("Testing");	Button b3 = new Button("Testing");
		
		Pane vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().add(b1);
		vb1.setStyle("-fx-border-image-source: url('/helper/Smile32.png') ; -fx-border-image-repeat: round; -fx-border-image-slice: 8;"
		              + " -fx-border-image-width: 20; -fx-border-image-insets: 10;"
		              + " -fx-border-color: red; -fx-border-width: 1; -fx-border-style: dashed inside;");
		
		Image img = new Image("/helper/Smile32.png");
		BorderImage bi = new BorderImage(img, new BorderWidths(10), new Insets(15), BorderWidths.DEFAULT, true, BorderRepeat.REPEAT, BorderRepeat.REPEAT);
		
		BorderWidths regionWidths = new BorderWidths(9);
		BorderWidths sliceWidth = new BorderWidths(9);
		boolean filled = true;
		BorderRepeat repeatX = BorderRepeat.STRETCH;
		BorderRepeat repeatY = BorderRepeat.STRETCH;
		BorderImage borderImage = new BorderImage(new Image("/helper/Smile32.png"), regionWidths,
			new Insets(10), sliceWidth, filled, repeatX, repeatY);
		
		Pane vb2 = new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.setBorder(new Border(bi));
		vb2.getChildren().add(b2);
		vb2.setBorder(new Border(borderImage));
		
		BorderWidths regionWidths2 = new BorderWidths(20);
		BorderWidths sliceWidth2 = new BorderWidths(9);
		boolean filled2 = false;
		BorderRepeat repeatX2 = BorderRepeat.SPACE;
		BorderRepeat repeatY2 = BorderRepeat.SPACE;
		BorderImage borderImage2 = new BorderImage(new Image("/helper/Smile32.png"), regionWidths2,
			new Insets(10), sliceWidth2, filled2, repeatX2, repeatY2);
		
		Pane vb3 = new VBox(10);
		vb3.setPadding(new Insets(10));
		vb3.setBorder(new Border(bi));
		vb3.getChildren().add(b3);
		vb3.setBorder(new Border(borderImage2));
		
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb1, vb2, vb3);
		
		
		Scene scene = new Scene(vb, 500, 330);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}