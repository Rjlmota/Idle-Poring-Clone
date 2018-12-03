package monsters;

import java.util.ArrayList;

import properties.Entity;
import items.Item;

public class Monster extends Entity {

	//public Attributes attr;
	//public Stats stats;
	
	
	public ArrayList <Item> loot = new ArrayList<Item>();
	
	protected int[] base_attr = new int[6];
	
	public Monster(String name) {
		super(name);
		this.setExp(50);
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
	public void levelUpTo(int level) {
		for(int i = 0; i < level; i++)
			this.levelUp(base_attr);
	}
}