package controls.treeView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewSelectionModel extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TreeView");
		
		TreeItem<String> root = new TreeItem<String> ("Favorites", new ImageView("/helper/favorite16.png"));
		root.setExpanded(true);
		
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
		
		TreeView<String> tree = new TreeView<String>(root);
		
		
		//To be able to select multiple items
		tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		tree.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue) -> {
			System.out.println("Selected Index: "+tree.getSelectionModel().getSelectedIndex());
			System.out.println("Selected Indices: "+tree.getSelectionModel().getSelectedIndices());
			System.out.println("Selected item: "+tree.getSelectionModel().getSelectedItem());
			System.out.println("Selected items: "+tree.getSelectionModel().getSelectedItems());
			System.out.println("------------------------------------");
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