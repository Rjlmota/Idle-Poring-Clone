package items;

import properties.Attributes;

public class Equipment extends Item{

	private String type;
	public Attributes attr = new Attributes();

	public Equipment(String name, String type, int[] attr){
		super(name);
		this.type = type;
		this.attr.setAttributes(attr);
	}

	public String getName(){
		return this.name;
	}

	public String getType(){
		return this.type;
	}

}
