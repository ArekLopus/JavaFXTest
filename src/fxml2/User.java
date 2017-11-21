package fxml2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	private String name;
	private String surname;
	private Date dob;
	
	private List<String> testList = new ArrayList<>();
	private Map<String, String> testMap = new HashMap<>();
	
	public User(String name, String surname, Date dob) {
		this.name = name;
		this.surname = surname;
		this.dob = dob;
	}
	
	//If used, exception - Property "abc" does not exist or is read-only when i try to add something to testMap
//	public User(@NamedArg("name") String name, @NamedArg("surname") String surname ) {
//		this.name = name;
//		this.surname = surname;
//	}
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
	
	public List<String> getTestList() {
		return testList;
	}

//	public void setTestList(List<String> testList) {
//		this.testList = testList;
//	}

	public Map<String, String> getTestMap() {
		return testMap;
	}

//	public void setTestMap(Map<String, String> testMap) {
//		this.testMap = testMap;
//	}

	public static Date valueOf(String dob) {
		
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = formatter.parse(dob);
		    //long dateInLong = date.getTime();
		    return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", dob=" + dob + "]";
	}

}