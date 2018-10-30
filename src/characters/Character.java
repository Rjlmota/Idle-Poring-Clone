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

	public String status;
	
	public Character(String name) {
		this.name = name;
		this.level = 1;
	}
	// For Monsters.
	public void updateAttributes() {
		
		int t_str = this.str;
		int t_agi = this.agi;
		int t_vit = this.vit;
		int t_inte = this.inte;
		int t_dex = this.dex;
		int t_luck = this.luck;
		
		this.maxHp = 2*(t_str) + (16*t_vit);
		this.currentHp = this.maxHp;			
		this.maxSp = (8*t_inte);
		this.currentSp = this.maxSp;
		
		this.atk = (2*t_str) + (2*t_dex);
		this.def = (2*t_vit) + (t_dex);
		this.atkM = (3*t_inte);
		this.defM = (2*t_vit) + (t_inte);
		this.hit = (2*t_dex) + (t_luck);
		this.evasion = (2*t_agi) + (t_luck);
		this.critic = (2*t_luck) + (t_dex);
		this.atkSpeed = (2*t_agi);
		this.tenacity = (2*t_vit);
		this.cast = 0;
	}
	// For Players.
	public void updateAttributes(int dominant, int[] equips) {
		
		int t_str = this.str + equips[0];
		int t_agi = this.agi + equips[1];
		int t_vit = this.vit + equips[2];
		int t_inte = this.inte + equips[3];
		int t_dex = this.dex + equips[4];
		int t_luck = this.luck + equips[5];
		
		this.power = this.str + this.agi + this.vit + this.inte + this.dex + this.luck + equips[6];
		
		this.maxHp = 2*(t_str) + (16*t_vit) + dominant;
		this.currentHp = this.maxHp;			
		this.maxSp = (8*t_inte) + dominant;
		this.currentSp = this.maxSp;
		
		this.atk = (2*t_str) + (2*t_dex) + dominant;
		this.def = (2*t_vit) + (t_dex) + dominant;
		this.atkM = (3*t_inte) + dominant;
		this.defM = (2*t_vit) + (t_inte) + dominant;
		this.hit = (2*t_dex) + (t_luck) + dominant;
		this.evasion = (2*t_agi) + (t_luck);
		this.critic = (2*t_luck) + (t_dex);
		this.atkSpeed = (2*t_agi);
		this.tenacity = (2*t_vit);
		this.cast = 0;
	}
	
	
	public boolean isDead() {
		if(this.currentHp > 0)
			return false;
		return true;
	}
	
}
