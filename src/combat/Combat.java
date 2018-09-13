package combat;

import characters.Character;
public class Combat {
	
	
	public boolean isHit(Character Atacante, Character Atacado) {
		double chance = Math.random()*1 +0;
		if((Atacado.getStats().miss / Atacante.getStats().hit) <= chance) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean isCrit(Character Atacante){
		double chance = Math.random() *1 +0;
		if(20 < chance) {
			return true;
		}else {
			return false;
		}
	}
	
	public int physicalDamageDealt(Character Atacante, Character Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(isHit(Atacante, Atacado)) {
			
		}
		
		return 200;
	}
	
	
	

}
