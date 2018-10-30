package characters;

import java.util.ArrayList;

import items.Item;

public class Monster extends Character {
	
	public ArrayList <Item> loot = new ArrayList<Item>();
	int id; // Identifies the types of attributes distribution
			// 1- Poring, 2- Ogre, 3-Gnome
	
	
	double dice;
	Item chestplate = new Item ("Really Cool Chestplate", "2");
	Item sword = new Item("Really Cool Sword", "1");
	Item boots = new Item("BoOtS", "3");
	public Monster(String name, int id){
		super(name);
		setRandomAttributes(9, 40);
		updateAttributes();
		this.id = id;
		
		//The id variable will determine the initial distribution and due to the exponential
		//nature of the leveling system, the proportion should stay stable without much programming intervention.
		
		if(id == 1) {
			this.str = 5;
			this.agi = 9;
			this.vit = 5;
			this.inte = 3;
			this.dex = 3;
			this.luck = 5;
			
			
			dice = Math.random()*1 + 0;
			
			if (dice > 0.5)
				loot.add(sword);
			
			
		}
		
		if(id == 2) {
			this.str = 8;
			this.agi = 3;
			this.vit = 15;
			this.inte = 2;
			this.dex = 5;
			this.luck = 2;

			
			dice = Math.random()*1 + 0;

			
			if (dice > 0.5)
				loot.add(chestplate);
		
		}
		
		
		
	}
	
	
	
	
	//To DO: extend upLevel function to limit to 6 points per level.
	public void upLevel(int levels) {
		
		for(int i = 0; i < levels; i++) {
			this.level += 1;
			int str  = (int) Math.pow(this.str,  0.3);
			int agi  = (int) Math.pow(this.agi,  0.3);
			int vit  = (int) Math.pow(this.vit,  0.3);
			int inte = (int) Math.pow(this.inte, 0.3);
			int dex  = (int) Math.pow(this.dex,  0.3);
			int luck = (int) Math.pow(this.luck, 0.3);
			this.addAttributes(str, agi, vit, inte, dex, luck);
			this.updateAttributes();
		}
	}
	public boolean isDead() {
		if (this.currentHp > 0) 
			return false;
		return true;
	}
	
	public void reset() {
		this.currentHp = this.maxHp;
		
		dice = Math.random()*1 + 0;
		

		
		if (dice < 0.5) 
			this.loot.add(boots);
		else if(dice < 0.7)
			this.loot.add(chestplate);
		else if(dice < 0.9)
			this.loot.add(sword);
	}
	
}
