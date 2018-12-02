package characters;

import java.util.ArrayList;

import items.Item;

public class Monster extends Entity {

	//public Attributes attr;
	//public Stats stats;
	
	
	public ArrayList <Item> loot = new ArrayList<Item>();
	
	
	
	public Monster(String name) {
		super(name);
		
		// TODO Auto-generated constructor stub
		}
		
	@Override
	public ArrayList <Item> handleLoot(){
		ArrayList <Item> drop = new ArrayList<Item>();
		for(Item item : loot) {
			if(item.dropRate > Math.random()*1 + 0) {
				drop.add(item);
			}
		}
		return drop;
	}


}


