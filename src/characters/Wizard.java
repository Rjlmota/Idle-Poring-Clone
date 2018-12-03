package characters.playerclass;


import java.util.ArrayList;
import items.Item;
import characters.Bag;
import characters.Entity;
import combat.Buff;
import combat.Skill;
import combat.SkillGenerator;


public class Wizard extends Entity{
	
	public Bag bag = new Bag();
		
	public Wizard(String name) {
		super(name);
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		Skill startSkill = SkillGenerator.generateSkill("Wizard", "fireball");
		this.skillList.add(startSkill);
		
		Buff startBuff = SkillGenerator.generateBuff("Wizard", "Wisdom");
		this.buff_list.add(startBuff);
		
		updateStats();
	}
	
	@Override
	public void handleLoot(ArrayList <Item> loot) {
		for(Item item : loot) {
			bag.addItem(item);
		}
	}
	
	
}
