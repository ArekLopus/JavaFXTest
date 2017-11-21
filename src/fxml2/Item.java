package fxml2;

public class Item {
    private Long id;
    private String name;
    
    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    //To copy an object, the class must provide a copy constructor. A copy constructor takes an object of the same class.
    public Item(Item source) {
        this.id = source.id;
        this.name = source.name+", copied";
    }
    
    
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
    
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }
}