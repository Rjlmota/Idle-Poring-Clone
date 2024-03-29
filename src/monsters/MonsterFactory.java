package monsters;

public class MonsterFactory {
	
	public static Monster getMonster(String name) {
		if(name.equalsIgnoreCase("Poring"))
			return new Poring(name);
		
		if(name.equalsIgnoreCase("Ogre")) 
			return new Ogre(name);

		if(name.equalsIgnoreCase("GuardPoring"))
			return new GuardPoring(name);
		
		else
			return new Boss(name);
		
	}	
}
