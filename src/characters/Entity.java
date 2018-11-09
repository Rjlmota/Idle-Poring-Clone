package characters;
import properties.*;

public abstract class Entity {
	
	public String name;
	
	public int level;
	
	public Attributes attr;
	public Stats stats;
	public String status;
	
	// private String status;
	
	public Entity(String name) {
		this.name = name;
		this.level = 1;
		this.attr = new Attributes();
		this.stats = new Stats();
	}
	
}
