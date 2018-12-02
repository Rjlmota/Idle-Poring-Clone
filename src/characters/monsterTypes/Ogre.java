package characters.monsterTypes;

import characters.Monster;

public class Ogre extends Monster {
	
	int [] aux = {2, 1, 3, 1, 2, 1};
	public Ogre(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 12, 3, 15, 1, 6, 3 };
		this.attr.setAttributes(attr);
		this.base_attr =aux;
		updateStats();
	}
}