package items;

public abstract class Item {

	
	public String name;
	public String description;
	public String type;
	public int id;
	
	
	public void Use(Character Player) {
	//Function to update character's stats according to Items specifications
	}
	
	
	public Item(String name, String type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
}
