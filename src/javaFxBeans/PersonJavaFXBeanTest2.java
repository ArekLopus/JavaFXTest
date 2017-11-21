package javaFxBeans;

import java.beans.PropertyVetoException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

public class PersonJavaFXBeanTest2 {

	public PersonJavaFXBeanTest2() throws NoSuchMethodException {

		PersonJavaBean person = new PersonJavaBean();

		JavaBeanStringProperty phoneNumberProperty = JavaBeanStringPropertyBuilder.create().bean(person).name("phoneNumber").build();
		phoneNumberProperty.addListener((observable, oldValue, newValue) -> {
			System.out.println("JavaFX property " + observable + " changed:");
			System.out.println("\toldValue = " + oldValue + ", newValue = " + newValue);
		});
		
		System.out.println("Setting phoneNumber on the JavaBeans property");
		try {
			person.setPhoneNumber("111-111-1111");
		} catch (PropertyVetoException e) {
			System.out.println("A JavaBeans property change is vetoed.");
		}
		
		System.out.println("Bind phoneNumberProperty to another property");
		SimpleStringProperty stringProperty = new SimpleStringProperty("222-222-2222");
		phoneNumberProperty.bind(stringProperty);

		System.out.println("Setting phoneNumber on the JavaBeans property");
		try {
			person.setPhoneNumber("333-333-3333");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			System.out.println("A JavaBeans property change is vetoed.");
		}
		System.out.println("person.getPhoneNumber() = " + person.getPhoneNumber());
	}

	public static void main(String[] args) throws Exception {
		new PersonJavaFXBeanTest2();
	}

}
