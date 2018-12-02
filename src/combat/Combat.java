package combat;
import java.util.ArrayList;
import java.util.Map;
import characters.Entity;
import characters.Monster;
import pseudointerface.CombatInterface;

public abstract class Combat {
	
	

	private static ArrayList<Buff> current_buffs = new ArrayList<Buff>();
	
	static Map<String,Integer> player_attr;
	static Map<String,Integer> monster_attr;
	
	static int current_turn = 0;
	
	public static boolean startCombat(Entity player, Monster monster) {
		player_attr = player.stats.getStats();
		monster_attr = monster.stats.getStats();
		
		int player_hp = player_attr.get("maxHp"); // currentHp
		int monster_hp = monster_attr.get("maxHp"); // currentHp
		
		int damage;
		
		System.out.println("Combat starts!");
		
		try {
			CombatInterface.currentLife(player.name, player_hp, monster.name, monster_hp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		while(player_hp > 0 && monster_hp > 0) {
			
			//Resets stats for reapply or removal of buffs.
			player_attr = player.stats.getStats();
			monster_attr = monster.stats.getStats();
			
			int skill_damage = checkSkills(player, monster);
			monster_hp -= skill_damage;
			
			skill_damage = checkSkills(monster, player);
			player_hp -= skill_damage;
			
			
			useBuffs(player);
			checkBuffs();
			
			
			if (player_attr.get("spd") >= monster_attr.get("spd")) {
				damage = getDamage(player_attr.get("atk"), monster_attr.get("def"));
				monster_hp -= damage;
				CombatInterface.damage(player.name, monster.name, damage);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current_turn += 1;
				
				if (monster_hp > 0) {
					damage = getDamage(monster_attr.get("atk"), player_attr.get("def"));
					player_hp -= damage;
					CombatInterface.damage(monster.name, player.name, damage);
					current_turn += 1;
				}

			}else {
				damage = getDamage(monster_attr.get("atk"), player_attr.get("def"));
				player_hp -= damage;
				CombatInterface.damage(monster.name, player.name, damage);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current_turn += 1;
				if (player_hp > 0) {
					damage = getDamage(player_attr.get("atk"), monster_attr.get("def"));
					monster_hp -= damage;
					CombatInterface.damage(player.name, monster.name, damage);
					current_turn += 1;
				}
			}

			player_attr = player.stats.getStats();
			monster_attr = monster.stats.getStats();
			
			try {
				CombatInterface.currentLife(player.name, player_hp, monster.name, monster_hp);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		System.out.println("Combat ends!");
		if(monster_hp <= 0) {
			player.handleLoot(monster.handleLoot());
			return true;
		}else 
			return false;
	}
	
	
	private static int getDamage(int atk, int def) {
		int damage = (int) (atk *2 - def*1.5);
		if (damage>=0) {
			return damage;
		}
		return 0;
	}
	
	private static int checkSkills(Entity self, Entity target) {
		/*
		 * 
		 * Checks  whether or not self has skills;
		 * Checks each one of the skill's cooldown;
		 * If they are available, the skill is used against target.
		 *  obs: AoE Skills
		 */
		for(Skill skill : self.skillList) {
			if(current_turn - skill.last_usage > skill.cooldown) {
				skill.last_usage = current_turn;
				System.out.println(self.name + " used " + skill.name);
				int damage = skill.useSkill(target);
				System.out.println("delt " + damage + " damage");
				return damage;
			}
			
		}
		return 0;
	}
	
	
	private static void useBuffs(Entity self) {
		for(Buff buff : self.buff_list) {
			System.out.println("Buff applied: " + buff.name);
			if(current_turn - buff.last_usage > buff.cooldown) {
				buff.turn_used = current_turn;
				current_buffs.add(buff);
				
			}
		}
		
		
	}
	
	private static void checkBuffs() {
		for(Buff buff : current_buffs) {
			if(current_turn - buff.turn_used > buff.duration) {
				current_buffs.remove(buff);
			}else {
				buff.useSkill(player_attr);
			}
		}
	}
	
	public Combat() {
		
	}
	
	
};
	

	
	
	/*
	public static int attack(Character attacker, Character defender) {
		if (attacker.hp > 0) {
			int damage = attacker.getAttributes().atk - defender.getAttributes().def;
			if(damage > 0){
				defender.updateHp(-damage);
				return damage;
			}
			else {
				return 0;
			}
		}
		return 0;
}

	public static void turn(Character player, Character monster) {
		int turn_player = 0;
		int turn_monster = 0;
		int damage = 0;
		System.out.println(player.getName() + ": " + player.hp);
		System.out.println(monster.getName() + ": " + monster.hp);
		while((player.hp > 0)&&(monster.hp > 0)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			turn_player += player.getAttributes().atkSpeed;
			if (turn_player >= 5) {
				turn_player -= 5;
				if (hit(player, monster)) {
					damage = attack(player, monster);
					System.out.println("\t\t" + player.getName() + " deu " + damage + " de dano em " + monster.getName() + "!");
				}else {
					System.out.println("\t\t" + player.getName() + " errou!");
				}
			}
			turn_monster += player.getAttributes().atkSpeed;
			if (turn_monster >= 5) {
				turn_monster -= 5;
				if (hit(player, monster)) {
					damage = attack(monster, player);
					System.out.println("\t\t" + monster.getName() + " deu " + damage + " de dano em " + player.getName() + "!");
				}else {
					System.out.println("\t\t" + monster.getName() + " errou!");
				}
			}
			System.out.println(player.getName() + ": " + player.hp);
			System.out.println(monster.getName() + ": " + monster.hp);
		}
		if (player.hp > 0) {
			System.out.println(player.getName() + " ganhou!");
		}else {
			System.out.println(monster.getName() + " ganhou!");
		}
	}
	
	public static boolean hit(Character attacker, Character defender) {
		double chance = Math.random()*1 +0;
		//ATTACKERHIT - DEFENDERFLEE
		double precision = attacker.getAttributes().hit/defender.getAttributes().evasion;
			
		//int pool = attacker.getAttributes().hit + defender.getAttributes().flee;
		//double bet = precision/(double)pool;
		if (precision >= 0.95) precision = 0.95;
		else if (precision <=0) precision = 0.05;
	
		if(chance <= precision){
			return true;
		}
		return false;
	}

	
	public static boolean crit(Character Atacante){
		double chance = Math.random() *1 +0;
		if(20 < chance) {
			return true;
		}else {
			return false;
		}
	}
	*/
