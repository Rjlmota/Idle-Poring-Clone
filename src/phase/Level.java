package phase;
import characters.Entity;
import characters.Monster;
import combat.Combat;

import java.util.*;

public class Level {
	
	//MONSTER LIST
	//BOSS 
	//
	
	String title;
	
	private ArrayList <Monster> Monsters = new ArrayList<Monster>();
	Monster boss;
	
	
	public Level(String title, Monster boss, ArrayList<Monster> monsterTypes) {
		this.title = title;
		this.boss = boss;
		this.Monsters = monsterTypes;
	}
	
	public boolean bossCall;
	
	
	private void nextLevel() {
		System.out.println("Moving on to next level");
		
	}
	
	public void start(characters.Class Player) {
		int iterator = (int) (Math.random()*Monsters.size() + 0);
		Monster currentMonster = Monsters.get(iterator);
		
		int killCount = 0;
		
		System.out.println("Welcome to " + this.title);
		
		//Factory to monster 
		//Combat combat = new Combat(Player, currentMonster);
		Combat.startCombat(Player, currentMonster);
		while(true) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//currentMonster.reset();
				System.out.println("New Monster!");
				
				killCount++;
				if(killCount > 5)
					bossCall = true;
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				iterator = (int)(Math.random()*Monsters.size() + 0);
				currentMonster = Monsters.get(iterator);
				
			
			if(bossCall) { 
				for(int i = 0; i < 5; i++) {					
					System.out.println("-!-!-! BOSS !-!-!-!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				currentMonster = boss;
				if(Combat.startCombat(Player, currentMonster)) {
					System.out.println("END");
					nextLevel();
					break;
					
				}
					
			}

			Combat.startCombat(Player, currentMonster);
	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	}
}
