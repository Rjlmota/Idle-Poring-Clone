package characters;

import characters.monsterTypes.*;

public class MonsterFactory {
	
	public static Monster getMonster(String name) {
		if(name.equalsIgnoreCase("Poring"))
			return new Poring(name);
		
		if(name.equalsIgnoreCase("Ogre")) 
			return new Ogre(name);

		return null;
	}	
}
