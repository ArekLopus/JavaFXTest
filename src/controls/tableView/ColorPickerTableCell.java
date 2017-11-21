package controls.tableView;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Example of a custom cell with a color picker 
public class ColorPickerTableCell<T> extends TableCell<T,String> {

	private ColorPicker colorPicker = new ColorPicker();
	private Rectangle rect = new Rectangle(80, 20);
		
	public ColorPickerTableCell(TableColumn<T, String> column) {
		
		this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
				
		colorPicker.valueProperty().addListener( (obs, oldV, newV) -> {
		    if(this.isEditing()) {				//Tells if the cell is currently in its editing state or not.
		    	commitEdit(newV.toString());
		    	System.out.println("Color pickers Listener");
		    }
		});	
	}
				
	//Called when editing has been requested on a cell
	//We are setting the color picker visible
	@Override
	public void startEdit() {
		super.startEdit();
		
		setGraphic(colorPicker);
		
		System.out.println("startEdit()");
	}
				
	//When you call commitEdit() an event is fired to the TableView, you can observe it by adding an EventHandler
	//TableColumn.setOnEditCommit(javafx.event.EventHandler). EventHandler is also available for edit start and edit cancel. 
	@Override
	public void commitEdit(String newValue) {
		super.commitEdit(newValue);

		System.out.println("CommitEdit()");
	}
				
	//Reset the UI back to its original visual state when the editing concludes
	//Sets back rectangle instead of color picker
	@Override
	public void cancelEdit() {
		super.cancelEdit();

		setGraphic(rect);
		
		System.out.println("cancelEdit()");
	}
				
	//updateItem() is called whenever the item in the cell changes
	//It should NOT be called by developers
	@Override
	protected void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		
		if(item == null || item.isEmpty() || empty) {
			setGraphic(null);
			return;
		}
						
		try {
			rect.setFill(Color.valueOf(item));
			this.colorPicker.setValue(Color.valueOf(item));
		} catch (Exception e) {
			System.out.println("Exception was thrown when setting a color: "+e.getMessage());
			setGraphic(null);
		}
	            	
		setGraphic(rect);
		
		System.out.println("updateItem()");
	}
}
