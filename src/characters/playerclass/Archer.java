package characters.playerclass;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import characters.Bag;
import characters.Entity;


public class Archer extends Entity{
	
	//To DO: extend equipments.
	public Item[] equipments = new Item[8];
	
	public Bag bag = new Bag();
	
	private String[] index = {"str", "agi", "vit", "int", "dex", "luk", "power"};
	
	public Archer(String name) {
		super(name);
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		updateClass();
	}

	public void updateClass() {
		Map<String,Integer> attr = this.attr.getAttributes();
		Map<String,Integer> equips = getEquipAttributes();
		Map<String,Integer> stats = new HashMap<String,Integer>();
		
		for (String key : attr.keySet()) {
		    stats.put(key, attr.get(key) + equips.get(key));			
		}
		
		this.stats.setStats(stats);
	}
	
	public Map<String,Integer> getEquipAttributes() {
		Map<String,Integer> equip ;
		Map<String,Integer> total = new HashMap<String,Integer>();
		
		for (int i=0; i<7; i++) {
		    total.put(index[i], 0);
		}

		for (int i=0; i<8; i++) {
			equip = this.equipments[i].attr.getAttributes();
			for (String key : total.keySet()) {
				total.put(key, total.get(key) + equip.get(key));		
			}
		}
		return total;
	}
	
	@Override
	public void handleLoot(ArrayList <Item> loot) {
		for(Item item : loot) {
			bag.addItem(item);
		}
	}
	
	
}
