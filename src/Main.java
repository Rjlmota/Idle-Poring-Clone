import characters.Hero;
import characters.HeroFactory;
import combat.Combat;
import monsters.Monster;
import monsters.MonsterFactory;
import properties.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import phase.Level;
import pseudointerface.*;

public class Main {
	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		Map<Hero, Level> database = new HashMap<Hero, Level>();
		String pause;
		
<<<<<<< HEAD
		
=======
/*	
>>>>>>> Equips
		while(true) {
			System.out.println("Type anything and press ENTER to start.");
			pause = scan.next();
			StartInterface.startGame(database);
		}
<<<<<<< HEAD


=======
*/
>>>>>>> Equips

		Hero player = HeroFactory.getHero("Swordman", "Alberto");
		//DetailInterface.showPlayer(player);
		
		Monster monster = MonsterFactory.getMonster("Poring");
		
		Combat.startCombat(player, monster);
		
		monster = MonsterFactory.getMonster("Ogre");
		
		Combat.startCombat(player, monster);
		
		HeroInterface.showBag(player.bag);
		
	}

}
