package characters;

import java.util.Random;

//A Class designed to hold standard attributes for all characters from the game
public abstract class Attributes {
	public int power;
	
	public int str;
	public int agi;
	public int vit;
	public int inte;
	public int dex;
	public int luck;
	
	public void setAttributes() {
		this.str = 0;
		this.agi = 0;
		this.vit = 0;
		this.inte = 0;
		this.dex = 0;
		this.luck = 0;		
	}
	
	public void setAttributes(int str, int agi, int vit, int inte, int dex, int luck) {
		this.str = str;
		this.agi = agi;
		this.vit = vit;
		this.inte = inte;
		this.dex = dex;
		this.luck = luck;
	}
	
	public void setRandomAttributes(int low, int high) {
		Random rand = new Random();
		this.str = rand.nextInt(high) + low;
		this.agi = rand.nextInt(high) + low;
		this.vit = rand.nextInt(high) + low;
		this.inte = rand.nextInt(high) + low;
		this.dex = rand.nextInt(high) + low;
		this.luck = rand.nextInt(high) + low;
	}
	
}