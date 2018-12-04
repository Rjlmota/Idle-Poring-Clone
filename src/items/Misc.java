package items;

public class Misc extends Item{

	private int quantity;
	
	public Misc(String name, int quantity) {
		super(name);
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
