package pseudointerface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import phase.PhaseHandler;
import characters.HeroFactory;
import characters.Hero;
import phase.Level;

public abstract class StartInterface {
	
	private static Scanner scan = new Scanner(System.in);
	private static Hero player = null;
	private static Level level = null;
	private static PhaseHandler phasehandler = new PhaseHandler();
	
	public static void selectHero(Map<Hero, Level> database) {
		
		if (database.isEmpty()) {
			System.out.println("No Heroes found.");
		}else {
		
			Map<Integer, Hero> ref = new HashMap<Integer, Hero>();
			int i=0, op;
			for (Hero hero : database.keySet()) {
				ref.put(i, hero);
				i++;
			}
			
			System.out.println("\nSelect which hero to play:");
			
			for (Integer id : ref.keySet()) {
				System.out.println(id + " - " + ref.get(id).getName() );
			}
			System.out.print(":> ");
			op = scan.nextInt();
			player = ref.get(op);
			level = database.get(player);
			showMenu(database);
		}
	}
	
	public static void createGame(Map<Hero, Level> database) {
		
		Hero hero = createHero();
		System.out.println("\nCharacter Created!\n");
		Level level = phasehandler.map.get(0);
		
		database.put(hero, level);
		
	}
	
	public static Hero createHero() {
		phasehandler.initialize();
		String name;
		int job;
		System.out.println("\nCreating your character!");
		System.out.print("What is your name?\n:> ");
		name = scan.next();
		
		do {
			System.out.print("What is your class?\n1-Swordman\n2-Archer\n3-Wizard\n:> ");
			job = scan.nextInt();
		}while (job<0 || job>4);
		
		if (job==1) {
			player = HeroFactory.getHero("Swordman", name);
		}
		else if (job==2) {
			player = HeroFactory.getHero("Archer", name);
		}
		else {
			player = HeroFactory.getHero("Wizard", name);
		}
		
		return player;

	}

	public static void showMenu(Map<Hero, Level> database) {
		
		while (true) {
		
			int op = 0;
			
			System.out.println("Menu:");
			System.out.println("1-Combat\n2-Hero\n3-Exit");
			
			do {
				System.out.print(":> ");
				op = scan.nextInt();
			}while (op<0 || op>5);
			
			if (op==1) {		
				phasehandler.playMap(player);
			}
			else if (op==2) {
				HeroInterface.showHero(player);
			}
			else {
				database.put(player, level);
				System.out.println("Exiting");
				break;
			}
		}
	}
	
}
