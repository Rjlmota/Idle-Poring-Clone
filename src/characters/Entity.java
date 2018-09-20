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
		
		public int hp = 2;
		public int sp = 2;
		public int atq = 2;
		public int def = 2;
		public int atqM = 2;
		public int defM = 2;
		public int hit = 2;
		public int crit=  2;
		public int tenacity = 2;
		public int miss = 2;
		public int atkSpeed = 2;
		
		public Attributes() {
			
		}
	}
	
	public Attributes attributes = new Attributes();
	public String status = "Free";
	private String name;
	public String race;
	int level = 1;
	
	
	public void attack(Character target) {
		
	}
	
	//This function returns the character's stats
	public Attributes getAtributos() {
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