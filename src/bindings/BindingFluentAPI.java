package bindings;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class BindingFluentAPI {

	private IntegerProperty ip1 = new SimpleIntegerProperty(1);
	private IntegerProperty ip2 = new SimpleIntegerProperty(3);
	private IntegerProperty ip3 = new SimpleIntegerProperty(6);
	
	public BindingFluentAPI() {

		NumberBinding sum = ip1.add(ip2).add(ip3);
		
		System.out.println("sum -> "+sum.getValue());
		
		//We change the value
		ip1.setValue(3);
		
		//And check if binding works
		System.out.println("sum -> "+sum.getValue());
	}
	
	
	public static void main(String[] args) {
		new BindingFluentAPI();
	}
	
	
}