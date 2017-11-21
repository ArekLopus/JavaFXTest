package layoutPanes;

import helper.Helper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TabPane.html
//-A control that allows switching between a group of Tabs. Only one tab is visible at a time.
//-Tabs are added to the TabPane by using the getTabs().
//-Tabs in a TabPane can be positioned at any of the four sides by specifying the Side. 

//-Tabs are placed within a TabPane, where each tab represents a single 'page'.
//-Tabs can contain any Node such as UI controls or groups of nodes added to a layout container.
//-When the user clicks on a Tab in the TabPane the Tab content becomes visible to the user.
public class TabPaneTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SplitPane");
		
		TabPane tp1 = new TabPane();
		
		Tab tab1 = new Tab();
		tab1.setText("Tab 1");
		TextArea ta1 = new TextArea(Helper.TEXT_LOREM);
		ta1.setWrapText(true);
		tab1.setContent(ta1);
		
		Tab tab2 = new Tab();
		tab2.setText("Tab 2");
		TextArea ta2 = new TextArea("by Cicero\n"+Helper.TEXT_LOREM);
		ta2.setWrapText(true);
		tab2.setContent(ta2);
		
		Tab tab3 = new Tab();
		tab3.setText("Tab 3");
		tab3.setContent(new Rectangle(200,200, Color.RED));
		
		tp1.getTabs().addAll(tab1, tab2, tab3);
		
		
		ObservableList<Side> ol = FXCollections.observableArrayList(Side.TOP, Side.BOTTOM, Side.LEFT, Side.RIGHT);
		ChoiceBox<Side> cb1 = new ChoiceBox<>(ol);
		cb1.setValue(Side.TOP);
		cb1.getSelectionModel().selectedItemProperty().addListener( (ob, oval, nval) -> {
			tp1.setSide(nval);
		});
		
		//tp1.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(cb1, tp1);
		
		Scene scene = new Scene(vb, 400, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
