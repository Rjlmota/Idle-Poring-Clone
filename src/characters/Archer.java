package characters;

import skills.Buff;
import skills.Skill;
import skills.SkillGenerator;

public class Archer extends Hero {

	public Bag bag = new Bag();

	public Archer(String name) {
		super(name);		
		
		Skill startSkill = SkillGenerator.generateSkill("Archer", "ChargedArrow");
		this.skillList.add(startSkill);
		
		Buff startBuff = SkillGenerator.generateBuff("Archer", "Blessing");
		this.skillList.add(startBuff);
		
	}
	
}
