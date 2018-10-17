package characters;


//A Class designed to hold standard attributes for all characters from the game
public class Attributes {
	public int power;
	
	public int str;
	public int agi;
	public int vit;
	public int inte;
	public int dex;
	public int luck;

	public int maxHp;
	public int currentHp;
	public int maxSp;
	public int currentSp;
	
	public int atk;
	public int def;
	public int atkM;
	public int defM;
	public int hit;
	public int evasion;
	public int critic;
	public int atkSpeed;
	public int tenacity;
	public int cast;
		
	public Attributes(String id) {
		if (id.charAt(0) == '1') {
			this.str = 9;
			this.agi = 9;
			this.vit = 9;
			this.inte = 9;
			this.dex = 9;
			this.luck = 9;
		}
		upAttributes(id);
	}
	public void upAttributes(String id) {
		if (id.charAt(1) == '1') {
			this.maxHp = (4*this.str) + (16*this.vit);
			this.currentHp = this.maxHp;			
			this.maxSp = (8*this.inte);
			this.currentSp = this.maxSp;
			this.atk = (4*this.str);
			this.def = (2*this.vit) + (this.dex);
			this.atkM = 0;
			this.defM = (2*this.vit) + (this.inte);
			this.hit = (2*this.dex) + (this.luck);
			this.evasion = (2*this.agi) + (this.luck);
			this.critic = (2*this.luck);
			this.atkSpeed = (2*this.agi);
			this.tenacity = (2*this.vit);
			this.cast = 0;
		}
	}
	
	public void showAttributes() {
		System.out.println("Max Hp: " + this.maxHp + " | Hp: " + this.currentHp);
		System.out.println("Max Sp: " + this.maxSp + " | Sp: " + this.currentSp);
		System.out.println("Strength: " + this.str);
		System.out.println("Agility: " + this.agi);
		System.out.println("Vitality: " + this.vit);
		System.out.println("Intelligence: " + this.inte);
		System.out.println("Dexterity: " + this.dex);
		System.out.println("Luck: " + this.luck);
		System.out.println("Attack: " + this.atk);
		System.out.println("Defense: " + this.def);
		System.out.println("Magical Attack: " + this.atkM);
		System.out.println("Magical Defense: " + this.defM);
		System.out.println("Hit: " + this.hit);
		System.out.println("Evasion: " + this.evasion);
		System.out.println("Critic: " + this.critic);
		System.out.println("Attack Speed: " + this.atkSpeed);
		System.out.println("Tenacity: " + this.tenacity);
		System.out.println("Cast: " + this.cast);
	}
	
}