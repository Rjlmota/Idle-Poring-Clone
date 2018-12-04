package characters;

import skills.Buff;
import skills.Skill;
import skills.SkillGenerator;


public class Wizard extends Hero{
	
	public Bag bag = new Bag();
		
	public Wizard(String name) {
		super(name);
		
		Skill startSkill = SkillGenerator.generateSkill("Wizard", "fireball");
		this.skillList.add(startSkill);
		
		Buff startBuff = SkillGenerator.generateBuff("Wizard", "Wisdom");
		this.buff_list.add(startBuff);
		
	}
	
}
