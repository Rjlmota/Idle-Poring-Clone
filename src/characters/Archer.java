package characters;

import java.util.ArrayList;
import items.Item;
import properties.Entity;
import skills.Buff;
import skills.Skill;
import skills.SkillGenerator;

public class Archer extends Entity {

	public Bag bag = new Bag();

	public Archer(String name) {
		super(name);
		int[] aux = { 9, 9, 9, 9, 9, 9 };
		this.attr.setAttributes(aux);

		for (int i = 0; i < 8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		
		Skill startSkill = SkillGenerator.generateSkill("Archer", "ChargedArrow");
		this.skillList.add(startSkill);
		
		Buff startBuff = SkillGenerator.generateBuff("Archer", "Blessing");
		this.buff_list.add(startBuff);
		
		updateStats();

	}
	
	@Override
	public void handleLoot(ArrayList<Item> loot) {
		for (Item item : loot) {
			bag.addItem(item);
		}
	}

}
