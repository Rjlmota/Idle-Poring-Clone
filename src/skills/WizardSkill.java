package skills;

public class WizardSkill {

	public static Active generate(String name) {
		if(name.equalsIgnoreCase("fireball")) {
			return new Active("Fireball", 200, 10, 1, "magical");
		}
		
		if(name.equalsIgnoreCase("iceShards")) {
			return new Active("Shards of Ice", 100, 5, 0.8, "magical");
		}
		
		return null;
	}
	
	public static Buff generateBuff(String name) {
		if(name.equalsIgnoreCase("Wisdom")) {
			return new Buff("Wisdom", 20, 2, "spd", 5);
		}
		
		return null;
	}

	
}
