package combat;

import characters.Character;
public class Combat {
	
	
	public boolean hit(Character Atacante, Character Atacado) {
		double chance = Math.random()*1 +0;
		if((Atacado.getAttributes().miss / Atacante.getAttibutes().hit) <= chance) {
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
	
	public int physDamage(Character Atacante, Character Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(hit(Atacante, Atacado)) {
			
		}
		
		return 200;
	}
	
	
	

}
