package characters;

import java.util.*;
import items.*;


public class Character extends Entity{
	

	public class Bag{
		int capacity = 40;
		int usage = 0;
		ArrayList<Item> items = new ArrayList <Item>();
		
		
		public void addItem(Item item){
			if(usage < capacity) {
				items.add(item);
				usage++;
			}
		}
		
		public void deleteItem(Item item) {
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
	
	
	public Bag bag;
	
	public Character(String name, String gender) {
		super(name);
		this.gender = gender;
		this.bag = new Bag();
		// TODO Auto-generated constructor stub
	}

	
	
	String nickname;
	String gender;
	int currentXP;
	
	
	
	
	
	

}
