package monsters;


public class GuardPoring extends Monster {
	
	int[] aux = {3, 1, 3, 2, 2, 2};
	
	public GuardPoring(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 8, 3, 12, 3, 6, 7 };
		this.attr.setAttributes(attr);
		this.base_attr = aux;
		updateStats();
	}
}