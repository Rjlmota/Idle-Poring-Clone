import characters.Monster;

import java.util.ArrayList;

import characters.Class;
import combat.Combat;
import phase.Level;
import pseudointerface.PInterface;

public class Main {
	//Teste
	//Teste 2
	//Teste 3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class player = new Class("Alberto", "1");
		PInterface.showAttributes(player);
		player.upLevel(5);
		
		Monster monster = new Monster("Poring", 1);
		monster.upLevel(5);
		PInterface.showAttributes(monster);
		
		
		
		
		Monster monster1 = new Monster("Ogre", 2);
		monster1.upLevel(5);
		PInterface.showAttributes(monster1);
		
		Monster monster2 = new Monster("Poring Guard", 1);
		monster1.upLevel(10);
		PInterface.showAttributes(monster2);
		
		Monster boss = new Monster("Leader Poring", 2);
		PInterface.showAttributes(boss);
		
		ArrayList <Monster> Monsters = new ArrayList<Monster>();
		

		
		Monsters.add(monster);
		Monsters.add(monster1);
		Monsters.add(monster2);
		Level firstLevel = new Level("Scarlet Hills", boss, Monsters);
		
		firstLevel.start(player);
		
		//Combat combat = new Combat(player, monster);
		//combat.startCombat();
		
	}


}
