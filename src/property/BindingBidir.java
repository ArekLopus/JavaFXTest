package property;

import javafx.beans.property.SimpleIntegerProperty;

//Binding -> ObservableValue -> Observable 
public class BindingBidir {
  
	public static void main(String[] args) {
		
		SimpleIntegerProperty ip1 = new SimpleIntegerProperty(1);
		SimpleIntegerProperty ip2 = new SimpleIntegerProperty(2);
		ip1.addListener( (e)->{ System.out.println("ChangeListener fired"); } );
		
		ip1.bindBidirectional(ip2);
		
		System.out.println("ip1.isBound() -> "+ip1.isBound());	//isBound works only for unidirectional bindings
		System.out.println("ip2.isBound() -> "+ip2.isBound());
		
		System.out.println("ip1 -> "+ip1);
		
		ip1.set(10);
		System.out.println("ip1 -> "+ip1);
		System.out.println("ip2 -> "+ip2);
		
		ip2.set(20);
		System.out.println("ip1 -> "+ip1);
		System.out.println("ip2 -> "+ip2);
		
		System.out.println();
		
	}

	
}