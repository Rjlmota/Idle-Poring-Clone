package characters.monsterTypes;

import characters.Monster;


public class Boss extends Monster {
	
	int[] aux = {3, 3, 3, 3, 3, 3};
	
	public Boss(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(attr);
		this.base_attr = aux;
		updateStats();
	}
}