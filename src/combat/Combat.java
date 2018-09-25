package combat;

import characters.Entity;
public abstract class Combat {
	
	
	public static boolean hit(Entity attacker, Entity defender) {
		double chance = Math.random()*1 +0;
		//ATTACKERHIT - DEFENDERFLEE
		int precision = attacker.getAttributes().hit - defender.getAttributes().flee;
		int pool = attacker.getAttributes().hit + defender.getAttributes().flee;
		double bet = precision/(double)pool;
		if (bet >= 0.95) bet = 0.95;
		else if (bet <0) bet = 0;
	
	
		if(chance <= bet){
			return true;
		}
		return false;
	}

	
	public static boolean crit(Character Atacante){
		double chance = Math.random() *1 +0;
		if(20 < chance) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int physDamage(Entity Atacante, Entity Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(hit(Atacante, Atacado)) {
		}
		
		return 200;
	}
	
	
	

}
