package bindInContNumbers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class AbcController implements Initializable{
	
	@FXML	private TextField tf1;
	@FXML	private TextField tf2;
	@FXML	private TextField tf3;
	@FXML	private Slider slider;
	@FXML	private TextField sliderTF;
	
	@Override
	public void initialize(URL url, ResourceBundle res) {
		
		StringProperty tfp1 = tf1.textProperty();
		StringProperty tfp2 = tf2.textProperty();
		StringProperty tfp3 = tf3.textProperty();
		
		LongProperty ip1 = new SimpleLongProperty(Long.parseLong(tfp1.getValue()));
		LongProperty ip2 = new SimpleLongProperty(Long.parseLong(tfp2.getValue()));
		
//		Bindings.bindBidirectional(tfp1, ip1, new NumberStringConverter());
//		Bindings.bindBidirectional(tfp2, ip2, new NumberStringConverter());
//		NumberBinding binding = Bindings.add(ip1, ip2);
//		tfp3.bind(binding.asString());

		StringBinding binding = Bindings.createStringBinding( () -> {
			return String.valueOf(Long.parseLong(tfp1.getValue())+Long.parseLong(tfp2.getValue())) ;
			}, tf1.textProperty(), tf2.textProperty() );	//-> dependencies - if tf1 only then tf2 is not bound and doesnt react
		tfp3.bind(binding);
		
		
		int defaultSliderValue = 10;
	    IntegerProperty sliderValue = new SimpleIntegerProperty(defaultSliderValue);
		slider.valueProperty().bindBidirectional(sliderValue);
		sliderTF.textProperty().bind(sliderValue.asString());
		
		//sliderTF.textProperty().bindBidirectional(slider.valueProperty(), new NumberStringConverter());
		
      //Bindings.bindBidirectional(ip1, tfp2, new NumberStringConverter());
	}
	
}
