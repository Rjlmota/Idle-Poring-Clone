package pseudointerface;

import java.util.Scanner;
import characters.Entity;

public abstract class PlayerInterface {
	
	private static final String[] index = {"Strenght", "Agility", "Vitality", "Intelligency", "Dexterity", "Lucky"};

	
	public static void levelUp(Entity entity) {
		Scanner scan = new Scanner(System.in);
		int points = 5;
		int[] up = {0, 0, 0, 0, 0, 0};
		int spent, i=0;
		String confirm;
	
		System.out.println("Congratulations! You leveled up!");
		System.out.println("Choose where to spend your points.");
		while (true) {

			while (points > 0) {
					System.out.println("You have "+points+" points remaining.");
					System.out.println();
					
					do {
						System.out.print(index[i] + " = " + up[i] + ": ");
						spent = scan.nextInt();
					}while (spent<0 || spent>5);
					
					up[i] = spent;
					points -= spent;
					i++;
					if (i>5) {i=0;}
			}
			
			System.out.println("Your points spent:");
			for (int j=0; j<6; j++) {
				System.out.print(index[j] + " = " + up[j] + " ");
			}
			
			
			do {
				System.out.println("\nConfirm? (y = Yes, n = No)");
				confirm = scan.next();				
			}while (!confirm.equalsIgnoreCase("yes") && !confirm.equalsIgnoreCase("no"));
			
			if (confirm.equalsIgnoreCase("yes")) {
				entity.levelUp(up);
				break;
			}else{	
				for (int j=0; j<6; j++) {
					up[j] = 0;
				}
				points = 5;
				i=0;
				System.out.println("Reseting!");
			}

		}
	}
	
}
