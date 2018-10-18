package items;
import characters.Attributes;

public class Item {

	public String name;
	public String id;
	public Attributes attributes;
	public String description;
	
	public Item(String name, String id) {
		this.name = name;
		this.id = id;
		this.attributes = new Attributes();
	}
	
}
