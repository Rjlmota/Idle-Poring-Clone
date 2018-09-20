package combat;

import characters.Entity;
public class Combat {
	
	
	public boolean hit(Entity attacker, Entity defender) {
		int chance = (int)Math.random()*100 +0;
		//ATTACKERHIT - DEFENDERFLEE
		int precision = attacker.attributes.hit - defender.attributes.flee;
		
		if (precision >= 95) precision = 95;
		else if (precision <0) precision = 0;
		
		if(chance <= precision){
			return true;
		}
		return false;
	}

	
	public boolean crit(Character Atacante){
		double chance = Math.random() *1 +0;
		if(20 < chance) {
			return true;
		}else {
			return false;
		}
	}
	
	public int physDamage(Entity Atacante, Entity Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(hit(Atacante, Atacado)) {
			
		}
		
		return 200;
	}
	
	
	

}
