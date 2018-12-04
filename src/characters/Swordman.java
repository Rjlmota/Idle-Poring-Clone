package characters;

import skills.Buff;
import skills.Skill;
import skills.SkillGenerator;


public class Swordman extends Hero{
	
	
		
	public Swordman(String name) {
		super(name);
		
		Skill startSkill = SkillGenerator.generateSkill("Swordsman", "Slash");
		this.skillList.add(startSkill);
		
		Buff startBuff = SkillGenerator.generateBuff("Swordsman", "Burning");
		this.skillList.add(startBuff);
		
	}
}
