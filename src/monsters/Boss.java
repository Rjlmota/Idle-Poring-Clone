package monsters;

import java.util.Random;

import items.Item;
import items.MiscFactory;

public class Boss extends Monster {
	
	int[] aux = {10, 10, 10, 10, 10, 10};
	
	public Boss(String name) {
		super(name);
		// str - agi - vit - int - dex - luck
		int[] attr = { 9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(attr);
		this.base_attr = aux;
		updateStats();
	}
	
	@Override
	public Item handleLoot(){
		Random rnd = new Random();
		if(rnd.nextInt(50) > 25) {
			return MiscFactory.getSingleItem("Fracom");
		}
		return null;
	}
	
}