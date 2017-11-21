package helper;

import java.util.Date;

public class User {
	
	private String name;
	private String surname;
	private Date dob;
	
	public User(String name, String surname, Date dob) {
		this.name = name;
		this.surname = surname;
		this.dob = dob;
	}

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public User() {}

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
		return "User [name=" + name + ", surname=" + surname + ", dob=" + dob + "]";
	}

}