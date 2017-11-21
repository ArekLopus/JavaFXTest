package javaFxBeans;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

//http://stackoverflow.com/questions/19822717/binding-a-labels-text-property-in-an-fxml-file-to-an-integerproperty-in-a-co
public class JavaFxBeanController implements Initializable {
	
	//bound in fxml
	private IntegerProperty counter = new SimpleIntegerProperty(this, "myInt", 15);


    @Override
    public void initialize(URL url, ResourceBundle resources) {
    	
    }

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        //Works here but not in fxml binding if no property getter
    	setCounter(getCounter() - 1);
        System.out.println(getCounter());
    }
    
    
    //JavaFX Bean must have setter/getter/property getter
    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int value) {
        counter.set(value);
    }
    //MUST be to work
    public IntegerProperty counterProperty() {
        return counter;
    }
}