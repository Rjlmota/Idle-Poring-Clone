package combat;

import characters.Personagem;
public class Combate {
	
	
	public boolean acerto(Personagem Atacante, Personagem Atacado) {
		double chance = Math.random()*1 +0;
		if((Atacado.getAtributos().miss / Atacante.getAtributos().hit) <= chance) {
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
	
	public int danoFisico(Personagem Atacante, Personagem Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(acerto(Atacante, Atacado)) {
			
		}
		
		return 200;
	}
	
	
	

}
