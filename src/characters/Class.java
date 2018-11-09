package characters;

import items.Item;
import properties.*;
import java.util.HashMap;
import java.util.Map;



public class Class extends Entity{
	
	//To DO: extend equipments.
	public Item[] equipments = new Item[8];
	
	public String id; // 1-Swordsman; 2-Wizard; 3-Archer
	
	public int power;
	
	private String[] index = {"str", "agi", "vit", "int", "dex", "luk", "power"};
	
	public Class(String name, String id) {
		super(name);
		this.id = id;
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i);
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
	
}
