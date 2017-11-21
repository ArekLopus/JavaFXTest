package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Tooltip.html
//Because the Tooltip class is an extension of the Labeled class, you can add not only a text caption, but a graphical icon as well.
public class TooltipTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Tooltip");
		
		Label l1 = new Label("node.setTooltip(new Tooltip(\"\"))");
		l1.setPadding(new Insets(4,4,4,4));
		l1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		l1.setPrefWidth(Double.MAX_VALUE);
		
		l1.setTooltip(new Tooltip("This is a tooltip - node.setTooltip(new Tooltip(\"\"))"));
		
		
		TextField tf1 = new TextField("Tooltip.install(node, new Tooltip(\"\"))"); 
		Tooltip.install(tf1, new Tooltip("This is another way of setting a tooltip - Tooltip.install(node, new Tooltip(\"\"))"));
		
		//Uninstall tooltip
		//Tooltip.uninstall(node, tooltip);
		
		
		TextField tf2 = new TextField("HTML Tooltip"); 

		WebView wv = new WebView();
	    WebEngine we = wv.getEngine();
	    we.loadContent("<h3>This is a HTML tooltip</h3>");
	    
	    Tooltip  tooltip = new Tooltip();
	    tooltip.setPrefSize(250, 100);
	    tooltip.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    tooltip.setGraphic(wv);
	    Tooltip.install(tf2, tooltip);
		
	    
	    TextField tf3 = new TextField("Graphics Tooltip");
	    Label l2 = new Label("This is a Label tooltip");
	    l2.setFont(new Font(20));
		l2.setPadding(new Insets(4,4,4,4));
		l2.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
		Tooltip  tooltip2 = new Tooltip();
	    tooltip2.setPrefSize(250, 100);
	    tooltip2.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	    tooltip2.setGraphic(l2);
	    Tooltip.install(tf3, tooltip2);
		
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l1, tf1, tf2, tf3);
		
		Scene scene = new Scene(vb, 300, 160);
		l1.requestFocus();
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
