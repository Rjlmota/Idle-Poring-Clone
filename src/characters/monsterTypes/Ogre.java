package characters.monsterTypes;

import characters.Monster;

public class Ogre extends Monster{
	public Ogre(String name){
		super(name);
		//str - agi - vit - int - dex - luck
		int[] attr = {12, 3, 15, 1, 6, 3};
		this.attr.setAttributes(attr);
		updateStats();
	}
}