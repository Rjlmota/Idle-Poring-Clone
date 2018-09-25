package characters;

import combat.Combat;

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
		
		public int hp = 50;
		public int sp = 2;
		public int atk = 10;
		public int def = 5;
		public int atkM = 2;
		public int defM = 2;
		public int hit = 10;
		public int crit=  2;
		public int tenacity = 2;
		public int flee = 1;
		public int atkSpeed = 3;
		
		public Attributes() {
			
		}
	}
	
	public Attributes attributes = new Attributes();
	public String status = "Free";
	private String name;
	public String race;
	public int level = 1;
	
	
	public int attack(Entity target) {
		
		if (this.attributes.hp > 0) {
			int damage = attributes.atk - target.attributes.def;
			if(damage > 0){
				target.updateHp(-damage);
				return damage;
			}
			else {
				return 0;
			}
		}
		return 0;
	}
	
	public void upLevel(int level){
		this.level += level;
		this.attributes.atk += this.level*2;
		this.attributes.hit += (int)this.level*1.5;
		this.attributes.hp += this.level*3;
		this.attributes.flee += this.level*2;
	}
	
	public void updateHp(int damage){
		this.attributes.hp += damage;
		if (this.attributes.hp < 0) {
			this.attributes.hp = 0;
		}
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