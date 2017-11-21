package property;

import javafx.beans.Observable;
import javafx.beans.binding.Binding;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableNumberValue;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;


public class AProperty {
  
	public static void main(String[] args) {
		
		SimpleIntegerProperty ip1 = new SimpleIntegerProperty();
		SimpleIntegerProperty ip2 = new SimpleIntegerProperty(2);

		System.out.println("SimpleIntegerProperty -> "+ip1);
		System.out.print("SimpleIntegerProperty instanceof Observable -> "+(ip1 instanceof Observable));
		System.out.println("\t\t\tSimpleIntegerProperty instanceof ObservableValue -> "+(ip1 instanceof ObservableValue));
		System.out.print("SimpleIntegerProperty instanceof ObservableIntegerValue -> "+(ip1 instanceof ObservableIntegerValue));
		System.out.println("\t\tSimpleIntegerProperty instanceof ObservableNumberValue -> "+(ip1 instanceof ObservableNumberValue));
		System.out.print("SimpleIntegerProperty instanceof ReadOnlyProperty -> "+(ip1 instanceof ReadOnlyProperty));
		System.out.println("\t\tSimpleIntegerProperty instanceof WritableValue -> "+(ip1 instanceof WritableValue));
		System.out.print("SimpleIntegerProperty instanceof Property -> "+(ip1 instanceof Property));
		System.out.println("\t\t\tSimpleIntegerProperty instanceof Binding -> "+(ip1 instanceof Binding));
		
		ip1.bind(ip2);
		System.out.println("\nSimpleIntegerProperty -> "+ip1);		//value invalid because of lazy initialization
		System.out.println("SimpleIntegerProperty isBound -> "+ip1.isBound());
		
		ip1.get();
		System.out.println("SimpleIntegerProperty -> "+ip1);		//value ok because we called for value earlier
		
	}

	
}