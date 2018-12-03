package combat.skillTypes;

import combat.Active;
import combat.Buff;
import combat.Skill;

public class ArcherSkill {
// nome - dano - cd - acc - tipo 
	public static Active generate(String name) {
		if(name.equalsIgnoreCase("ChargedArrow")) {
			return new Active("Charged Arrow", 250, 6, 1, "physical");
		}
		
		if(name.equalsIgnoreCase("Swift")) {
			return new Active("SwiftStrike", 100, 2, 0.8, "physical");
		}
		
		return null;
	}
//String name, int buff, int duration, String stat, int cooldown_sec
	public static Buff generateBuff(String name) {
		if(name.equalsIgnoreCase("Blessing")) {
			return new Buff("Blessing", 20, 6, "dex", 10);
		}
		
		return null;
	}

	
}
