package characters;
import items.Item;

public class Hero{
	
	public String name;
	public String id;
	public Attributes attributes;
	public Item[] equipments;
	
	
	public Hero(String id, String name) {
		this.name = name;
		this.id = id;
		this.attributes = new Attributes(9, 9, 9, 9, 9, 9);
		this.equipments = new Item[8];
		for (int i=0; i<8; i++) {
			this.equipments[i] = new Item();
		}
		this.attributes.upAttributes(equipsAttr());
	}
	
	public Attributes equipsAttr() {
		Attributes equips = new Attributes();
		
		for (int i=0; i<8; i++) {
				equips.str += this.equipments[i].attributes.str;
				equips.agi += this.equipments[i].attributes.str;
				equips.vit += this.equipments[i].attributes.str;
				equips.inte += this.equipments[i].attributes.str;
				equips.dex += this.equipments[i].attributes.str;
				equips.luck += this.equipments[i].attributes.str;
		}

		return equips;
	}
}
