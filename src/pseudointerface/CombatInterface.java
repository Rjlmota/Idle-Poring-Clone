package pseudointerface;

public abstract class CombatInterface {
	
	public static void damage(String atk_name, String def_name, int damage) {
		System.out.println(atk_name + " dealt " + damage + " to " + def_name);
	}
	
	public static void currentLife(String atk_name, int atk_hp, String def_name, int def_hp) {
		if (atk_hp < 0) {
			atk_hp = 0;
		}
		if (def_hp < 0) {
			def_hp = 0;
		}
		System.out.println();
		System.out.println(atk_name + " HP: " + atk_hp + " | " + def_name + " HP: " + def_hp);
		System.out.println();
	}
	
}
