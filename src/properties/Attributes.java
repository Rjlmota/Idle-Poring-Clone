package properties;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

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
	
	public void setAttributes(int[] attr) {
		if (attr.length != 6) {
			throw new IllegalArgumentException();
		}else {
			this.str = attr[0];
			this.agi = attr[1];
			this.vit = attr[2];
			this.inte = attr[3];
			this.dex = attr[4];
			this.luck= attr[5];
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
	
	public Map<String,Integer> getAttributes() {
		Map<String,Integer> attr = new HashMap<String,Integer>();
	    attr.put("str", this.str);
	    attr.put("agi", this.agi);
	    attr.put("vit", this.vit);
	    attr.put("int", this.inte);
	    attr.put("dex", this.dex);
	    attr.put("luk", this.luck);
	    attr.put("power", this.power);
		return attr;
	}
	
}