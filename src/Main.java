import properties.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import phase.Level;
import pseudointerface.*;

public class Main {
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
