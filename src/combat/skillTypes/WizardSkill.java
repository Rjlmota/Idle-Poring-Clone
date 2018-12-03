package combat.skillTypes;

import combat.Active;
import combat.Buff;
import combat.Skill;

public class WizardSkill {
// nome - dano - cd - acc - tipo 
	public static Active generate(String name) {
		if(name.equalsIgnoreCase("fireball")) {
			return new Active("Fireball", 200, 10, 1, "magical");
		}
		
		if(name.equalsIgnoreCase("iceShards")) {
			return new Active("Shards of Ice", 100, 5, 0.8, "magical");
		}
		
		return null;
	}
	
	//String name, int buff, int duration, String stat, int cooldown_sec
	public static Buff generateBuff(String name) {
		if(name.equalsIgnoreCase("Wisdom")) {
			return new Buff("Wisdom", 20, 6, "int", 10);
		}
		
		return null;
	}

	
}
