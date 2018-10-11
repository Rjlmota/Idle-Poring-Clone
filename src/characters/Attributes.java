package characters;
import combat.Combat;

//A Class designed to hold standard attributes for all characters from the game
public class Attributes {

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
}