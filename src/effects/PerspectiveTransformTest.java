package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//A PerspectiveTransform effect gives a 2D node a 3D look by mapping the corners to different locations.
//The straight lines in the original nodes remain straight. However, parallel lines in the original nodes may not necessarily remain parallel.
public class PerspectiveTransformTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("PerspectiveTransform");
		
		PerspectiveTransform pt = new PerspectiveTransform();
		
		Rectangle rect1 = new Rectangle(240, 60, Color.BLUE);
		
		Text t1 = new Text();
		t1.setX(20);
		t1.setY(45);
		t1.setText("Perspective");
		t1.setFill(Color.YELLOW);
		t1.setFont(Font.font(null, FontWeight.BOLD, 36));
		
		Group group1 = new Group(rect1, t1);
		group1.setEffect(pt);
		group1.setCache(true);
		
		Slider ulxSl = new Slider(0, 100, 0);
		ulxSl.setShowTickLabels(true);
		pt.ulxProperty().bind(ulxSl.valueProperty());
		
		Slider ulySl = new Slider(0, 100, 0);
		ulySl.setShowTickLabels(true);
		pt.ulyProperty().bind(ulySl.valueProperty());
		
		Slider urxSl = new Slider(0, 1000, 250);
		urxSl.setShowTickLabels(true);
		pt.urxProperty().bind(urxSl.valueProperty());
		
		Slider urySl = new Slider(0, 100, 20);
		urySl.setShowTickLabels(true);
		pt.uryProperty().bind(urySl.valueProperty());
		
		Slider llxSl = new Slider(0, 100, 20);
		llxSl.setShowTickLabels(true);
		pt.llxProperty().bind(llxSl.valueProperty());
		
		Slider llySl = new Slider(0, 100, 60);
		llySl.setShowTickLabels(true);
		pt.llyProperty().bind(llySl.valueProperty());
		
		Slider lrxSl = new Slider(0, 500, 300);
		lrxSl.setShowTickLabels(true);
		pt.lrxProperty().bind(lrxSl.valueProperty());
		
		Slider lrySl = new Slider(0, 200, 60);
		lrySl.setShowTickLabels(true);
		pt.lryProperty().bind(lrySl.valueProperty());
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Upper Left X:"), ulxSl);
		gp.addRow(1, new Label("Upper Left Y:"), ulySl);
		gp.addRow(2, new Label("Lower Left X:"), llxSl);
		gp.addRow(3, new Label("Lower Left Y:"), llySl);
		gp.addRow(4, new Label("Upper Right X:"), urxSl);
		gp.addRow(5, new Label("Upper Right Y:"), urySl);
		gp.addRow(6, new Label("Lower Right X:"), lrxSl);
		gp.addRow(7, new Label("Lower Right Y:"), lrySl);
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		HBox hb = new HBox();
		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb.getChildren().addAll(group1);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(hb, gp);
		
		Scene scene = new Scene(vb1, 400, 420);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}