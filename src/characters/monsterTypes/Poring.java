package characters.monsterTypes;

import characters.Monster;

public class Poring extends Monster{
	 public Poring(String name) {
		super(name);
		//str - agi - vit - int - dex - luck
		int[] attr = {7, 5, 10, 2, 4, 5};
		this.attr.setAttributes(attr);
	}
}
