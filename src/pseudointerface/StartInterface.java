package pseudointerface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import phase.PhaseHandler;
import characters.ClassFactory;
import characters.Entity;
import characters.Monster;
import characters.MonsterFactory;
import phase.Level;

public abstract class StartInterface {
	
	private static Scanner scan = new Scanner(System.in);
	private static Entity player = null;
	private static Level level = null;
	private static PhaseHandler phasehandler = new PhaseHandler();
	public static void startGame(Map<Entity, Level> database) {
		
		Map<Entity, Level> current = new HashMap();
		
		if (database.isEmpty()) {
			current = createGame();
			database.putAll(current);
		}
		
		selectPlayer(database);
		phasehandler.playMap(player);
		showMenu();
		
	}
	
	public static void selectPlayer(Map<Entity, Level> database) {
		
		Map<Integer, Entity> ref = new HashMap();
		int i=0, op;
		for (Entity entity : database.keySet()) {
			ref.put(i, entity);
			i++;
		}
		
		System.out.println("\nSelect which character to play:");
		
		for (Integer id : ref.keySet()) {
			System.out.println(id + " - " + ref.get(id).getName() );
		}
		System.out.print(":> ");
		op = scan.nextInt();
		player = ref.get(op);
		level = database.get(player);
	}
	
	public static Map<Entity, Level> createGame() {
		
		Entity player = createPlayer();
		System.out.println("\nCharacter Created!\n");
		Level level = phasehandler.map.get(0);
		
		Map<Entity, Level> game = new HashMap();
		game.put(player, level);
		
		return game;
		
	}
	
	public static Entity createPlayer() {
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
			player = ClassFactory.getClass("Swordman", name);
		}
		else if (job==2) {
			player = ClassFactory.getClass("Archer", name);
		}
		else {
			player = ClassFactory.getClass("Wizard", name);
		}
		
		System.out.println("Your first skill is: " + player.skillList.get(0).getName());
		
		return player;

	}
	/*
	public static Level createLevel() {
		
		Monster monster = MonsterFactory.getMonster("Poring");
		Monster monster2 = MonsterFactory.getMonster("Ogre");
		Monster boss = new Monster("Leader Poring");

		ArrayList<Monster> Monsters = new ArrayList<Monster>();

		Monsters.add(monster);
		Monsters.add(monster2);
		
		return new Level("Scarlet Hills", boss, Monsters, 1);
		
	}
	*/
	public static void showMenu() {
		
		int op = 0;
		
		System.out.println("Menu:");
		System.out.println("1-Combat\n2-Bag\n3-Character\n4-Exit");
		
		do {
			System.out.print(":> ");
			op = scan.nextInt();
		}while (op<0 || op>5);
		
		if (op==1) {			
			level.start(player);
		}
		else if (op==2) {
			System.out.println("Show Bag");
		}
		else if (op==3) {
			DetailInterface.showPlayer(player);
		}
		else {
			System.out.println("Exiting");
		}
		
	}
	
}
