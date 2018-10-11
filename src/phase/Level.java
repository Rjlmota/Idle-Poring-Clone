package phase;
import characters.Character;
import characters.Monster;
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
		
	}
	
	public void start(Character Player) {
		int iterator = (int) (Math.random()*1 + Monsters.size());
		Monster currentMonster = Monsters.get(iterator);
		
		while(true) {
			
			if(currentMonster.isDead()) {
				iterator = (int) (Math.random()*1 + Monsters.size());
				currentMonster = Monsters.get(iterator);
			}
			
			if(bossCall) 
				currentMonster = boss;
			
			if(boss.isDead()) 
				break;
		
	
		}
		
	nextLevel();
	}
}
