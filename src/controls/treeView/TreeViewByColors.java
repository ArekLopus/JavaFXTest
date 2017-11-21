package controls.treeView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewByColors extends Application {
	
	private final ImageView rootIcon = new ImageView(new Image(getClass().getResourceAsStream("/helper/favorite16.png")));
	private final Image colorIcon = new Image(getClass().getResourceAsStream("/helper/color16.png"));
	
	private ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
			new Person("Will", "Johnson", "will.johnson@mail.com", "orange"),
			new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "yellow"),
			new Person("Bruce", "Lee", "bruce.lee@mail.com", "red"),
			new Person("Jenna", "Adams", "jenna.addams@mail.com", "orange"));
	TreeItem<String> rootNode = new TreeItem<String>("Favorite colors", rootIcon);
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("TreeView");
		
		data.sort( (p1, p2) -> {
			return p1.getFavoriteColor().compareToIgnoreCase(p2.getFavoriteColor());
		} );
		
		
		//root node contains ONLY nodes with colors
		for (Person pr : data) {
            TreeItem<String> personLeaf = new TreeItem<String>(pr.getFirstName());		//New leaf for a Person
            boolean found = false;
            for (TreeItem<String> colorsNode : rootNode.getChildren()) {				//Searching all nodes in the root node
                if (colorsNode.getValue().equals(pr.getFavoriteColor())){				//if favColor for the person exists as a node
                    colorsNode.getChildren().add(personLeaf);							//we just add that person to this node
                    found = true;
                    break;
                }
            }
            if (!found) {		//if favColor for the person DOES NOT exists as a node we create a new one
                TreeItem<String> colorNode = new TreeItem<String>(pr.getFavoriteColor(), new ImageView(colorIcon));
                colorNode.setExpanded(true);
                rootNode.getChildren().add(colorNode);
                colorNode.getChildren().add(personLeaf);
            }
        }
		
		
		TreeView<String> tree = new TreeView<String>(rootNode);
		rootNode.setExpanded(true);
		
		
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