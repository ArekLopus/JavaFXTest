package property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class ChangeListener {
	
	public ChangeListener() {
		
		IntegerProperty ip1 = new SimpleIntegerProperty(this,"mySimpleInt", 1);
		IntegerProperty ip2 = new SimpleIntegerProperty(2);
		
		ip1.addListener( (el, oldVal, newVal) -> {
			System.out.println("\nChange listener called ");
			System.out.println("Element: "+el);
			System.out.println("Old value: "+oldVal);
			System.out.println("New value: "+newVal);
		} );
		
		ip1.bind(ip2);
		
		ip1.unbind();
		
		ip1.set(11);
		ip1.set(11);
		ip1.set(11);	//change listener called only ONCE

	}
	
	public static void main(String[] args) {
		new ChangeListener();
	}

	
}