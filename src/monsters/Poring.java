package characters.monsterTypes;

import characters.Monster;


public class Poring extends Monster {
	
	int[] aux = {2, 1, 3, 1, 2, 1};
	
	public Poring(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 7, 5, 10, 2, 4, 5 };
		this.attr.setAttributes(attr);
		this.base_attr = aux;
		updateStats();
	}
}
