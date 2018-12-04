package combat;

import java.util.ArrayList;
import java.util.Map;
import properties.Entity;
import monsters.Monster;
import pseudointerface.CombatInterface;
import pseudointerface.PlayerInterface;
import skills.Buff;
import skills.Skill;

public abstract class Combat {

	private static ArrayList<Buff> current_buffs = new ArrayList<Buff>();

	public static Fighter fighter1 = new Fighter();
	public static Fighter fighter2 = new Fighter();
	
	
	public static int current_turn = 0;

	public static boolean startCombat(Entity entity1, Entity entity2) {
		
		fighter1.setFighter(entity1);
		fighter2.setFighter(entity2);
		
		ArrayList<Fighter> order = new ArrayList();
		
		System.out.println("Combat Starts!");
		
		current_turn = 0;
		
		do {
		
			CombatInterface.currentLife(fighter1.name, fighter1.stats.get("hp"), fighter2.name, fighter2.stats.get("hp"));
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
					
					int damage = getDamage(order.get(0).stats.get("atk"), order.get(1).stats.get("def"));
					order.get(1).stats.replace("hp", order.get(1).stats.get("hp") - damage);
					CombatInterface.damage(order.get(0).name, order.get(1).name, damage);

				}else {
					
					System.out.println("Missed!");
					
				}
				
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
			
			if (entity2 instanceof Monster) {
				gainExp(entity1, entity2);
				entity1.handleLoot(entity2.handleLoot());
			}
			return true;
		}
		return false;
		
	}
	
	private static boolean isHit(int hit, int eva) {
		if (hit >= eva) {
			return true;
		}
		return false;
	}
	
	private static int getDamage(int atk, int def) {
		int damage = (int) (atk * 2 - def * 1.5);
		if (damage >= 0) {
			return damage;
		}
		return 0;
	}

	private static void gainExp(Entity player, Entity monster) {
		float exp = (player.getLevel() / monster.getLevel()) * monster.getExp();
		
		CombatInterface.gainExp(player.getName(), exp);
		
		if (player.getExp() + exp >= 1000) {
			float new_exp = player.getExp() + exp - 100;
			player.setExp(exp);
			PlayerInterface.levelUp(player);
		}else {
			player.setExp(player.getExp() + exp);
		}
		
	}
	
	private static void checkSkills(Fighter self, Fighter target) {
		/*
		 * Checks whether or not self has skills; Checks each one of the skill's
		 * cooldown; If they are available, the skill is used against target. obs: AoE
		 * Skills
		 */
		for (Skill skill : self.skillList) {
			//System.out.println(current_turn + " " + skill.getLastUsage());
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
	
	public Combat() { }

};