package properties;

import java.util.Random;

//A Class designed to hold standard attributes for all characters from the game
public class Attributes {
	
	private int str;
	private int agi;
	private int vit;
	private int inte;
	private int dex;
	private int luck;
	
	private int power;
	
	public Attributes() {
		this.power = 0;
		this.str = 0;
		this.agi = 0;
		this.vit = 0;
		this.inte = 0;
		this.dex = 0;
		this.luck = 0;		
	}
	
	public void setAttributes(int[] attributes) {
		if (attributes.length != 6) {
			throw new IllegalArgumentException();
		}else {
			this.str = attributes[0];
			this.agi = attributes[1];
			this.vit = attributes[2];
			this.inte = attributes[3];
			this.dex = attributes[4];
			this.luck= attributes[5];
			this.power = this.str + this.agi + this.vit + this.inte + this.dex + this.luck;
		}
	}
	
	public void setAttributes(int low, int high) {
		Random rand = new Random();
		this.str = rand.nextInt(high) + low;
		this.agi = rand.nextInt(high) + low;
		this.vit = rand.nextInt(high) + low;
		this.inte = rand.nextInt(high) + low;
		this.dex = rand.nextInt(high) + low;
		this.luck = rand.nextInt(high) + low;
		this.power = this.str + this.agi + this.vit + this.inte + this.dex + this.luck;
	}
	
	public int[] getArrayAttributes() {
		int[] attr = {this.str, this.agi, this.vit, this.inte, this.dex, this.luck, this.power};
		return attr;
	}
	
}