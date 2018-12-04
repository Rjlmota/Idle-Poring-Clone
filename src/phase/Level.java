package phase;

import characters.Hero;
import monsters.Monster;
import combat.Combat;

import java.util.*;

public class Level {

	String title;

	private ArrayList<Monster> Monsters = new ArrayList<Monster>();
	Monster boss;

	Level next_level;
	int levelNumber;
	public boolean bossCall;
	
	
	public Level(String title, int levelNumber, Monster boss, ArrayList<Monster> monsterTypes, Level next) {
		this.title = title;
		this.boss = boss;
		this.Monsters = monsterTypes;
		this.next_level = next;
		this.levelNumber = levelNumber;
	}

	public void start(Hero player) {
		int iterator = (int) (Math.random() * Monsters.size() + 0);
		Monster currentMonster = Monsters.get(iterator);

		int killCount = 0;

		System.out.println("Welcome to " + this.title);

		Combat.startCombat(player, currentMonster);
		while (true) {

			System.out.println("New Monster!");
			sleep(3);
			killCount++;
			if (killCount > 5)
				bossCall = true;

			sleep(1);

			iterator = (int) (Math.random() * Monsters.size() + 0);
			currentMonster = Monsters.get(iterator);

			if (bossCall) {
				for (int i = 0; i < 5; i++) {
					System.out.println("-!-!-! BOSS !-!-!-!");
					sleep(1);
				}
				currentMonster = boss;
				if (Combat.startCombat(player, currentMonster)) {
					System.out.println("END");
				}
				
				break;
			}

		Combat.startCombat(player, currentMonster);

		sleep(3);
		}
	}

	void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
