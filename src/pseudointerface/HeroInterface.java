package pseudointerface;

import java.util.ArrayList;
import java.util.Scanner;
import characters.Bag;
import characters.Hero;
import items.Equipment;
import items.Misc;

public abstract class HeroInterface {
	
	private static Scanner scan = new Scanner(System.in);
	private static final String[] index = {"Strenght", "Agility", "Vitality", "Intelligency", "Dexterity", "Lucky"};
    private static final String[] ref = {"Weapon", "Helmet", "BodyArmor", "LegArmor", "Gloves", "Boots", "Necklace", "Ring"};

	
	public static void showHero(Hero hero) {
		
		int op;
		int op2;
		
		while(true) {
			DetailInterface.showEntity(hero);
			showBag(hero.bag);
			
			do {
				System.out.print("1-Change Equipments\n2-Refine\n3-Exit\n:> ");
				op = scan.nextInt();
			}while (op<1 || op>2);
			
			if (op==1) {
				System.out.print("Which Equipment?\n:> ");
				op2 = scan.nextInt();
				Equipment new_equip = hero.bag.getEquipments().get(op2);
				hero.changeEquipment(new_equip, new_equip.getType());
			}else if (op==2) {
				System.out.print("Which Slot?\n:> ");
				op2 = scan.nextInt();
				hero.equips.get(ref[op2]).levelUp();
			}else {
				System.out.println("Exiting.");
				break;
			}
		}
	}
	
	public static int[] levelUp() {
	
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
				System.out.println("\nConfirm? (Yes or No)");
				confirm = scan.next();
			}while (!confirm.equalsIgnoreCase("yes") && !confirm.equalsIgnoreCase("no"));
			
			if (confirm.equalsIgnoreCase("yes")) {
				return up;
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
	
	public static void showBag(Bag bag) {
		
		int i = 0;
		System.out.println("Equipments:");
		ArrayList<Equipment> equips = bag.getEquipments();
		if (equips.isEmpty()) {
			System.out.println("Empty.");
		}else {
			for (Equipment equip : equips) {
				System.out.println(i);
				DetailInterface.showEquipment(equip);
				i++;
			}
		}
		
		ArrayList<Misc> miscs = bag.getMiscs();
		if  (miscs.isEmpty() ) {
			System.out.println("Empty.");
		}else {
			for (Misc misc : miscs) {
				DetailInterface.showMisc(misc);
			}
		}
	}	
	

}
