package skills;

public class ArcherSkill {
	public static Active generate(String name) {
		if(name.equalsIgnoreCase("ChargedArrow")) {
			return new Active("Charged Arrow", 250, 6, 1, "physical");
		}
		
		if(name.equalsIgnoreCase("Swift")) {
			return new Active("SwiftStrike", 100, 2, 0.8, "physical");
		}
		
		return null;
	}
	
	public static Buff generateBuff(String name) {
		if(name.equalsIgnoreCase("Blessing")) {
			return new Buff("Blessing", 20, 2, "atk", 8);
		}
		
		return null;
	}

	
}
