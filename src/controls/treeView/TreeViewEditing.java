package controls.treeView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TreeViewEditing extends Application {
	
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
		
		
		tree.setEditable(true);
        
		tree.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new MyTextFieldTreeCell();
            }
        });
		
        
        
        Button b1 = new Button("Print all elements");
		b1.setOnAction( e -> {
			data.forEach(System.out::println);
			System.out.println("--------------------------------");
		} );
        
        
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(tree, b1);
		
		Scene scene = new Scene(vb);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	private class MyTextFieldTreeCell extends TreeCell<String> {
		
	   	private TextField tf;
	   	private Person editedPerson = null;
	 
	   	@Override
	   	public void startEdit() {
		   super.startEdit();

	       if(!getTreeItem().isLeaf()) {			//if the tree item is not a leaf (has children) - we cancel editing
	    	   cancelEdit();
	    	   return;
	       } 
		   
		   if (tf == null) {
			   createTextField();
	       }
		   setText(null);
	       setGraphic(tf);
	       
	       editedPerson = data.stream().filter( p -> p.getFirstName().equals(getItem()) ).findFirst().orElse(null);
	   	}
	   	
	   	@Override
	   	public void cancelEdit() {
	   		super.cancelEdit();
	   		
	   		setText(getItem());						//getItem() == getTreeItem().getValue()
	   		setGraphic(getTreeItem().getGraphic());
	    }
	 
	   	@Override
	   	public void updateItem(String item, boolean empty) {
	   		super.updateItem(item, empty);
	   		
	   		if (empty) {
	   			setText(null);
	   			setGraphic(null);
	        } else {
	        	if (isEditing()) {
	        		if (tf != null) {
	        			tf.setText(getItem());
	                }
	                setText(null);
	                setGraphic(tf);
	            } else {
	                setText(getItem());
	                setGraphic(getTreeItem().getGraphic());
	            }
	        }
	    }
	   	
	   	@Override
	   	public void commitEdit(String newValue) {
	   		super.commitEdit(newValue);
	   		
	   		if (editedPerson != null) {
	   			editedPerson.setFirstName(newValue);
	   		}
	   	}
	   	
	   	
	    private void createTextField() {
	    	tf = new TextField(getItem());
	    	tf.setOnKeyReleased(new EventHandler<KeyEvent>() {
	    		
	    		@Override
	    		public void handle(KeyEvent t) {
	    			if (t.getCode() == KeyCode.ENTER) {
	    				commitEdit(tf.getText());
	                } else if (t.getCode() == KeyCode.ESCAPE) {
	                	cancelEdit();
	                }
	            }
	        });
	    }

	}
}

