package characters;

import java.util.ArrayList;
import properties.*;
import items.Item;

public class MonsterOld extends Entity {
	public Attributes attr;
	public Stats stats;
	
	public ArrayList <Item> loot = new ArrayList<Item>();
	int id; // Identifies the types of attributes distribution
			// 1- Poring, 2- Ogre, 3-Gnome
	
	Item chestplate = new Item ("1", "Really Cool Chestplate");
	Item sword = new Item("2", "Really Cool Sword");
	Item boots = new Item("3", "BoOtS");
	
	
	public MonsterOld(String name, int id){
		super(name);
		this.attr = new Attributes();
		this.stats = new Stats();
		this.id = id;
		//The id variable will determine the initial distribution and due to the exponential
		//nature of the leveling system, the proportion should stay stable without much programming intervention.
		if(id == 1) {
			int[] aux = {5, 9, 5, 3, 3, 5};
			this.attr.setAttributes(aux);
			double dice = Math.random()*1 + 0;
			if (dice > 0.5)
				loot.add(sword);
		}
		else if(id == 2) {
			int[] aux = {8, 3, 15, 2, 5, 2};
			this.attr.setAttributes(aux);
			double dice = Math.random()*1 + 0;
			if (dice > 0.5)
				loot.add(chestplate);
		}else {
			this.attr.setAttributes(9, 40);
		}
		this.stats.setStats(this.attr.getAttributes());
		
	}
	
	//To DO: extend upLevel function to limit to 6 points per level.
		
}
