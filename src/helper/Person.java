package helper;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty email;
	private SimpleStringProperty favoriteColor;

	public Person(String fName, String lName, String email, String color) {
		this.firstName = new SimpleStringProperty(fName);
		this.lastName = new SimpleStringProperty(lName);
		this.email = new SimpleStringProperty(email);
		this.favoriteColor = new SimpleStringProperty(color);
	}
	
	public Person() {}
	
	
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String fName) {
		firstName.set(fName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String fName) {
		lastName.set(fName);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String fName) {
		email.set(fName);
	}
	public String getFavoriteColor() {
		return favoriteColor.get();
	}
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor.set(favoriteColor);
	}
	
	public SimpleStringProperty getFirstNameProperty() {
		return firstName;
	}
	public SimpleStringProperty getLastNameProperty() {
		return lastName;
	}
	public SimpleStringProperty getEmailProperty() {
		return email;
	}
	public SimpleStringProperty getFavoriteColorProperty() {
		return favoriteColor;
	}

	
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName.get() + ", lastName=" + lastName.get() + ", email=" + email.get() + ", favoriteColor="
				+ favoriteColor.get() + "]";
	}
	
	
}