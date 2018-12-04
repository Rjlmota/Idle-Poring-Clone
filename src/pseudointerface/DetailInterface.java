package pseudointerface;
import monsters.Monster;
import properties.*;
import characters.*;
import items.Equipment;
import java.util.Map;

public abstract class DetailInterface {
	
	public static void showAttributes(Attributes attr_) {
		Map<String,Integer> attr = attr_.getAttributes();
		System.out.println("\nAttributes:");
		System.out.println("\tPower: " + attr.get("power"));
		System.out.println("\tStrenght: " + attr.get("str"));
		System.out.println("\tAgility: " + attr.get("agi"));
		System.out.println("\tVitality: " + attr.get("vit"));
		System.out.println("\tIntelligence: " + attr.get("int"));
		System.out.println("\tDexterity: " + attr.get("dex"));
		System.out.println("\tLuck: " + attr.get("luk"));
	}
	
	public static void showStats(Stats stats_) {
		Map<String,Integer> stats = stats_.getStats();
		System.out.println("\nStats:");
		System.out.println("\tHp: " + stats.get("hp"));
		System.out.println("\tSp: " + stats.get("sp"));
		System.out.println("\tAttack: " + stats.get("atk"));
		System.out.println("\tDefense: " + stats.get("def"));
		System.out.println("\tMagic Attack: " + stats.get("atkM"));
		System.out.println("\tMagic Defense: " + stats.get("defM"));
		System.out.println("\tHit: " + stats.get("hit"));
		System.out.println("\tEvasion: " + stats.get("eva"));
		System.out.println("\tCritic: " + stats.get("crit"));
		System.out.println("\tSpeed: " + stats.get("spd"));
		System.out.println("\tTenacity: " + stats.get("ten"));
		System.out.println("\tCast: " + stats.get("cast"));
	}
	
	public static void showPlayer(Entity player) {
		System.out.println("Player: " + player.getName());
		System.out.println("Level: " + player.getLevel());
		showAttributes(player.attr);
		showStats(player.stats);
		for ( Slot slot : player.equips.values()) {
			if (slot.getEquipment()!=null)
				showEquipment(slot.getEquipment());
		}
	}
	
	public static void showMonster(Monster monster) {
		System.out.println("Monster: " + monster.getName());
		System.out.println("Level: " + monster.getLevel());
		showAttributes(monster.attr);
		showStats(monster.stats);
	}
	
	public static void showEquipment(Equipment equip) {
		System.out.println("\n" + equip.getName() + " - " + equip.getType());
		showAttributes(equip.attr);
	}
	
}
