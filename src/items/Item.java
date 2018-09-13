package items;

public abstract class Item {

	
	String name;
	String description;
	String type;
	
	
	
	public void Use(Character Player) {
	//Function to update character's stats according to Items specifications
	}
	
	
	public Item(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
}
