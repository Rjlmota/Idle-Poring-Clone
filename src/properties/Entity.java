package properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import characters.Bag;
import characters.Slot;
import skills.Active;
import skills.Buff;
import skills.Skill;
import items.Equipment;
import items.Item;

public abstract class Entity {

	protected String name;
	protected int level;
	protected float exp;

	public String status;
	public Bag bag = new Bag();
	public Attributes attr = new Attributes();
	public Stats stats = new Stats();


	public Map<String, Slot> equips = new HashMap<String, Slot>();
	public ArrayList<Skill> skillList = new ArrayList<Skill>();
	//public ArrayList<Buff> buff_list = new ArrayList<Buff>();
	
	
	//String name, int damage, int cooldown_sec, double accuracy, String type
	public Skill auto_attack = new Active("Auto Attack", 50, 1, 1, "physical");

	private final String[] index = { "str", "agi", "vit", "int", "dex", "luk", "power" };
    private final String[] ref = {"Weapon", "Helmet", "BodyArmor", "LegArmor", "Gloves", "Boots", "Necklace", "Ring"};

	public Entity(String name) {
		this.name = name;
		this.level = 1;
		this.exp = 0;
		for (int i=0; i<8; i++) {
			equips.put(ref[i], new Slot());
		}
		
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
		Map<String,Integer> equips_attr = getEquipAttributes();
		Map<String,Integer> stats = new HashMap<String,Integer>();

		for (String key : attr.keySet()) {
			stats.put(key, attr.get(key) + equips_attr.get(key));
		}

		this.stats.setStats(stats);
	}

	public Map<String, Integer> getEquipAttributes() {
		Map<String, Integer> equip;
		Map<String, Integer> total = new HashMap<String, Integer>();

		for (int i = 0; i < 7; i++) {
			total.put(index[i], 0);
		}

		for (Slot slot : equips.values()) {
			if (slot.getEquipment() != null) {
				equip = slot.getEquipment().attr.getAttributes();
				for (String key : total.keySet()) {
					total.put(key, total.get(key) + equip.get(key));
				}
		
			}
		}
		return total;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
		
	public float getExp() {
		return this.exp;
	}
	
	//Overwritten by subclass.
	public void handleLoot(Equipment loot) {}
	public Equipment handleLoot() {return null;}
	public void handleLoot(Item loot) {}
	public Item handleloot() {return null;}

}
