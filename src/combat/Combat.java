package combat;

import java.util.ArrayList;
import java.util.Map;
import characters.Entity;
import characters.Monster;
import pseudointerface.CombatInterface;
import pseudointerface.PlayerInterface;

public abstract class Combat {

	private static ArrayList<Buff> current_buffs = new ArrayList<Buff>();

	static Map<String, Integer> player_stats;
	static Map<String, Integer> monster_stats;

	static int current_turn = 0;

	public static boolean startCombat(Entity player, Entity monster) {
		player_stats = player.stats.getStats();
		monster_stats = monster.stats.getStats();

		int player_hp = player_stats.get("maxHp"); // currentHp
		int monster_hp = monster_stats.get("maxHp"); // currentHp

		int damage;

		System.out.println("Combat starts!");

		try {
			CombatInterface.currentLife(player.getName(), player_hp, monster.getName(), monster_hp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (player_hp > 0 && monster_hp > 0) {

			// Resets stats for reapply or removal of buffs.
			player_stats = player.stats.getStats();
			monster_stats = monster.stats.getStats();

			int skill_damage = checkSkills(player, monster);
			monster_hp -= skill_damage;

			skill_damage = checkSkills(monster, player);
			player_hp -= skill_damage;

			useBuffs(player);
			checkBuffs();

			if (player_stats.get("spd") >= monster_stats.get("spd")) {
				
				if (isHit(player_stats.get("hit"), monster_stats.get("eva"))){
					damage = getDamage(player_stats.get("atk"), monster_stats.get("def"));
					monster_hp -= damage;
					CombatInterface.damage(player.getName(), monster.getName(), damage);
				}else {
					System.out.println("Errou!");
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current_turn += 1;

				if (monster_hp > 0) {
					
					if (isHit(monster_stats.get("hit"), player_stats.get("eva"))){
						damage = getDamage(monster_stats.get("atk"), player_stats.get("def"));
						monster_hp -= damage;
						CombatInterface.damage(monster.getName(), player.getName(), damage);
					}else {
						System.out.println("Errou!");
					}
				}

			} else {
				
				if (isHit(monster_stats.get("hit"), player_stats.get("eva"))){
					damage = getDamage(monster_stats.get("atk"), player_stats.get("def"));
					monster_hp -= damage;
					CombatInterface.damage(monster.getName(), player.getName(), damage);
				}else {
					System.out.println("Errou!");
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current_turn += 1;

				if (monster_hp > 0) {
					
					if (isHit(player_stats.get("hit"), monster_stats.get("eva"))){
						damage = getDamage(player_stats.get("atk"), monster_stats.get("def"));
						monster_hp -= damage;
						CombatInterface.damage(player.getName(), monster.getName(), damage);
					}else {
						System.out.println("Errou!");
					}
				}
			}

			player_stats = player.stats.getStats();
			monster_stats = monster.stats.getStats();

			try {
				CombatInterface.currentLife(player.getName(), player_hp, monster.getName(), monster_hp);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Combat ends!");
		if (monster_hp <= 0) {
			player.handleLoot(monster.handleLoot());
			
			gainExp(player, monster);
			
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
		
		if (player.getExp() + exp >= 100) {
			float new_exp = player.getExp() + exp - 100;
			player.setExp(exp);
			PlayerInterface.levelUp(player);
		}else {
			player.setExp(player.getExp() + exp);
		}
		
	}
	
	private static int checkSkills(Entity self, Entity target) {
		/*
		 * Checks whether or not self has skills; Checks each one of the skill's
		 * cooldown; If they are available, the skill is used against target. obs: AoE
		 * Skills
		 */
		for (Skill skill : self.skillList) {
			if (current_turn - skill.last_usage > skill.cooldown) {
				skill.last_usage = current_turn;
				System.out.println(self.getName() + " used " + skill.getName());
				int damage = skill.useSkill(target);
				System.out.println("delt " + damage + " damage");
				return damage;
			}

		}
		return 0;
	}

	private static void useBuffs(Entity self) {
		for (Buff buff : self.buff_list) {
			System.out.println("Buff applied: " + buff.getName());
			if (current_turn - buff.last_usage > buff.cooldown) {
				buff.turn_used = current_turn;
				current_buffs.add(buff);

			}
		}

	}

	private static void checkBuffs() {
		for (Buff buff : current_buffs) {
			if (current_turn - buff.turn_used > buff.duration) {
				current_buffs.remove(buff);
			} else {
				buff.useSkill(player_stats);
			}
		}
	}

	public Combat() { }

};
