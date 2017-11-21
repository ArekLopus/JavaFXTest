package bindings;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Binding {

	private StringProperty sp1 = new SimpleStringProperty();
	private StringProperty sp2 = new SimpleStringProperty();
	
	public Binding() {
		
		sp1.addListener( ( observable, oldValue,  newValue) -> {
			System.out.println("from listener sp1, "+observable+", "+oldValue+", "+newValue);
		});
//		sp2.addListener( ( observable, oldValue,  newValue) -> {
//			System.out.println("from listener sp2, "+observable+", "+oldValue+", "+newValue);
//		});
		
		sp1.setValue("val1");
		
		//sp2 is bound to sp1 so it gets value of sp1
		//sP2bindsOnSP1();			//bind OR bindBidirectional
		//sp2.setValue("val2");		//Exception in thread "main" java.lang.RuntimeException: A bound value cannot be set.
		
		//when it is bidirectional sp1 gets value of sp2 and sp2 gets value of sp1
		sP2bindsBidirectionalOnSP1();
		sp2.setValue("val2");
		
		System.out.println("sp1.getValue() -> "+sp1.getValue());
		System.out.println("sp2.getValue() -> "+sp2.getValue());
		
		
	}
	@SuppressWarnings("unused")
	private void sP2bindsOnSP1() {
		sp2.bind(sp1);
	}
	
	private void sP2bindsBidirectionalOnSP1() {
		sp2.bindBidirectional(sp1);
	}
	
	public static void main(String[] args) {
		new Binding();
	}
	
	
}