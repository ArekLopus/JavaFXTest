package controls.treeTableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class TreeTableViewSelection extends Application {
 
	private ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
			new Person("Will", "Johnson", "will.johnson@mail.com", "orange"),
			new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "yellow"),
			new Person("Bruce", "Lee", "bruce.lee@mail.com", "red"),
			new Person("Jenna", "Adams", "jenna.addams@mail.com", "orange"));
	
    private Image img = new Image(getClass().getResourceAsStream("/helper/color16.png"));
    
    private TreeItem<Person> root = new TreeItem<>(new Person("Root", "", "", ""), new ImageView(img));
    private TreeItem<Person> dep1 = new TreeItem<>(new Person("Sales", "", "", ""), new ImageView(img));
    private TreeItem<Person> dep2 = new TreeItem<>(new Person("R&D", "", "", ""), new ImageView(img));
    private TreeTableView<Person> tree = new TreeTableView<>(root);

    @Override
    public void start(Stage stage) {
    	stage.setTitle("TreeTableView");
    	tree.setShowRoot(false);
    	
    	root.setExpanded(true);
    	dep1.setExpanded(true);
    	dep2.setExpanded(true);
    	
    	data.stream().forEach( (person) -> {
            dep1.getChildren().add(new TreeItem<>(person));
        });
        data.stream().forEach( (person) -> {
            dep2.getChildren().add(new TreeItem<>(person));
        });
        
        root.getChildren().addAll(dep1, dep2);
        
        
        TreeTableColumn<Person, String> firstNameCol = new TreeTableColumn<>("First Name");
        firstNameCol.setPrefWidth(100);
        TreeTableColumn<Person, String> lastNameCol = new TreeTableColumn<>("Last Name");
        lastNameCol.setPrefWidth(100);
        TreeTableColumn<Person, String> emailCol = new TreeTableColumn<>("Email");
        emailCol.setPrefWidth(150);
        
        firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<Person, String>("lastName"));
        emailCol.setCellValueFactory(new TreeItemPropertyValueFactory<Person, String>("email"));
        
        //TreeTableView supports classes that don't contain properties
        //TreeTableColumn.CellDataFeatures -> getTreeTableColumn(), getTreeTableView(), getValue() (TreeItem<S>) 
//      firstNameCol.setCellValueFactory( (TreeTableColumn.CellDataFeatures<Person, String> param) -> 
//      	new ReadOnlyStringWrapper(param.getValue().getValue().getFirstName())	//1st getValue() returns TreeItem
//      );
        
        tree.getColumns().setAll(firstNameCol, lastNameCol, emailCol);
        
        
        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //tree.getSelectionModel().setCellSelectionEnabled(true);
        
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