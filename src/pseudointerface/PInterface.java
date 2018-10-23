package pseudointerface;
import characters.Class;
import characters.Monster;
import items.Item;

public abstract class PInterface {
	
	public static void showAttributes(Class player) {
		
		System.out.println("\nName: " + player.name);
		System.out.println("Level: " + player.level);
		System.out.println("Power: " + player.power);
		
		System.out.println("Max Hp: " + player.maxHp + " | Hp: " + player.currentHp);
		System.out.println("Max Sp: " + player.maxSp + " | Sp: " + player.currentSp);
		
		System.out.println("Strength: " + (player.str + player.equipsAttributes[0]));
		System.out.println("Agility: " + (player.agi + player.equipsAttributes[1]));
		System.out.println("Vitality: " + (player.vit + player.equipsAttributes[2]));
		System.out.println("Intelligence: " + (player.inte + player.equipsAttributes[3]));
		System.out.println("Dexterity: " + (player.dex + player.equipsAttributes[4]));
		System.out.println("Luck: " + (player.luck + player.equipsAttributes[5]));
		
		System.out.println("Attack: " + player.atk);
		System.out.println("Defense: " + player.def);
		System.out.println("Magical Attack: " + player.atkM);
		System.out.println("Magical Defense: " + player.defM);
		System.out.println("Hit: " + player.hit);
		System.out.println("Evasion: " + player.evasion);
		System.out.println("Critic: " + player.critic);
		System.out.println("Attack Speed: " + player.atkSpeed);
		System.out.println("Tenacity: " + player.tenacity);
		System.out.println("Cast: " + player.cast);
	}
	
	public static void showAttributes(Monster monster) {
		
		System.out.println("\nName: " + monster.name);
		System.out.println("Level: " + monster.level);
		
		System.out.println("Max Hp: " + monster.maxHp + " | Hp: " + monster.currentHp);
		System.out.println("Max Sp: " + monster.maxSp + " | Sp: " + monster.currentSp);
		
		System.out.println("Strength: " + monster.str);
		System.out.println("Agility: " + monster.agi);
		System.out.println("Vitality: " + monster.vit);
		System.out.println("Intelligence: " + monster.inte);
		System.out.println("Dexterity: " + monster.dex);
		System.out.println("Luck: " + monster.luck);
		
		System.out.println("Attack: " + monster.atk);
		System.out.println("Defense: " + monster.def);
		System.out.println("Magical Attack: " + monster.atkM);
		System.out.println("Magical Defense: " + monster.defM);
		System.out.println("Hit: " + monster.hit);
		System.out.println("Evasion: " + monster.evasion);
		System.out.println("Critic: " + monster.critic);
		System.out.println("Attack Speed: " + monster.atkSpeed);
		System.out.println("Tenacity: " + monster.tenacity);
		System.out.println("Cast: " + monster.cast);
	}
	
	public static void showAttributes(Item item) {
		
		System.out.println("\nName: " + item.name);
		System.out.println("Power: " + item.power);
		
		System.out.println("Strength: " + item.str);
		System.out.println("Agility: " + item.agi);
		System.out.println("Vitality: " + item.vit);
		System.out.println("Intelligence: " + item.inte);
		System.out.println("Dexterity: " + item.dex);
		System.out.println("Luck: " + item.luck);
	}
	
}
