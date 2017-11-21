package bindings;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class BindingBindingsAndFluentAPI {

	private IntegerProperty ip1 = new SimpleIntegerProperty(1);
	private IntegerProperty ip2 = new SimpleIntegerProperty(2);
	private IntegerProperty ip3 = new SimpleIntegerProperty(3);
	
	public BindingBindingsAndFluentAPI() {

		NumberBinding sum = Bindings.add(ip1.multiply(2), ip2.multiply(2)).add(ip3.multiply(2));
		
		System.out.println("sum -> "+sum.getValue());
		
		//We change the value
		ip1.setValue(2);
		
		//And check if binding works
		System.out.println("sum -> "+sum.getValue());
	}
	
	
	public static void main(String[] args) {
		new BindingBindingsAndFluentAPI();
	}
	
	
}