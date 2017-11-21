package controls.treeView;

import helper.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TreeViewSimple extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TreeView");
		
		ImageView rootIcon = new ImageView(new Image("/helper/favorite16.png"));

		//TreeItem can be a root, a child, or a leaf(an item without children)
		TreeItem<String> root = new TreeItem<String> ("Favorites", new ImageView("/helper/favorite16.png"));
		//By default, all TreeItem instances are collapsed
		root.setExpanded(true);
		
		//The recommended size for icons is 16x16, but in fact, any Node object can be set as the icon and it will be fully interactive.
		TreeItem<String> rootColor = new TreeItem<String>("Color", new ImageView("/helper/color16.png"));
		rootColor.setExpanded(true);
		TreeItem<String> item1 = new TreeItem<String>("yellow");
		TreeItem<String> item2 = new TreeItem<String>("red");
		TreeItem<String> item3 = new TreeItem<String>("green");
		rootColor.getChildren().addAll(item1, item2, item3);
		
		
		TreeItem<String> rootFruit = new TreeItem<String>("Fruit", new ImageView("/helper/fruit16.png"));
		rootFruit.setExpanded(true);
		TreeItem<String> item4 = new TreeItem<String>("Banna");
		TreeItem<String> item5 = new TreeItem<String>("Apple");
		TreeItem<String> item6 = new TreeItem<String>("Pear");            
		rootFruit.getChildren().addAll(item4, item5, item6);
		
		TreeItem<String> aLeaf = new TreeItem<String>("A Leaf has no children");
		aLeaf.setExpanded(true);
		root.getChildren().addAll(rootColor, rootFruit, aLeaf);
		
		//You need a 1 root and then you can have branches
		TreeView<String> tree = new TreeView<String>(root);
		//tree.setRoot(root);			//The other way of setting the root item
		
		//To show root item or not (not if root is only a container)
		//tree.setShowRoot(false);
		
		
		tree.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> {
			System.out.println(newValue.getClass().getName()+", "+newValue.getValue());
			
		} );
		
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(tree);
		
		Scene scene = new Scene(vb);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}