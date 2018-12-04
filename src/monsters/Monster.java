package monsters;

import java.util.ArrayList;
import java.util.Random;
import properties.Entity;
import items.Equipment;
import items.EquipmentFactory;

public class Monster extends Entity {

	
	public ArrayList <Equipment> loot = new ArrayList<Equipment>();
	
	protected int[] base_attr = new int[6];
	
	public Monster(String name) {
		super(name);
	}
		
	@Override
	public Equipment handleLoot(){
		Random rnd = new Random();
		if(rnd.nextInt(50) > 25) {
			return EquipmentFactory.getRandomEquipment(getLevel());
		}
		return null;
	}
	public void levelUpTo(int level) {
		for(int i = 0; i < level; i++)
			this.levelUp(base_attr);
	}
}