package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class SettingItemCollectionController implements Initializable {
	
	@FXML
	private ComboBox<String> cb;
	
	@FXML
	private ObservableList<String> ol = FXCollections.<String>observableArrayList();
	
	@FXML
	private void handler2() {
		System.out.println("Handler 2");
	}
	
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println();
		ol.addAll("Item 1", "Item 2", "Item 3", "Item 4");
		
		if(cb != null) {
			System.out.println("Not Null");
			cb.setItems(ol);
			cb.setValue("Item 2");
		}
	}




	public ObservableList<String> getOl() {
		return ol;
	}

	public void setOl(ObservableList<String> ol) {
		this.ol = ol;
	}
	
	
	
}
