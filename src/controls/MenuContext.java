package controls;

import com.sun.javafx.scene.control.ControlAcceleratorSupport;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ContextMenu.html
//A popup control containing an ObservableList of menu items. The items ObservableList allows for any MenuItem type to be inserted,
//including its subclasses Menu, MenuItem, RadioMenuItem, CheckMenuItem and CustomMenuItem. 
//If an arbitrary Node needs to be inserted into a menu, a CustomMenuItem can be used.  

//Control.setContextMenu(javafx.scene.control.ContextMenu) convenience method can be used to set a context menu on on any control.
//or from event handler -> cm.show(iv1, e.getScreenX(), e.getScreenY());
public class MenuContext extends Application {
	
	private ImageView iv1 = new ImageView("/helper/Smile128.png");
	private Label l1 = new Label("This label is waiting for an image");
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ContextMenu");
		
		ContextMenu cm = new ContextMenu();
		MenuItem mi1 = new MenuItem("Copy Image to Clipboard");
		MenuItem mi2 = new MenuItem("Copy Image to Label");
		MenuItem mi3 = new MenuItem("Move");
		cm.getItems().addAll(mi1, mi2, mi3);
		
		mi1.setOnAction( e -> {
			Clipboard cb = Clipboard.getSystemClipboard();
	        ClipboardContent content = new ClipboardContent();
	        content.putImage(iv1.getImage());
	        cb.setContent(content);
		});
		mi2.setOnAction( e -> {
			ImageView iv = new ImageView(iv1.getImage());
			iv.setFitWidth(24);
			iv.setFitHeight(24);
			l1.setGraphic(iv);
		});
		mi3.setOnAction( e -> {
			iv1.setTranslateX(iv1.getTranslateX()+10);
			iv1.setTranslateY(iv1.getTranslateY()+10);
		});
		
		SeparatorMenuItem sm = new SeparatorMenuItem();
		Menu m1 = new Menu("Parent");
		MenuItem cmi1 = new MenuItem("Child 1");
		MenuItem cmi2 = new MenuItem("Child 2");
		MenuItem mi = new MenuItem("Menuitem");
		CheckMenuItem cmi = new CheckMenuItem("Check Menu Item");
		m1.getItems().addAll(cmi1, cmi2);
		MenuItem m2 = new MenuItem("Exit");
		m2.setOnAction( e -> { Platform.exit(); });
		cm.getItems().addAll(sm, m1, mi, cmi, m2);
		
		m2.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		//ContextMenu: accelerators not working without access to hidden api 
		//https://bugs.openjdk.java.net/browse/JDK-8166832
		//uncomment to make accelerator work
        //ControlAcceleratorSupport.addAcceleratorsIntoScene(cm.getItems(), iv1);
        
		//ContextMenu works ok when ContextMenu set directly to Control
        l1.setContextMenu(cm);
		
        //ContextMenu events
        cm.setOnAction( e->{ System.out.println("onAction event"); });
        cm.setOnAutoHide(e->{ System.out.println("onAutoHide event"); });
        cm.setOnCloseRequest(e->{ System.out.println("onCloseRequest event"); });
        cm.setOnHidden(e->{ System.out.println("onHidden event"); });
        cm.setOnHiding(e->{ System.out.println("onHiding event"); });
        cm.setOnShowing(e->{ System.out.println("onShowing event"); });
        cm.setOnShown(e->{ System.out.println("onShown event"); });
        
		iv1.setOnContextMenuRequested( e -> {
			System.out.println("ContextMenuRequested event");
			cm.show(iv1, e.getScreenX(), e.getScreenY());
		});
		
		l1.setContentDisplay(ContentDisplay.RIGHT);
		l1.setPrefHeight(30);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l1, iv1);
		
		Scene scene = new Scene(vb, 500, 400);
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
