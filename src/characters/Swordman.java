package characters;

import items.Item;

public class Swordman extends Character{

	public Item[] equipments = new Item[8];
	
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
	
	public Swordman(String name) {
		super(name);
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("Item " + Integer.toString(i), Integer.toString(i));
		}
		updateAttributes(equipsAttributes());
	}
	
	public void updateAttributes(int[] equips) {
		
		this.str += equips[0];
		this.agi += equips[1];
		this.vit += equips[2];
		this.inte += equips[3];
		this.dex += equips[4];
		this.luck += equips[5];
		
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

	public int[] equipsAttributes() {
		int[] equips = new int[6];
		
		for (int i=0; i<8; i++) {
				equips[0] += this.equipments[i].str;
				equips[1] += this.equipments[i].agi;
				equips[2] += this.equipments[i].vit;
				equips[3] += this.equipments[i].inte;
				equips[4] += this.equipments[i].dex;
				equips[5] += this.equipments[i].luck;
		}

		return equips;
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
