package pseudointerface;
import monsters.Monster;
import properties.*;
import characters.*;
import items.Equipment;
import items.Misc;

import java.util.Map;

public abstract class DetailInterface {
	
	public static void showAttributes(Attributes attr_) {
		Map<String,Integer> attr = attr_.getAttributes();
		System.out.println("Attributes:");
		System.out.println("\tPower: " + attr.get("power"));
		System.out.println("\tStrenght: " + attr.get("str") + " | " + "Agility: " + attr.get("agi"));
		System.out.println("\tVitality: " + attr.get("vit") + " | " + "Intelligence: " + attr.get("int"));
		System.out.println("\tDexterity: " + attr.get("dex") + " | " + "Luck: " + attr.get("luk"));
		System.out.println();
	}
	
	public static void showStats(Stats stats_) {
		Map<String,Integer> stats = stats_.getStats();
		System.out.println("Stats:");
		System.out.println("\tHp: " + stats.get("hp") + " | " + "Sp: " + stats.get("sp"));
		System.out.println("\tAttack: " + stats.get("atk") + " | " + "Defense: " + stats.get("def"));
		System.out.println("\tMagic Attack: " + stats.get("atkM") + " | " + "Magic Defense: " + stats.get("defM"));
		System.out.println("\tHit: " + stats.get("hit") + " | " + "Evasion: " + stats.get("eva"));
		System.out.println("\tCritic: " + stats.get("crit") + " | " + "Speed: " + stats.get("spd"));
		System.out.println("\tTenacity: " + stats.get("ten") + " | " + "Cast: " + stats.get("cast"));
		System.out.println();
	}
	
	public static void showEntity(Entity entity) {
		System.out.println("Name: " + entity.getName() + " | " + "Level: " + entity.getLevel());
		showAttributes(entity.attr);
		showStats(entity.stats);
		for ( Slot slot : entity.equips.values()) {
			if (slot.getEquipment()!=null)
				showEquipment(slot.getEquipment());
		}
	}
	
	public static void showMonster(Monster monster) {
		System.out.println("Monster: " + monster.getName() + " | " + "Level: " + monster.getLevel());
		showAttributes(monster.attr);
		showStats(monster.stats);
	}
	
	public static void showEquipment(Equipment equip) {
		System.out.println(equip.getName() + " - " + equip.getType());
		showAttributes(equip.attr);
	}
	
	public static void showMisc(Misc misc) {
		System.out.println(misc.getName() + " x " + misc.getQuantity());
	}
	
}
