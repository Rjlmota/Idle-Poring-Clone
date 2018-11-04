package characters;

import items.Item;

public class Class extends Entity{
	
	//To DO: extend equipments.
	public Item[] equipments = new Item[8];
	
	public String id; // 1-Swordsman; 2-Wizard; 3-Archer
	
	public int power;
	
	public Class(String name, String id) {
		super(name);
		this.id = id;
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("Item" + i);
		}
		
		updateClass();
	}

	public void updateClass() {
		int[] attr = this.attr.getArrayAttributes();
		int[] equips = getArrayEquipAttributes();
		int[] stats = new int[6];
		
		for (int i=0; i<6; i++) {
			stats[i] = attr[i] + equips[i];
		}
		
		this.stats.setStats(stats);
	}
	
	public int[] getArrayEquipAttributes() {
		int[] total = {0, 0, 0, 0, 0, 0};
		int[] equip = new int[6];
		for (int i=0; i<8; i++) {
			equip = this.equipments[i].attr.getArrayAttributes();
			for (int j=0; j<6; j++) {
				total[j] += equip[j];
			}
		}
		return total;
	}
	
}
