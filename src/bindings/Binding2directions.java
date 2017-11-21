package bindings;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Binding2directions {
  
	public static void main(String[] args) {

		StringProperty sp = new SimpleStringProperty();
		User user = new User("James", "Bind");
		
		sp.bindBidirectional(user.firstNameProperty());

		user.firstNameProperty().set("newFirstName");
		System.out.println("firstNameProperty = " + user.firstNameProperty().get());
		System.out.println("sp = " + sp.get());
		
		sp.set("New String Property Value");
		System.out.println("firstNameProperty = " + user.firstNameProperty().get());
		System.out.println("sp = " + sp.get());

	}
}

class User {

	private SimpleStringProperty firstName = new SimpleStringProperty();
	private SimpleStringProperty lastName = new SimpleStringProperty();

	public User(String fn, String ln) {
		firstName.setValue(fn);
		lastName.setValue(ln);
	}

	public final String getFirstName() {
		return firstName.getValue();
	}
	public final String getLastName() {
		return lastName.getValue();
	}
	
	
	public final void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}
	public final void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}
	
	
	public StringProperty firstNameProperty() {
		return firstName;
	}
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	
}