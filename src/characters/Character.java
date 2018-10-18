package characters;

import java.util.*;
import items.*;
import characters.Attributes;

public abstract class Character {
	
	public String status = "free";
	public Attributes attributes;
	public String name;
	int level = 1;
	public int hp;
	public Bag bag = new Bag();
	public Character(String id, String name) { 
		this.attributes = new Attributes();
		this.name = name;
		this.hp = attributes.maxHp;
	}
	
	public void updateHp(int damage){
		this.hp += damage;
		if (this.hp < 0) {
			this.hp = 0;
		}
	}
	
	public class Bag{
		int capacity = 40;
		int used = 0;
		ArrayList<Item> items = new ArrayList <Item>();
		
		
		public void addItem(Item item){
			if(used < capacity) {
				items.add(item);
				used++;
			}
		}
		
		public void delItem(Item item) {
			for(Item i : items) {
				if (i.id == item.id) {
					items.remove(i);
				}
			}
			
		}
		
		public void list() {
			for(Item i : items) {
				System.out.println("Name: " + i.name);
				System.out.println("Description: " + i.description);
			}
		}
		public Bag() {
			
		}
}
	
	
	public void upLevel(int level){
		this.level += level;
		this.attributes.atk += this.level*2;
		this.attributes.hit += (int)this.level*1.5;
		this.hp += this.level*3;
		this.attributes.evasion += this.level*2;
	}

	
	public boolean isDead() {
		if(this.hp <= 0)
			return true;
		else
			return false;
	}
	
	
	public Attributes getAttributes() {
		return this.attributes;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	

}
