package items;

import properties.Attributes;

public class Item{

	public String name;
	public String id;
	public String description;
	public Attributes attr;
	
	
	public Item(String name) {
		this.name = name;
		this.attr = new Attributes();
		this.attr.setAttributes(0, 9);
	}
		
}
