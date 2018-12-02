package combat;
import java.util.Map;

import characters.Entity;

/*
 * Skills will be an abstract form to help manage some skill types: Active, Passive, ?.
 * The concrete form of theses skills will be instantiated and put inside a list of Skills. There we'll be able
 * to control the level of the skill, cooldown, and any other effects that may come to play.
 * 
 * 
 */

public class Skill {
	
	
	String name;
	double accuracy;
	int cooldown;
	double last_usage = -100;
	String type;
		
	class Effect{
		String name;
		String description;
		String type;
		double chance;

	}
	
	void applyStatus(Effect effect, Entity enemy) {
		if(effect.name == "Stun") {
			double random = Math.random()*1 + 0;
			if(random < effect.chance){
					enemy.status = "Stunned";
			}	
		}
	}
	
	String effect;
	String effectDescription;
	int skillLevel;
	
	public Skill(String name, int cooldown_sec, double accuracy) {
		this.name = name;
		this.cooldown = cooldown_sec;
		this.accuracy = accuracy;
		
	}
	
	public int useSkill(Entity target) {
		return -1;
	}
	
	public void useSkill(Map <String, Integer> attr) {
		
	}

}
