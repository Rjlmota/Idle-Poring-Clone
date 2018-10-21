package items;

import characters.Attributes;

public class Item extends Attributes{

	public String name;
	public String id;
	public String description;
	
	public Item(String name, String id) {
		this.name = name;
		this.id = id;
		setRandomAttributes(0, 10);
	}
	
}
