package helper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Numbers  {
	
	private StringProperty id = new SimpleStringProperty("");
	
	private IntegerProperty i1 = new SimpleIntegerProperty(0);
	private IntegerProperty i2 = new SimpleIntegerProperty(0);
	private IntegerProperty i3 = new SimpleIntegerProperty(0);
	private IntegerProperty i4 = new SimpleIntegerProperty(0);
	private IntegerProperty i5 = new SimpleIntegerProperty(0);
	
	public Numbers(String id, Integer i1, Integer i2, Integer i3, Integer i4, Integer i5) {
		this.id.setValue(id);
		this.i1.setValue(i1);
		this.i2.setValue(i2);
		this.i3.setValue(i3);
		this.i4.setValue(i4);
		this.i5.setValue(i5);
	}
	
	public String getId() {
		return id.getValue();
	}
	public void setId(String i1) {
		this.id.setValue(i1);
	}
	public Integer getI1() {
		return i1.getValue();
	}
	public void setI1(Integer i1) {
		this.i1.setValue(i1);
	}
	public Integer getI2() {
		return i2.getValue();
	}
	public void setI2(Integer i2) {
		this.i2.setValue(i2);
	}
	public Integer getI3() {
		return i3.getValue();
	}
	public void setI3(Integer i3) {
		this.i3.setValue(i3);
	}
	public Integer getI4() {
		return i4.getValue();
	}
	public void setI4(Integer i4) {
		this.i4.setValue(i4);
	}
	public Integer getI5() {
		return i5.getValue();
	}
	public void setI5(Integer i5) {
		this.i5.setValue(i5);
	}
	
	public StringProperty getIdProperty() {
		return id;
	}
	public IntegerProperty getI1Property() {
		return i1;
	}
	public IntegerProperty getI2Property() {
		return i2;
	}
	public IntegerProperty getI3Property() {
		return i3;
	}
	public IntegerProperty getI4Property() {
		return i4;
	}
	public IntegerProperty getI5Property() {
		return i5;
	}

	
	
}