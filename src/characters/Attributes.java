package characters;


//A Class designed to hold standard attributes for all characters from the game
public class Attributes {
	public int power;
	
	public int strength;
	public int agility;
	public int vitality;
	public int intelligence;
	public int dexterity;
	public int luck;

	public int maxHp;
	public int maxSp;
	
	public int atk;
	public int def;
	public int atkM;
	public int defM;
	public int hit;
	public int evasion;
	public int critic;
	public int atkSpeed;
	public int tenacity;
	public int cast;
		
	public Attributes(String id) {
		if (id.charAt(0) == '1') {
			this.strength = 9;
			this.agility = 9;
			this.vitality = 9;
			this.intelligence = 9;
			this.dexterity = 9;
			this.luck = 9;
		}
		upAttributes(id);
	}
	public void upAttributes(String id) {
		if (id.charAt(1) == '1') {
			this.maxHp = (2*this.strength) + (12*this.agility) + (16*this.vitality) + 
					(8*this.intelligence) + (8*this.dexterity) + (10*this.luck);
			this.maxSp = (2*this.strength) + (8*this.intelligence) + (8*this.dexterity);
			this.atk = (4*this.strength);
			this.def = (2*this.vitality) + (2*this.intelligence);
			this.atkM = 0;
			this.defM = (2*this.vitality) + (2*this.intelligence) + (2*this.dexterity);
			this.hit = (2*this.luck);
			this.evasion = (2*this.agility);
			this.critic = (2*this.luck);
			this.atkSpeed = (2*this.agility);
			this.tenacity = (2*this.luck);
			this.cast = 0;
		}
	}
	
	public void updateHp(int damage){
		this .hp += damage;
		if (this .hp < 0) {
			this .hp = 0;
		}
	}
}