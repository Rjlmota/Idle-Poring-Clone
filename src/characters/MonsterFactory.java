package characters;

public class MonsterFactory {
	
	public static Monster getMonster(String name) {
		if(name.equalsIgnoreCase("Poring")) {
			return new Poring(name);
		}
		return null;
	}
	
}
