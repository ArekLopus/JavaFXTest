package fxml2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.util.Builder;

@SuppressWarnings("unused")
public class DateBuilder implements Builder<Date> {
    
	private String dateToParse;
	private long time;
	
	public String getDateToParse() {
		return dateToParse;
	}
	
	public void setDateToParse(String dateToParse) {
		time = parseToDateLong(dateToParse);
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	
	private Date parseToDate(String toParse) {
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = formatter.parse(toParse);
		    //long dateInLong = date.getTime();
		    time = date.getTime();
		    return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	private long parseToDateLong(String toParse) {
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    Date date = formatter.parse(toParse);
		    long dateInLong = date.getTime();
		    return dateInLong;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
    public Date build() {
    	return new Date(time);
    }
}