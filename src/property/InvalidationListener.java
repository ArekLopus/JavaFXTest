package property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class InvalidationListener {
  
	public static void main(String[] args) {
		
		IntegerProperty ip1 = new SimpleIntegerProperty();
		IntegerProperty ip2 = new SimpleIntegerProperty(2);
		
		ip1.addListener( (e) -> {
			System.out.println("invalidation listener called -> "+e);
		} );
		
		ip1.bind(ip2);
		System.out.println("SimpleIntegerProperty -> "+ip1);		//value invalid because of lazy initialization
		
		ip1.get();
		System.out.println("SimpleIntegerProperty -> "+ip1);		//value ok because we called for value earlier
		
		ip2.set(10);
		ip2.set(10);
		ip2.set(10);	//invalidation listener called only ONCE
		
	}

	
}