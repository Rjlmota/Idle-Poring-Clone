package characters;

import characters.Attributes;

public abstract class Character extends Attributes{
	
	public String name;
	
	public int maxHp;
	public int currentHp;
	public int maxSp;
	public int currentSp;
	
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
	
	public Character(String name) {
		this.name = name;
		setAttributes(9, 9, 9, 9, 9, 9);
	}
	
}
