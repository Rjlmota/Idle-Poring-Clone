package items;

public class MiscFactory {

	
	public static Misc getSingleItem(String name) {
		
		if (name.equalsIgnoreCase("Fracon")) {
			return new Misc(name, 1);
		}
		return null;
		
	}
	
	
}
