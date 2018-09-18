package combat;

import java.util.Random;
import characters.Personagem;



public class Habilidade {
	
	class Efeito{
		String nome;
		String descricao;
		double chance;
		
	}
	
	void aplicarEfeito(Efeito effect, Personagem enemy) {
		if(effect.nome == "Stun") {
			double random = Math.random() *1 + 0;
			if(random < effect.chance){
					enemy.status = "Stunned";
			}	
		}
	}
	
	
	String efeitos;
	String descricaoEfeito;
	int nivelHabilidade;
}
