package phase;

import properties.Entity;
import monsters.Monster;
import combat.Combat;

import java.util.*;

public class Level {

	// MONSTER LIST
	// BOSS
	//

	String title;

	private ArrayList<Monster> Monsters = new ArrayList<Monster>();
	Monster boss;

	Level next_level;
	int levelNumber;

	public Level(String title, int levelNumber, Monster boss, ArrayList<Monster> monsterTypes, Level next) {
		this.title = title;
		this.boss = boss;
		this.Monsters = monsterTypes;
		this.next_level = next;
		this.levelNumber = levelNumber;
	}

	public boolean bossCall;

	private void nextLevel(Entity player) {
		System.out.println("Moving on to next level");
		this.next_level.start(player);

	}

	public void start(Entity player) {
		int iterator = (int) (Math.random() * Monsters.size() + 0);
		Monster currentMonster = Monsters.get(iterator);

		int killCount = 0;

		System.out.println("Welcome to " + this.title);

		// Factory to monster
		// Combat combat = new Combat(Player, currentMonster);
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
					// Levelling up monsters to next level;
					for (Monster monster : Monsters) {
						System.out.println(monster.stats.getStats().get("maxHp"));
						System.out.println(monster.getName());
						monster.levelUpTo(levelNumber);

					}

					boss.levelUpTo(levelNumber + 1);
				}
				nextLevel(player);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
