package pseudointerface;
import characters.Swordman;

public abstract class Pseudointerface {
	
	public static void showCharacterAttributes(Swordman character) {
		System.out.println("Level: " + character.level);
		System.out.println("Power: " + character.power);
		System.out.println("Max Hp: " + character.maxHp + " | Hp: " + character.currentHp);
		System.out.println("Max Sp: " + character.maxSp + " | Sp: " + character.currentSp);
		System.out.println("Strength: " + character.str);
		System.out.println("Agility: " + character.agi);
		System.out.println("Vitality: " + character.vit);
		System.out.println("Intelligence: " + character.inte);
		System.out.println("Dexterity: " + character.dex);
		System.out.println("Luck: " + character.luck);
		System.out.println("Attack: " + character.atk);
		System.out.println("Defense: " + character.def);
		System.out.println("Magical Attack: " + character.atkM);
		System.out.println("Magical Defense: " + character.defM);
		System.out.println("Hit: " + character.hit);
		System.out.println("Evasion: " + character.evasion);
		System.out.println("Critic: " + character.critic);
		System.out.println("Attack Speed: " + character.atkSpeed);
		System.out.println("Tenacity: " + character.tenacity);
		System.out.println("Cast: " + character.cast);
	}
	
}
