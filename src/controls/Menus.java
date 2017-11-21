package controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.binding.When;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/MenuBar.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Menu.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/MenuItem.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/CheckMenuItem.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/RadioMenuItem.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/CustomMenuItem.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SeparatorMenuItem.html
public class Menus extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Menus");
		
		//Main menu
		MenuBar mb = new MenuBar();
		
		Menu m1 = new Menu("Menu");
		m1.setGraphic(new ImageView("/helper/favorite16.png"));
		Menu m2 = new Menu("RadioMenuItems");
		Menu m3 = new Menu("CheckMenuItems");
		Menu m4 = new Menu("CustomMenuItems");
		
		mb.getMenus().addAll(m1, m2, m3, m4);
		
		Menu sm = new Menu("Parent");
		MenuItem smi1 = new MenuItem("Child 1");
		MenuItem smi2 = new MenuItem("Child 2");
		sm.getItems().addAll(smi1, smi2);
		m1.getItems().add(sm);
		
		MenuItem mi1 = new MenuItem("MenuItem 1");
		MenuItem mi2 = new MenuItem("MenuItem 2");
		MenuItem mi3 = new MenuItem("MenuItem 3");
		SeparatorMenuItem sepmi = new SeparatorMenuItem();
		MenuItem mi4 = new MenuItem("Exit");
		m1.getItems().addAll(mi1, mi2, mi3, sepmi, mi4);
		
		mi4.setGraphic(new ImageView("/helper/favorite16.png"));
		mi4.setOnAction( e -> Platform.exit() );
		//Sets Accelerator for exit
		mi4.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		 
		
		//RadioMenuItems
        RadioMenuItem rmi1 = new RadioMenuItem("RadioMenuItem 1");
        RadioMenuItem rmi2 = new RadioMenuItem("RadioMenuItem 2");
        SeparatorMenuItem sepmi2 = new SeparatorMenuItem();
        RadioMenuItem rmi3 = new RadioMenuItem("Change Color and Cursor");
        
        ToggleGroup group = new ToggleGroup();
        rmi1.setToggleGroup(group);
        rmi2.setToggleGroup(group);
        rmi1.setSelected(true);
        m2.getItems().addAll(rmi1, rmi2, sepmi2, rmi3);
        
        rmi3.setOnAction( e -> {
        	VBox vb = ((VBox)stage.getScene().getRoot());
        	if(rmi3.isSelected()) {
            	vb.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
            	stage.getScene().setCursor(Cursor.CROSSHAIR);	
        	} else {
        		vb.setBackground(new Background(new BackgroundFill(Color.web("0xf4f4f4ff"), CornerRadii.EMPTY, Insets.EMPTY)));
            	stage.getScene().setCursor(Cursor.DEFAULT);	
        	}
        });
        
        
        //CheckioMenuItems
        CheckMenuItem chmi1 = new CheckMenuItem("CheckMenuItem");
        CheckMenuItem chmi2 = new CheckMenuItem("CheckMenuItem");
        SeparatorMenuItem sepmi3 = new SeparatorMenuItem();
        CheckMenuItem chmi3 = new CheckMenuItem("Check it");
        m3.getItems().addAll(chmi1, chmi2, sepmi3, chmi3);
        
        //CustomMenuItems
        CustomMenuItem cmi1 = new CustomMenuItem(new ToggleButton("ToggleButton"));
		cmi1.setHideOnClick(false);
		Slider sl = new Slider();
		sl.setShowTickMarks(true);
		sl.setSnapToTicks(true);
        CustomMenuItem cmi2 = new CustomMenuItem(sl);
		cmi2.setHideOnClick(false);
		
		
		m4.getItems().addAll(cmi1, cmi2);
		
		
		Label l1 = new Label();
		l1.textProperty().bind(new When(chmi3.selectedProperty()).then("CheckMenuItem Selected").otherwise("CheckMenuItem Not Selected"));
		Label l2 = new Label();
		StringExpression bnd = Bindings.concat("Slider: ", ((Slider)cmi2.getContent()).valueProperty().asString());
		l2.textProperty().bind(bnd);
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(mb, l1, l2);
		
		Scene scene = new Scene(vb, 500, 400);
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
