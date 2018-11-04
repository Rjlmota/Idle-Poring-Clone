package pseudointerface;

public abstract class Show {
	
	public static void damage(String atk, int atk_hp, String def, int def_hp, int damage) {
		if (def_hp < 0) {
			def_hp = 0;
		}
		System.out.println(atk + " dealt " + damage + " to " + def);
		System.out.println(atk + "\n\tCurrent HP: " + atk_hp);
		System.out.println(def + "\n\tCurrent HP: " + def_hp);
	}
	
}
