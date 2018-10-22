package characters;

import characters.Attributes;

public abstract class Character extends Attributes{
	
	public String name;
	
	public int level;
	
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
	
	public Character(String name) {
		this.name = name;
		this.level = 1;
		setAttributes(9, 9, 9, 9, 9, 9);
	}
	
	public void updateAttributes(int dominant, int[] equips) {
		
		this.str += equips[0];
		this.agi += equips[1];
		this.vit += equips[2];
		this.inte += equips[3];
		this.dex += equips[4];
		this.luck += equips[5];
		
		this.power += equips[6];
		
		this.maxHp = (2*this.str) + (16*this.vit) + dominant;
		this.currentHp = this.maxHp;			
		this.maxSp = (8*this.inte) + dominant;
		this.currentSp = this.maxSp;
		
		this.atk = (2*this.str) + (2*this.dex) + dominant;
		this.def = (2*this.vit) + (this.dex) + dominant;
		this.atkM = (3*this.inte) + dominant;
		this.defM = (2*this.vit) + (this.inte) + dominant;
		this.hit = (2*this.dex) + (this.luck) + dominant;
		this.evasion = (2*this.agi) + (this.luck);
		this.critic = (2*this.luck) + (this.dex);
		this.atkSpeed = (2*this.agi);
		this.tenacity = (2*this.vit);
		this.cast = 0;
	}
	
}
