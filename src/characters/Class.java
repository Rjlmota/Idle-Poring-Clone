package characters;

import items.Item;
import properties.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Class extends Entity{
	

	
	
	public Bag bag = new Bag();
	
	public String id; // 1-Swordsman; 2-Wizard; 3-Archer

	
	public Class(String name, String id) {
		super(name);
		this.id = id;
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		updateClass();
	}

	
	public void collectLoot(ArrayList <Item> loot) {
		for(Item item : loot) {
			bag.addItem(item);
		}
	}
	
	
}
