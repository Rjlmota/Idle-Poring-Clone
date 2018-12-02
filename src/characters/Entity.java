package characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import combat.Buff;
import combat.Skill;
import items.Item;
import properties.*;

public abstract class Entity {

	public String name;

	public int level;
	public int power;
	
	public Attributes attr;
	public Stats stats;
	public String status;

	// private String status;

	// To DO: extend equipments.
	public Item[] equipments = new Item[8];


	public ArrayList<Skill> skillList = new ArrayList<Skill>();
	public ArrayList<Buff> buff_list = new ArrayList<Buff>();

	private String[] index = { "str", "agi", "vit", "int", "dex", "luk", "power" };

	public Entity(String name) {
		this.name = name;
		this.level = 1;
		this.attr = new Attributes();
		this.stats = new Stats();
	}
	
	public void levelUp(int[] up) {
		Map<String,Integer> attr = this.attr.getAttributes();
		for (int i=0; i<6; i++) {
			up[i] += attr.get(index[i]);
		}
		this.attr.setAttributes(up);
		updateStats();
		this.level += 1;
	}
	
	public void updateStats() {
		Map<String,Integer> attr = this.attr.getAttributes();
		Map<String,Integer> equips = getEquipAttributes();
		Map<String,Integer> stats = new HashMap<String,Integer>();

		for (String key : attr.keySet()) {
			stats.put(key, attr.get(key) + equips.get(key));
		}

		this.stats.setStats(stats);
	}

	public Map<String, Integer> getEquipAttributes() {
		Map<String, Integer> equip;
		Map<String, Integer> total = new HashMap<String, Integer>();

		for (int i = 0; i < 7; i++) {
			total.put(index[i], 0);
		}

		for (int i = 0; i < 8; i++) {
			if (equipments[i] == null)
				break;
			equip = this.equipments[i].attr.getAttributes();
			for (String key : total.keySet()) {
				total.put(key, total.get(key) + equip.get(key));
			}
		}
		return total;
	}
	
	//Overwritten by subclass.
	public void handleLoot(ArrayList<Item> loot) {}
	public ArrayList<Item> handleLoot() {return null;}

}
