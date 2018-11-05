package pseudointerface;
import properties.*;
import characters.*;
import characters.Class;
import items.Item;

public abstract class DetailInterface {
	
	public static void showAttributes(Attributes attr_) {
		int[] attr = attr_.getArrayAttributes();
		System.out.println("\nAttributes:");
		System.out.println("\tPower: " + attr[6]);
		System.out.println("\tStrenght: " + attr[0]);
		System.out.println("\tAgility: " + attr[1]);
		System.out.println("\tVitality: " + attr[2]);
		System.out.println("\tIntelligence: " + attr[3]);
		System.out.println("\tDexterity: " + attr[4]);
		System.out.println("\tLuck: " + attr[5]);
	}
	
	public static void showStats(Stats stats_) {
		int[] stats = stats_.getArrayStats();
		System.out.println("\nStats:");
		System.out.println("\tmaximum Hp: " + stats[0]);
		System.out.println("\tmaximum Sp: " + stats[1]);
		System.out.println("\tAttack: " + stats[2]);
		System.out.println("\tDefense: " + stats[3]);
		System.out.println("\tMagic Attack: " + stats[4]);
		System.out.println("\tMagic Defense: " + stats[5]);
		System.out.println("\tHit: " + stats[6]);
		System.out.println("\tEvasion: " + stats[7]);
		System.out.println("\tCritic: " + stats[8]);
		System.out.println("\tSpeed: " + stats[9]);
		System.out.println("\tTenacity: " + stats[10]);
		System.out.println("\tCast: " + stats[11]);
	}
	
	public static void showPlayer(Class player) {
		System.out.println("Player: " + player.name);
		System.out.println("Level: " + player.level);
		showAttributes(player.attr);
		showStats(player.stats);
		for (int i=0; i<8; i++) {
			showItem(player.equipments[i]);
		}
	}
	
	public static void showMonster(Monster monster) {
		System.out.println("Monster: " + monster.name);
		System.out.println("Level: " + monster.level);
		showAttributes(monster.attr);
		showStats(monster.stats);
	}
	
	public static void showItem(Item item) {
		System.out.println("\n" + item.name);
		showAttributes(item.attr);
	}
	
}
