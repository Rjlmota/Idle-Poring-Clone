package characters;

import java.util.Map;

import items.Equipment;

public class Slot {
	
	private final String[] index = { "str", "agi", "vit", "int", "dex", "luk", "power" };
	
	private Equipment equipment;
	private int level;
	
	public Slot() {
		this.equipment = null;
		this.level = 1;
	}
	
	public Equipment getEquipment() {
		Equipment equip = this.equipment;
		return equip;
	}
	
	public void setEquipment(Equipment equip) {
		this.equipment = equip;
	}
	
	public int getLevel() {
		return this.level;
	}

	public void levelUp() {
		Map<String,Integer> attr = this.equipment.attr.getAttributes();
		int[] up = {0, 0, 0, 0, 0, 0};
		for (int i=0; i<6; i++) {
			up[i] = 2*attr.get(index[i]);
		}
		this.equipment.attr.setAttributes(up);
		this.level += 1;
	}
	
}
