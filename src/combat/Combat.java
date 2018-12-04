package combat;

import java.util.ArrayList;
import characters.Hero;
import items.Item;
import monsters.Monster;
import pseudointerface.CombatInterface;
import skills.Buff;
import skills.Skill;

public abstract class Combat {

	public static Fighter fighter1 = new Fighter();
	public static Fighter fighter2 = new Fighter();
	
	
	public static int current_turn = 0;

	public static boolean startCombat(Hero hero, Monster monster) {
		
		fighter1.setFighter(hero);
		fighter2.setFighter(monster);
		
		ArrayList<Fighter> order = new ArrayList<Fighter>();
		
		System.out.println("Combat Starts!");
		
		current_turn = 0;
		
		do {
		
			CombatInterface.showCurrentLife(fighter1.name, fighter1.stats.get("hp"), fighter2.name, fighter2.stats.get("hp"));
			sleep(2000);
			
			if (fighter1.stats.get("spd") > fighter2.stats.get("spd")) {
				order.add(fighter1);
				order.add(fighter2);
			}else {
				order.add(fighter2);
				order.add(fighter1);
			}

			for (int i=0; i<2; i++) {
				
				checkBuffs(order.get(0));
				Action(order.get(0), order.get(1));
				
				order.add(order.get(0));
				order.remove(0);
				
				sleep(500);
				
			}
			
			current_turn ++;
			
		}while(fighter1.stats.get("hp")>0 && fighter2.stats.get("hp")>0);
		
		for (Fighter fighter : order) {
			for(Skill skill : fighter.skillList) {
				skill.reset();
			}
		}
		
		if (fighter1.stats.get("hp") > 0) {
			
			if (monster instanceof Monster) {
				gainExp(hero, monster);
				Item loot = monster.handleLoot();
				if (loot!=null)
					hero.handleLoot(loot);
			}
			return true;
		}
		return false;
		
	}
	
	private static void Action(Fighter self, Fighter target) {
		
		Skill current_move = self.actions.get(0);
		System.out.println(self.name + " used " + current_move.getName());
		current_move.useSkill(self, target);
		
		if(current_move.getType().equalsIgnoreCase("buff"))
			current_move.setLastUsage(current_turn);
		
		
		self.actions.remove(0);
		for(int i = 0; i < current_move.getCooldown(); i++)
			self.actions.add(self.auto_attack);
		
	}
	
	private static void gainExp(Hero player, Monster monster) {
		float exp = (player.getLevel() / monster.getLevel()) * monster.getExp();
		
		CombatInterface.showExpGain(player.getName(), exp);
		player.gainExp(exp);
		
	}
	
	private static void checkBuffs(Fighter self) {
		ArrayList <Buff> toRemove = new ArrayList<Buff>();
		for (Buff buff : self.current_buffs) {		
			if(!buff.isActive(current_turn)) {
				buff.removeBuff(self);
				toRemove.add(buff);
				System.out.println(buff.getName() + " weared off");
			}			
		}
		for(Buff remove : toRemove)
			self.current_buffs.remove(remove);
		
	}

	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
};