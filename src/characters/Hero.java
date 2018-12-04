package characters;

import items.Equipment;
import items.EquipmentFactory;
import items.Item;
import properties.Entity;
import pseudointerface.HeroInterface;

public class Hero extends Entity{

	public Bag bag = new Bag();
	
	public Hero(String name) {
		super(name);
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (String type : this.equips.keySet()) {
			if (type.equalsIgnoreCase("Weapon")) {
				equips.get(type).setEquipment(EquipmentFactory.getEquipmentByType("Sword", this.level));
			}else {
				equips.get(type).setEquipment(EquipmentFactory.getEquipmentByType(type, this.level));
			}
		}
		
		updateStats();
	}
	
	@Override
	public void handleLoot(Equipment loot) {
		bag.addToBag(loot);
	}
	
	@Override
	public void handleLoot(Item loot) {
		bag.addToBag(loot);
	}
	
	public void gainExp(float exp) {
		this.exp += exp;
		
		if (this.exp>=100) {
			this.exp -= 100;
			int[] up = HeroInterface.levelUp();
			levelUp(up);
		}
		
	}
	
}
