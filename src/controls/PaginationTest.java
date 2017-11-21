package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Pagination;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Pagination.html
//-A Pagination control is used for navigation between pages of a single content, which has been divided into smaller parts. 
public class PaginationTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Pagination");
		
		////Creates a Pagination control with an INDETERMINATE page count and the current page index equal to zero
		Pagination p1 = new Pagination();
		//Creates a Pagination control with 5 pages and the current page index equal to zero
		Pagination p2 = new Pagination(5);
		//Creates a Pagination control with 5 pages and the current selected index equal to 2
		Pagination p3 = new Pagination(5, 2);
		p3.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
		
		
		String[] links = new String[100];
		for (int j = 0; j<links.length; j++) {
			links[j] = "Link "+(j+1);
		}
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		Pagination pagination = new Pagination(links.length/10, 0);
		pagination.setPageFactory(new Callback<Integer, Node>() {
			public Node call(Integer pageIndex) {
				System.out.println("pageIdex: "+pageIndex);
				VBox box = new VBox(5);
				for (int i = pageIndex*10; i < (pageIndex*10) + 10; i++) {
					Hyperlink link = new Hyperlink(links[i]);
					box.getChildren().add(link);
		        }
				return box;
			}
		});
		vb1.getChildren().add(pagination);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(p1, p2, p3, vb1);
		
		Scene scene = new Scene(vb, 320, 550);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
