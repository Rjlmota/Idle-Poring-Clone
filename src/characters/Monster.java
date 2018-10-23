package characters;

public class Monster extends Character {
	
	public Monster(String name){
		super(name);
		setRandomAttributes(9, 40);
		updateAttributes();
	}
	//To DO: extend upLevel function to limit to 6 points per level.
	public void upLevel(int str, int agi, int vit, int inte, int dex, int luck) {
		this.level += 1;
		this.addAttributes(str, agi, vit, inte, dex, luck);
	}
	
}
