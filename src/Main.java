import characters.Monster;
import characters.MonsterFactory;
import characters.playerclass.Swordman;
import characters.ClassFactory;
import characters.Entity;
import phase.PhaseHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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


		Scanner scan = new Scanner(System.in);
		Map<Entity, Level> database = new HashMap();
		String pause;
		
		
		while(true) {
			System.out.println("Type anything and press ENTER to start.");
			pause = scan.next();
			StartInterface.startGame(database);
		}
	
	}

}
