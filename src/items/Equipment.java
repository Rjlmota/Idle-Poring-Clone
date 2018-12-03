package items;

import properties.Attributes;

public class Equipment {

	private String name;
	private String type;
	private String subtype;
	public Attributes attr;

	public Equipment(String name, String type, String subtype, int[] attr){
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.attr = new Attributes();
		this.attr.setAttributes(attr);
	}

	public String getName(){
		return this.name;
	}

	public String getType(){
		return this.type;
	}

	public String getSubtype(){
		return this.subtype;
	}

}
