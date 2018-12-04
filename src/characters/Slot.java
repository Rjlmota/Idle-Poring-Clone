package characters;

import items.Equipment;

public class Slot {
	
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
	
}
