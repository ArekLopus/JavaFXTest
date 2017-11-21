package controls.treeTableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class TreeTableViewTest extends Application {
	
	private ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
			new Person("Will", "Johnson", "will.johnson@mail.com", "orange"),
			new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "yellow"),
			new Person("Bruce", "Lee", "bruce.lee@mail.com", "red"),
			new Person("Jenna", "Adams", "jenna.addams@mail.com", "orange"));
	
    private ImageView depIcon = new ImageView (new Image(getClass().getResourceAsStream("/helper/color16.png")));
    private TreeItem<Person> root = new TreeItem<>(new Person("Sales", "", "", ""), depIcon);
    private TreeTableView<Person> tree = new TreeTableView<>(root);

    @Override
    public void start(Stage stage) {
    	stage.setTitle("TreeTableView");
    	//tree.setShowRoot(false);
    	root.setExpanded(true);

        data.stream().forEach( (person) -> {
            root.getChildren().add(new TreeItem<>(person));
        });
        
        
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
        
        
        VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(tree);
        
        Scene scene = new Scene(vb);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(TreeTableViewTest.class, args);
    }

}