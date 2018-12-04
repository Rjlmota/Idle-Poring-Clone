package phase;

import java.util.ArrayList;

import characters.Hero;
import monsters.Monster;
import monsters.MonsterFactory;

public class PhaseHandler {

	Monster monster = MonsterFactory.getMonster("Poring");
	Monster monster2 = MonsterFactory.getMonster("Ogre");
	Monster monster3 = MonsterFactory.getMonster("GuardPoring");
	
	
	Monster boss = MonsterFactory.getMonster("Leader Poring");
	Monster boss2 = MonsterFactory.getMonster("Pirate King");
	Monster boss3 = MonsterFactory.getMonster("Flying Sausage");
	Monster boss4 = MonsterFactory.getMonster("Claudomiro");
	
	ArrayList<Monster> monsters = new ArrayList<Monster>();
	ArrayList<Monster> bosses = new ArrayList<Monster>();
	public ArrayList<Level> map = new ArrayList<Level>();
	

	public void initialize() {

		monsters.add(monster);
		monsters.add(monster2);
		monsters.add(monster3);
		
		bosses.add(boss);
		bosses.add(boss2);
		bosses.add(boss3);
		bosses.add(boss4);
			
		
		for (int i = 1; i < 10; i += 1) {

			if(i > 10) monsters.add(monster3);
			int boss_number = (int) i/5;
 			Level level = new Level("Scarlet Hills " + i, i, bosses.get(boss_number), monsters, null);
			this.map.add(level);
		}
		
		for(int i = 1; i < this.map.size()-1; i++) {
			map.get(i-1).next_level = map.get(i);
		}
		

	}

	public  void  playMap(Hero player) {
		map.get(0).start(player);

	}
	
	public PhaseHandler() {
		
	}
}
