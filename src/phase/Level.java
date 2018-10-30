package phase;
import characters.Character;
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
		Combat combat = new Combat(Player, currentMonster);
		combat.startCombat();
		while(true) {
			if(Player.isDead()) {
				System.out.println("YOU DIED");
				break;
			}

			if(boss.isDead()) {
				System.out.println("Boss defeated");
				break;
			}
			
			if(currentMonster.isDead()) {
					for(int i = 0; i < currentMonster.loot.size(); i++)
						System.out.println("Loot: " + currentMonster.loot.get(i).name);
						
					currentMonster.loot.clear();
					currentMonster.reset();
					System.out.println("New Monster!");
					Player.currentHp = Player.maxHp;
					
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
				}

				combat = new Combat(Player, currentMonster);
				combat.startCombat();
		
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	if(Player.isDead()) {
		System.out.println("Returning to Menu");
		}else {
			nextLevel();
		}
	}
}
