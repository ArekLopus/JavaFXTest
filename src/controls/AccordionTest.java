package controls;

import helper.Helper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Accordion.html
//An accordion is a group of TitlePanes. Only one TitledPane can be opened at a time.
public class AccordionTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Accordion");
		
		
		TitledPane t1 = new TitledPane("Titled Pane 1", new TextArea(Helper.TEXT_LOREM));
		((TextArea)t1.getContent()).setWrapText(true);
		t1.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
		TitledPane t2 = new TitledPane("Titled Pane 2", new TextArea(Helper.TEXT_LOREM));
		((TextArea)t2.getContent()).setWrapText(true);
		TitledPane t3 = new TitledPane("Titled Pane 3", new TextArea(Helper.TEXT_LOREM));
		((TextArea)t3.getContent()).setWrapText(true);
		
		Accordion ac1 = new Accordion();
		ac1.getPanes().addAll(t1, t2, t3);
		
		ac1.setExpandedPane(t2);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(ac1);
		
		Scene scene = new Scene(vb, 320, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
