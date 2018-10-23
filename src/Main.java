import characters.Monster;
import characters.Class;
import combat.Combat;
import pseudointerface.PInterface;

public class Main {
	//Teste
	//Teste 2
	//Teste 3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class player = new Class("Alberto", "1");
		PInterface.showAttributes(player);
		
		Monster monster = new Monster("Monster 1");
		PInterface.showAttributes(monster);
		
		Combat combat = new Combat(player, monster);
		combat.startCombat();
		
	}


}
