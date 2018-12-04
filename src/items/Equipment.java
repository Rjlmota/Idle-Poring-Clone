package items;

import properties.Attributes;

public class Equipment {

	private String name;
	private String type;
	public Attributes attr = new Attributes();

	public Equipment(String name, String type, int[] attr){
		this.name = name;
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
