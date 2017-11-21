package fxml2;

import java.util.Date;

import javafx.beans.NamedArg;

//The @NamedArg annotation allows an FXMLLoader to instantiate a class that does not have a zero-argument constructor.
public class User2 {
	
	private String name;
	private String surname;
	private Date dob;
	
	public User2(String name, String surname, Date dob) {
		this.name = name;
		this.surname = surname;
		this.dob = dob;
	}

	public User2(@NamedArg("name") String name, @NamedArg("surname") String surname ) {
		this.name = name;
		this.surname = surname;
	}
	
//	public User2(String name, String surname ) {
//		this.name = name;
//		this.surname = surname;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User2 [name=" + name + ", surname=" + surname + ", dob=" + dob + "]";
	}

}