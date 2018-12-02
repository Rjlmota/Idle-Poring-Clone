package characters;

import characters.playerclass.Archer;
import characters.playerclass.Swordman;
import characters.playerclass.Wizard;

public class ClassFactory {
	
	public static Entity getClass(String job, String name) {
		if(job.equalsIgnoreCase("Swordman"))
			return new Swordman(name);
		
		else if(job.equalsIgnoreCase("Archer")) 
			return new Archer(name);
		
		else if(job.equalsIgnoreCase("Wizard")) 
			return new Wizard(name);
		
		else
			throw new IllegalArgumentException();

	}	
}