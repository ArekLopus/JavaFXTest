package collections;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableListTest {
	
	
	
	public ObservableListTest() {
		
        // Use Java Collections to create the List.
        List<String> list = new ArrayList<String>();
 
        // Now add observability by wrapping it with ObservableList.
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener( (ListChangeListener<String>) change -> {		//casting, 2 methods addListener()
        	while(change.next()) {
        	
        		int addedSize = change.getAddedSize();
        		List<? extends String> addedSubList = change.getAddedSubList();
        		int removedSize = change.getRemovedSize();
        		List<? extends String> removed = change.getRemoved();
        		
        		System.out.println("change! added: "+addedSize+" -> "+addedSubList);
        		System.out.println("change! remvd: "+removedSize+" -> "+removed);
        		System.out.println("----------------------------------------------------");
        	}
        });
        
        observableList.addListener( new ListChangeListener<String>() {				//anonymous class version
			@Override
			public void onChanged(ListChangeListener.Change<? extends String> change) {
				//System.out.println("From 2nd");
			}
        });
        
        // Changes to the observableList WILL be reported.
        // This line will print out "Detected a change!"
        observableList.addAll("item one", "item two", "item three");
        observableList.remove(1);
 
        // Changes to the underlying list will NOT be reported
        // Nothing will be printed as a result of the next line.
        list.add("item two");
 
        System.out.println("Size: "+observableList.size());
		
	}
	
	
	
	
	public static void main(String[] args) {
		new ObservableListTest();
		System.out.println("Done");
	}

}
