package combat;

import java.util.ArrayList;
import java.util.Random;

import characters.Hero;
import items.Equipment;
import monsters.Monster;
import pseudointerface.CombatInterface;
import skills.Buff;
import skills.Skill;

public abstract class Combat {

	private static Random rnd = new Random();
	
	private static ArrayList<Buff> current_buffs = new ArrayList<Buff>();

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
				
				checkSkills(order.get(0), order.get(1));
				useBuffs(order.get(0));
				checkBuffs(order.get(0));
				
				boolean hit = isHit(order.get(0).stats.get("hit"), order.get(1).stats.get("hit"));
				if (hit) {
					boolean crit = isCrit(order.get(0).stats.get("crit"));
					int damage = getDamage(order.get(0).stats.get("atk"), order.get(1).stats.get("def"), crit);
					order.get(1).stats.replace("hp", order.get(1).stats.get("hp") - damage);
					CombatInterface.showDamage(order.get(0).name, damage, crit);

				}else {
					
					System.out.println(order.get(0).name + " missed!");
					
				}
				
				order.add(order.get(0));
				order.remove(0);
				
				sleep(500);
				
			}
			
			current_turn ++;
			
		}while(fighter1.stats.get("hp")>0 && fighter2.stats.get("hp")>0);
		
		if (fighter1.stats.get("hp") > 0) {
			
			if (monster instanceof Monster) {
				gainExp(hero, monster);
				Equipment loot = monster.handleLoot();
				if (loot!=null)
					hero.handleLoot(loot);
			}
			return true;
		}
		return false;
		
	}
	
	private static boolean isHit(int hit, int eva) {
		
		int limit = eva/10;
		if (rnd.nextInt(hit) > limit)
			return true;
		return false;
	}
	
	private static boolean isCrit(int crit) {
		
		int limit = 200;
		if (rnd.nextInt(limit/4) + crit > limit/2 )
			return true;
		return false;
	}
	
	private static int getDamage(int atk, int def, boolean crit) {
		
		
		int limit;
		if (crit)
			limit = (int)(2*atk);
		else
			limit = (int)(2*atk - def*1.5);

		if (limit <=0)
			return rnd.nextInt(10);
		return rnd.nextInt(limit) + (3*limit)/4;
	}

	private static void gainExp(Hero player, Monster monster) {
		float exp = (player.getLevel() / monster.getLevel()) * monster.getExp();
		
		CombatInterface.showExpGain(player.getName(), exp);
		player.gainExp(exp);
		
	}
	
	private static void checkSkills(Fighter self, Fighter target) {

		for (Skill skill : self.skillList) {
			if (current_turn - skill.getLastUsage() > skill.getCooldown()) {
				skill.setLastUsage(current_turn);
				System.out.println(self.name + " used " + skill.getName());
				skill.useSkill(target);		
			}
		}
	}

	private static void useBuffs(Fighter self) {
		for (Buff buff : self.buffList) {
			if (current_turn - buff.getLastUsage() > buff.getCooldown() + buff.getDuration()) {
				buff.setTurnUsed(current_turn);
				self.current_buffs.add(buff);

			}
		}

	}

	private static void checkBuffs(Fighter self) {
		boolean remove;
		for (Buff buff : self.current_buffs) {
				remove = buff.useSkill(self.stats, current_turn);
				if(remove)
					current_buffs.remove(buff); // Removed buff due to end of duration time.
		}
	}

	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
};