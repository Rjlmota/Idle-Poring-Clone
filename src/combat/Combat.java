package combat;

import characters.Entity;
public class Combat {
	
	
	public boolean hit(Entity Atacante, Entity Atacado) {
		double chance = Math.random()*1 +0;
		if((Atacado.getAttributes().miss / Atacante.getAttributes().hit) <= chance) {
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
