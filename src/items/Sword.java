package items;

public class Sword extends Item {

	class Stats{
		int atk;
		int atkSpeed;
		public Stats() {
			
		}
	}
	
	Stats stats = new Stats();
	

	int getAttack() {
		return this.stats.atk;
	}
	
	public Sword(String name, String type, String description, int attack, int atkSpeed) {
		super(name, type, description);
		this.stats.atk = attack;
		this.stats.atkSpeed= atkSpeed;
	}
}
