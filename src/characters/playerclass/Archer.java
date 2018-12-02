package characters.playerclass;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import characters.Bag;
import characters.Entity;


public class Archer extends Entity{
	

	
	public Bag bag = new Bag();
	
	//private String[] index = {"str", "agi", "vit", "int", "dex", "luk", "power"};

	public String id; // 1-Swordsman; 2-Wizard; 3-Archer
	
	public Archer(String name) {
		super(name);
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		updateClass();
	}

	
	@Override
	public void handleLoot(ArrayList <Item> loot) {
		for(Item item : loot) {
			bag.addItem(item);
		}
	}
	
	
}
