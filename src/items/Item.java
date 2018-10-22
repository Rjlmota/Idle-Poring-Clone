package items;

import characters.Attributes;

public class Item extends Attributes{

	public String name;
	public String id;
	public String description;
	public int power;
	
	public Item(String name, String id) {
		this.name = name;
		this.id = id;
		setRandomAttributes(0, 10);
		this.power = this.str + this.agi + this.vit + this.inte + this.dex + this.luck;
	}
		
}
