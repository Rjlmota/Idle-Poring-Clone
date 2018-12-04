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
		int op;
		
		while(true) {
			
			System.out.print("1-Select Hero\n2-Start New Game\n:> ");
			do {
				op = scan.nextInt();
			}while (op<0 || op>3);
			
			if (op==1) {
				StartInterface.selectHero(database);
			}else {
				StartInterface.createGame(database);
			}
			
		}
/*
		Hero player = HeroFactory.getHero("Swordman", "Alberto");
		//DetailInterface.showPlayer(player);
		
		Monster monster = MonsterFactory.getMonster("Poring");
		
		Combat.startCombat(player, monster);
		
		monster = MonsterFactory.getMonster("Ogre");
		
		Combat.startCombat(player, monster);
		
		HeroInterface.showBag(player.bag);
*/	
	}

}
