package javaFxBeans;

import java.beans.PropertyVetoException;

import javafx.beans.Observable;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

public class PersonJavaFXBeanTest {
	
	
	public PersonJavaFXBeanTest() throws PropertyVetoException, NoSuchMethodException {
		
		PersonJavaBean person = new PersonJavaBean();
		person.addPropertyChangeListener( (e) -> { System.out.println("PropertyChangeListener fired: -> "+e);  });
		person.addVetoableChangeListener( (e) -> { System.out.println("VetoableChangeListener fired -> "+e);   });
		
		person.setName("John Doe");		
		person.setAddress("Maine ave");
		person.setPhoneNumber("123-456-7890");
		
		System.out.println("");
		
		JavaBeanStringProperty nameProperty = JavaBeanStringPropertyBuilder.create()
				.bean(person)
				.name("name")
				.build();
		nameProperty.addListener( (ob, oV, nV) -> {
			System.out.println("JavaFX PropertyChangeListener fired for namePropery, old name: " +oV+ ", new name: "+nV);
		} );
		System.out.println(person);
		
		nameProperty.set("John Rambo");
		
		System.out.println(person);
		System.out.println("");
		System.out.println("nameProperty instanceof Observable -> "+(nameProperty instanceof Observable));
	}
	
	public static void main(String[] args) throws Exception {
		new PersonJavaFXBeanTest();
	}

}

