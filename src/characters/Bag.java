package characters;

import java.util.ArrayList;

import items.Equipment;
import items.Item;
import items.Misc;

public class Bag {
	
	private int maxCapacity;
	
	
	private ArrayList<Equipment> equipments = new ArrayList <Equipment>();
	private ArrayList <Misc> miscs = new ArrayList <Misc>();
	
	public Bag(){
		this.maxCapacity = 10;
	}
	
	public void addToBag(Item item) {
		
		if (item instanceof Equipment) {
			
			if (equipments.size() <= this.maxCapacity)
				equipments.add((Equipment)item);
		}else {
			
			int index = miscs.indexOf(item);
			if (index == -1) {
				miscs.add((Misc)item);
			}else {
				Misc misc_ = miscs.get(index);
				misc_.setQuantity(misc_.getQuantity() + 1);
			}
		}
	}
	
	public void addToBag(Equipment equipment) {

	}
	
	public void removeFromBag(Equipment equipment) {
		equipments.remove(equipment);
	}
	
	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	public ArrayList<Equipment> getEquipments(){
		ArrayList<Equipment> equipments_ = this.equipments;
		return equipments_;
	}
	
	public ArrayList<Misc> getItens(){
		ArrayList<Misc> itens_ = this.miscs;
		return itens_;
	}
	
}
