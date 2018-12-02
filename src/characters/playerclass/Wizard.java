package characters.playerclass;


import java.util.ArrayList;
import items.Item;
import characters.Bag;
import characters.Entity;


public class Wizard extends Entity{
	
	public Bag bag = new Bag();
		
	public Wizard(String name) {
		super(name);
		int[] aux = {9, 9, 9, 9, 9, 9};
		this.attr.setAttributes(aux);
		
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item("1", "Item" + i, "Equipment");
		}
		
		updateStats();
	}
	
	@Override
	public void handleLoot(ArrayList <Item> loot) {
		for(Item item : loot) {
			bag.addItem(item);
		}
	}
	
	
}
