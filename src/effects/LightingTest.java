package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Lighting effect, as the name suggests, simulates a light source shining on a specified node in a scene to give the node a 3D look.
//A Lighting effect uses a light source, which is an instance of the Light class, to produce the effect.
//Different types of configurable lights are available. If you do not specify a light source, the effect uses a default light source.
// • contentInput 	• surfaceScale	• bumpInput	  • diffuseConstant	  • specularConstant   • specularExponent   • light

//surfaceScale property lets you control the surface roughness. Its value ranges from 0.0 to 10.0.
// The default is 1.5. For a higher surfaceScale, the surface appears rougher, giving it a more 3D look.

//bumpInput - You can pass an Effect as an input to the Lighting effect using its bumpInput property. The opacity of the pixels in the bumpInput
//is used to obtain the height of the pixels of the lighted surface, and then the surfaceScale is applied to increase the roughness.
//If bumpInput is null, the opacity of the pixels from the node on which the effect is applied is used to generate the roughness of the surface.
//By default, a Shadow effect with a radius of 10 is used as the bumpInput. 
//You can use an ImageInput, a blur effect, or any other effect as the bumpInput for a Lighting effect.

//-Three properties of the Lighting class are used to control the size and intensity of the reflection:
// • diffuseConstant	• specularConstant	  • specularExponent

public class LightingTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Lighting");
		
		Light.Point lp = new Light.Point();
		lp.setX(200);
		lp.setY(100);
		lp.setZ(40);
		
		Light.Spot ls = new Light.Spot();
		ls.setX(400);
		ls.setY(100);
		ls.setZ(80);
		ls.setPointsAtX(50);
		ls.setPointsAtY(0);
		ls.setPointsAtZ(-50);
		ls.setSpecularExponent(20);
		 
		Light.Distant ld = new Light.Distant();
		ld.setAzimuth(-135.0);
		//ld.setElevation(30);
		
		Lighting lighting = new Lighting();
		lighting.setLight(ld);
		
		
		Text text = new Text();
		text.setText("Lighting");
		text.setFill(Color.RED);
		text.setFont(Font.font(null, FontWeight.BOLD, 100));
		text.setEffect(lighting);

		Rectangle rect = new Rectangle(420, 200);
		rect.setFill(Color.LIGHTGRAY);
		rect.setEffect(lighting);
		StackPane sp = new StackPane(rect, text);
		
		
		CheckBox bumpCB = new CheckBox("Use BumpInput");
		bumpCB.selectedProperty().addListener( (ob, o, n) -> {
			if(n) {
				lighting.setBumpInput(new Shadow());
			} else {
				lighting.setBumpInput(null);
			}
		});
		bumpCB.setSelected(true);
		
		ComboBox<String> lightCB = new ComboBox<>();
		lightCB.setValue("Distant");
		lightCB.getItems().addAll("None", "Point", "Spot", "Distant");
		lightCB.setOnAction( e -> {
			System.out.println(lightCB.getValue());
			switch (lightCB.getValue()) {
			case "None":
				lighting.setLight(null);
				break;
			case "Point":
				lighting.setLight(lp);
				break;
			case "Spot":
				lighting.setLight(ls);
				break;
			case "Distant":
				lighting.setLight(ld);
				break;
			default:
				break;
			}
		});
		
		
		Slider surfaceSl = new Slider (0, 10, 5);
		surfaceSl.setMajorTickUnit(1);
		surfaceSl.setShowTickMarks(true);
		surfaceSl.setShowTickLabels(true);
		lighting.surfaceScaleProperty().bind(surfaceSl.valueProperty());
		
		//diffuseConstant	• specularConstant	  • specularExponent
		Slider diffSl = new Slider (0, 2, 1);
		diffSl.setMajorTickUnit(1);
		diffSl.setShowTickMarks(true);
		diffSl.setShowTickLabels(true);
		lighting.diffuseConstantProperty().bind(diffSl.valueProperty());
		
		Slider specConSl = new Slider (0, 2, 0.3);
		specConSl.setMajorTickUnit(1);
		specConSl.setShowTickMarks(true);
		specConSl.setShowTickLabels(true);
		lighting.specularConstantProperty().bind(specConSl.valueProperty());
		
		Slider specExpSl = new Slider (0, 40, 20);
		specExpSl.setMajorTickUnit(5);
		specExpSl.setShowTickMarks(true);
		specExpSl.setShowTickLabels(true);
		lighting.specularExponentProperty().bind(specExpSl.valueProperty());
		
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Light:"), lightCB);
		gp.addRow(1, new Label("SurfaceScale:"), surfaceSl);
		gp.addRow(2, new Label("DiffuseConstant:"), diffSl);
		gp.addRow(3, new Label("SpecularConstant:"), specConSl);
		gp.addRow(4, new Label("SpecularExponent:"), specExpSl);

		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp, bumpCB, gp);
		
		Scene scene = new Scene(vb1, 450, 500);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}