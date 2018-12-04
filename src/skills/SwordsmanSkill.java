package skills;

public class SwordsmanSkill {
// nome - dano - cd - acc - tipo 
	public static Active generate(String name) {
		if (name.equalsIgnoreCase("Slash")) {
			return new Active("Slash", 300, 4, 1, "physical");
		}

		if (name.equalsIgnoreCase("Strike")) {
			return new Active("Strike", 50, 2, 0.8, "physical");
		}

		return null;
	}

	// String name, int buff, int duration, String stat, int cooldown_sec
	public static Buff generateBuff(String name) {
		if (name.equalsIgnoreCase("Burning")) {
			return new Buff("Burning Sword", 30, 3, "def", 6);
		}

		return null;
	}

}
