package characters;

import java.util.ArrayList;

import items.Item;

public class Bag {
	
	int maxCapacity;
	int currentUsage;
	
	
	ArrayList <Item> equipments = new ArrayList <Item>(); 
	ArrayList <Item> consumables = new ArrayList <Item>();
	ArrayList <Item> misc = new ArrayList <Item>();
	
	
	
	
	private void updateUsage(){
		currentUsage = equipments.size() + consumables.size() + misc.size();
	}
	
	
	public boolean isFull(){
		
		updateUsage();
		if(currentUsage > maxCapacity)
			return true;
		return false;
	}
	
	
	public void showBag(){
		System.out.println("EQUIPMENT:");
		for(int i = 0; i < equipments.size(); i++)
			System.out.println(equipments.get(i).name);
		
		System.out.println("Consumables");
		for(int i = 0; i < consumables.size(); i++)
			System.out.println(consumables.get(i).name);
		
		for(int i = 0; i < misc.size(); i++)
			System.out.println(misc.get(i).name);
	}
	
	
	public void addItem(Item item) {
		if(item.type.equalsIgnoreCase("equipment"))
			equipments.add(item);
		else if(item.type.equalsIgnoreCase("consumable"))
			consumables.add(item);
		else if(item.type.equalsIgnoreCase("misc"))
			misc.add(item);
	}
	
	public Bag(){
		
	}
	

}
