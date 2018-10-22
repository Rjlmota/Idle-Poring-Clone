package characters;

import items.Item;

public class Swordman extends Character{
	
	public Item[] equipments = new Item[8];
	
	public int power;
	
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
		
		this.power += equips[6];
		
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
		int[] equips = new int[7];
		
		for (int i=0; i<8; i++) {
				equips[0] += this.equipments[i].str;
				equips[1] += this.equipments[i].agi;
				equips[2] += this.equipments[i].vit;
				equips[3] += this.equipments[i].inte;
				equips[4] += this.equipments[i].dex;
				equips[5] += this.equipments[i].luck;
				equips[6] += this.equipments[i].power;
		}

		return equips;
	}
	
	public void upLevel(int str, int agi, int vit, int inte, int dex, int luck) {
		this.level += 1;
		this.addAttributes(str, agi, vit, inte, dex, luck);
		updateAttributes(equipsAttributes());
	}
	
}
