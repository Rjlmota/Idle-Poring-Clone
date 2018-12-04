package characters;

import java.util.ArrayList;

import items.Equipment;
import items.Item;

public class Bag {
	
	private int maxCapacity;
	
	
	private ArrayList<Equipment> equipments = new ArrayList <Equipment>();
	private ArrayList <Item> itens = new ArrayList <Item>();
	
	public Bag(){
		this.maxCapacity = 10;
	}
	
	public void addToBag(Item item) {
		itens.add(item);
	}
	
	public void addToBag(Equipment equipment) {
		if (equipments.size() <= this.maxCapacity)
			equipments.add(equipment);
	}

	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	public ArrayList<Equipment> getEquipments(){
		ArrayList<Equipment> equipments_ = this.equipments;
		return equipments_;
	}
	
	public ArrayList<Item> getItens(){
		ArrayList<Item> itens_ = this.itens;
		return itens_;
	}
	
}
