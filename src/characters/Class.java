package characters;

import items.Item;

public class Class extends Character{
	
	//To DO: extend equipments.
	public Item[] equipments = new Item[8];
	public int[] equipsAttributes;
	public String id; // 1-Swordsman; 2-Wizard; 3-Archer
	
	public int power;
	
	public Class(String name, String id) {
		super(name);
		this.id = id;
		setAttributes(9, 9, 9, 9, 9, 9);
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("Item " + Integer.toString(i), Integer.toString(i));
		}
		this.equipsAttributes = getEquipsAttributes();
		updateClass();
	}

	public int[] getEquipsAttributes() {
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
	//To DO: extend upLevel function to limit to 6 points per level.
	public void upLevel(int str, int agi, int vit, int inte, int dex, int luck) {
		this.level += 1;
		this.addAttributes(str, agi, vit, inte, dex, luck);
		updateClass();
	}
	
	public void updateClass() {
		this.power = this.str + this.agi + this.vit + this.inte + this.dex + this.luck + equipsAttributes[6];
		if (this.id == "1") {
			updateAttributes(this.str, equipsAttributes);
		}else if (this.id == "2") {
			updateAttributes(this.inte, equipsAttributes);
		}else if (this.id == "3") {
			updateAttributes(this.dex, equipsAttributes);
		}
	}
}
