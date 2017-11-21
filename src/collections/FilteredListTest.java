package collections;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class FilteredListTest {
	
	public FilteredListTest() {
		
        List<String> list = new ArrayList<String>();
        ObservableList<String> observableList = FXCollections.observableList(list);
        FilteredList<String> filteredList = new FilteredList<String>(observableList, x -> x.contains("a") ); 
        
        observableList.addAll("abc", "def", "ghi", "daf", "oth", "mtg", "Ÿat");
 
        System.out.println("Filtered list: "+filteredList);
		
	}
	
	
	
	
	public static void main(String[] args) {
		new FilteredListTest();
		System.out.println("Done");
	}

}
