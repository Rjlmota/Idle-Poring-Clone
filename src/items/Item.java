package items;

import properties.Attributes;

public class Item{

	public String name;
	public String id;
	public String description;
	public Attributes attr;
	public double dropRate;
	
	
	public Item(String id, String name) {
		this.name = name;
		this.attr = new Attributes();
		this.attr.setAttributes(0, 9);
	}
		
}
