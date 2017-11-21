package collections;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class SortedListTest {
	
	private Collator collator = Collator.getInstance(Locale.getDefault());
	
	public SortedListTest() {
		
        List<String> list = new ArrayList<String>();
        ObservableList<String> observableList = FXCollections.observableList(list);
        SortedList<String> sortedList = new SortedList<>(observableList, collator::compare); 
        
        observableList.addAll("d", "¹", "a", "c", "b", "¥", "¯", "Ÿ");
 
        System.out.println("Sorted list: "+sortedList);
		
	}
	
	
	
	
	public static void main(String[] args) {
		new SortedListTest();
		System.out.println("Done");
	}

}
