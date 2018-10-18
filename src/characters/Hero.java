package characters;
import items.Item;

public class Hero{
	
	public String name;
	public Attributes attributes;
	
	public Hero(String id, String name) {
		this.name = name;
		this.attributes = new Attributes(id);
	}
}
