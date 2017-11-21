package controls.tableView;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;


//Some other example http://info.michael-simons.eu/2014/10/27/custom-editor-components-in-javafx-tablecells/
//Callback intf has a method:  R call(P param) - here -> TableCell<Person, String> call(TableColumn<Person, String> col)
//so we can use constructor reference because we pass a TableColumn to the constructor and it returns new subclass of TableCell 

//We can call
//colorCol.setCellFactory(ColorPickerTableCell2::new);
//or
//colorCol.setCellFactory(new Callback<TableColumn<Person,String>, TableCell<Person,String>>() {
//	@Override
//	public TableCell<Person, String> call(TableColumn<Person, String> col) {
//		return new ColorPickerTableCell2(col);
//	}
//});

public class ColorPickerTableCell2<T> extends TableCell<T, String> {    
    
	private final ColorPicker colorPicker = new ColorPicker();
 
    public ColorPickerTableCell2(TableColumn<T, String> column) {
    	
    	this.colorPicker.editableProperty().bind(column.editableProperty());
    	this.colorPicker.disableProperty().bind(column.editableProperty().not());
    	this.colorPicker.setOnShowing( event -> {
    		TableView<T> tableView = getTableView();
    		tableView.getSelectionModel().select(getTableRow().getIndex());
    		tableView.edit(tableView.getSelectionModel().getSelectedIndex(), column);	    
    	});
    	this.colorPicker.valueProperty().addListener( (observable, oldValue, newValue) -> {
    		if(isEditing()) {
    			commitEdit(newValue.toString());
    		}
    	});	
    	setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
 
    @Override
    protected void updateItem(String item, boolean empty) {
    	super.updateItem(item, empty);	
    	
    	setText(null);	
    	if(empty) {	    
    		setGraphic(null);
    	} else {	    
    		this.colorPicker.setValue(Color.valueOf(item));
    		this.setGraphic(this.colorPicker);
    	} 
    }
}