package characters;


//A Class designed to hold standard attributes for all characters from the game
public abstract class Entity {

	public class Attributes{
		public int strength = 2;
		public int vitality = 2;
		public int dexterity = 2;
		public int intelligence = 2;
		public int luck = 2;
		public int agility = 2;
		public int power = 2;
		
		public int hp = 200;
		public int sp = 2;
		public int atk = 2;
		public int def = 2;
		public int atkM = 2;
		public int defM = 2;
		public int hit = 10;
		public int crit=  2;
		public int tenacity = 2;
		public int flee = 5;
		public int atkSpeed = 2;
		
		public Attributes() {
			
		}
	}
	
	public Attributes attributes = new Attributes();
	public String status = "Free";
	private String name;
	public String race;
	public int level = 1;
	
	
	public void attack(Character target) {
		
	}
	
	public void upLevel(int level){
		this.level += level;
	}
	
	public void updateHp(int damage){
		this.attributes.hp += damage;
	}
	
	//This function returns the character's stats
	public Attributes getAttributes() {
		return this.attributes;
	}
	
	//This function returns the name of the character
	public String getName() {
		return this.name;
	}
	//Constructor class
	public Entity(String name) {
		this.name = name;
	}
	
}