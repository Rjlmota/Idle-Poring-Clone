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
		updateAttributes(this.str, equipsAttributes());
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
		updateAttributes(this.str, equipsAttributes());
	}
	
}
