package pseudointerface;

public abstract class CombatInterface {
	
	public static void showDamage(String name, int damage, boolean crit) {
		if (crit) {
			System.out.println(name + " dealt " + damage + " critic damage!");
		}else {
			System.out.println(name + " dealt " + damage + " of damage.");
		}

	}
	
	public static void showCurrentLife(String atk_name, int atk_hp, String def_name, int def_hp) {
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
	
	public static void showExpGain(String name, float exp) {
		System.out.println(name + " gained " + exp + " experience.");
	}
	
}
