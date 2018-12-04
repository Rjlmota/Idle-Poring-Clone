package monsters;

public class Ogre extends Monster {
	
	int [] aux = {4, 2, 6, 2, 4, 2};
	public Ogre(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 12, 3, 15, 1, 6, 3 };
		this.attr.setAttributes(attr);
		this.base_attr =aux;
		updateStats();
	}
}