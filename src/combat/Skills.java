package combat;

import java.util.Random;

import characters.Character;



public class Skills {
	
	class Effect{
		String name;
		String Description;
		
		double chance;
		
	}
	
	void applyEffect(Effect effect, Character enemy) {
		if(effect.name == "Stun") {
			double random = Math.random() *1 + 0;
			if(random < effect.chance){
					enemy.status = "Stunned";
			}	
		}
	}
	
	
	String effects;
	String effectDescription;
	int skillLevel;
	
	
}
