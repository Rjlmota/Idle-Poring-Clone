package characters;

import java.util.ArrayList;

import items.Item;
import properties.Attributes;
import properties.Stats;

public class Monster extends Entity {

	public Attributes attr;
	public Stats stats;
	
	
	public ArrayList <Item> loot = new ArrayList<Item>();
	
	public Monster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}



class Poring extends Monster{
	 Poring(String name) {
		 
		 
		super(name);
		//str - agi - vit - int - dex - luck
		int[] attr = {7, 5, 10, 2, 4, 5};
		this.attr.setAttributes(attr);
	}
}

class Ogre extends Monster{
	Ogre(String name){
		super(name);
		//str - agi - vit - int - dex - luck
		int[] attr = {12, 3, 15, 1, 6, 3};
		this.attr.setAttributes(attr);
	}
}