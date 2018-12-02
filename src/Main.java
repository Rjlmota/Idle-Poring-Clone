import characters.Monster;
import characters.MonsterFactory;
import characters.playerclass.Swordman;
import characters.ClassFactory;
import characters.Entity;
import phase.PhaseHandler;

import java.util.ArrayList;

import combat.Active;
import combat.Buff;
import combat.Combat;
import phase.Level;
import pseudointerface.*;

public class Main {
	// Teste
	// Teste 2
	// Teste 3
	public static void main(String[] args) {
		
		
		PhaseHandler phase_handler = new PhaseHandler();
		// Class player = new Class("Player", "1");
		// DetailInterface.showPlayer(player);

		// Monster monster = new Monster("Monster", 1);
		// DetailInterface.showMonster(monster);

		// Combat.startCombat(player, monster);

		/*
		 * Class player = new Class("Alberto", "1");
		 * //PInterface.showAttributes(player); player.upLevel(5);
		 * 
		 * Monster monster = new Monster("Poring", 1); monster.upLevel(5);
		 * PInterface.showAttributes(monster);
		 * 
		 * 
		 * 
		 * 
		 * Monster monster1 = new Monster("Ogre", 2); monster1.upLevel(5);
		 * PInterface.showAttributes(monster1);
		 * 
		 * Monster monster2 = new Monster("Poring Guard", 1); monster1.upLevel(10);
		 * PInterface.showAttributes(monster2);
		 * 
		 * Monster boss = new Monster("Leader Poring", 2);
		 * PInterface.showAttributes(boss);
		 * 
		 * ArrayList <Monster> Monsters = new ArrayList<Monster>();
		 * 
		 * 
		 * 
		 * Monsters.add(monster); Monsters.add(monster1); Monsters.add(monster2); Level
		 * firstLevel = new Level("Scarlet Hills", boss, Monsters);
		 * 
		 * firstLevel.start(player);
		 * 
		 * //Combat combat = new Combat(player, monster); //combat.startCombat();
		 */

		// Class player = new Class("Player", "1");

		Entity player = ClassFactory.getClass("Swordman", "player");
		

		Active slash = new Active("slash", 100, 4, 0.9, "physical");
		player.skillList.add(slash);

		Buff harden = new Buff("harden", 15, 3, "def", 15);
		player.buff_list.add(harden);

		
		phase_handler.initialize();
		phase_handler.playMap(player);
		
		//Combat combat = new Combat(player, monster);
		//combat.startCombat();
	/*
		
	//Class player = new Class("Player", "1");

	Entity player = ClassFactory.getClass("Swordman", "player");
	DetailInterface.showPlayer((Swordman) player);
	PlayerInterface.levelUp(player);
	DetailInterface.showPlayer((Swordman) player);
	
	Monster monster = MonsterFactory.getMonster("Poring");
	Monster monster2 = MonsterFactory.getMonster("Ogre");
	Monster boss = new Monster("Leader Poring");
	
	ArrayList <Monster> Monsters = new ArrayList<Monster>();
	

	
	Monsters.add(monster);
	Monsters.add(monster2);
	Level firstLevel = new Level("Scarlet Hills", boss, Monsters);
	
	//firstLevel.start(player);

	*/
	}

}
