package controls.treeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class TreeViewWithCheckBoxTreeCell extends Application {
       
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("TreeView");
        
        CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String>("Items");
        rootItem.setExpanded(true);   
        
        //To make a CheckBoxTreeItem independent: 
        //rootItem.setIndependent(true);
      
        TreeView<String> tree = new TreeView<>(rootItem);  
        
        tree.setCellFactory(CheckBoxTreeCell.<String>forTreeView());    

        CheckBoxTreeItem<String> it1 = new CheckBoxTreeItem<>("Item1");
        CheckBoxTreeItem<String> it2 = new CheckBoxTreeItem<>("Item2");
        CheckBoxTreeItem<String> it3 = new CheckBoxTreeItem<>("Item3");
        CheckBoxTreeItem<String> it4 = new CheckBoxTreeItem<>("Item4");
        
        rootItem.getChildren().addAll(it1, it2, it3, it4);                
        
        
        tree.setRoot(rootItem);
        tree.setShowRoot(true);
        
        
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}