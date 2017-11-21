package property;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

//Binding -> ObservableValue -> Observable 
public class BindingUnidir {
  
	public static void main(String[] args) {
		
		SimpleIntegerProperty ip1 = new SimpleIntegerProperty(1);
		SimpleIntegerProperty ip2 = new SimpleIntegerProperty(2);
		SimpleIntegerProperty ip3 = new SimpleIntegerProperty();

		NumberBinding addBind = Bindings.add(ip1, ip2);
		
		System.out.println("addBind (Bindings.add(ip1, ip2)) instanceof Binding -> "+(addBind instanceof Binding));
		
		ip3.bind(addBind);
		
		System.out.println("\nNumberBinding addBind = Bindings.add(ip1, ip2), ip3.bind(addBind), ip3 -> "+ip3.getValue());
		
		ObservableList<?> dependencies = addBind.getDependencies();
		
		System.out.println("dependencies.contains(ip1) -> "+dependencies.contains(ip1));
		System.out.println("ip1.isBound() -> "+ip1.isBound());
		System.out.println("ip2.isBound() -> "+ip2.isBound());
		System.out.println("ip3.isBound() -> "+ip3.isBound());
		
		System.out.println("\ngetDependencies(): "+dependencies);
		
		//Mark a binding as invalid. This forces the recalculation of the value of the Binding next time it is request
		addBind.invalidate();
		System.out.println("\ndependencies.contains(ip1) -> "+ip3);
		System.out.println("addBind.isValid() -> "+addBind.isValid());
	}

	
}