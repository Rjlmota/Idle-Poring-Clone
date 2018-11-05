package combat;
import characters.Class;
import characters.Monster;
import pseudointerface.CombatInterface;

public abstract class Combat {
	
	public static void startCombat(Class player, Monster monster) {
		int[] player_attr = player.stats.getArrayStats();
		int[] monster_attr = monster.stats.getArrayStats();
		
		int player_hp = player_attr[0]; // currentHp
		int monster_hp = monster_attr[0]; // currentHp
		
		int damage;
		
		System.out.println("Combat starts!");
		
		try {
			CombatInterface.currentLife(player.name, player_hp, monster.name, monster_hp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		while(player_hp > 0 && monster_hp > 0) {
			
			if (player_attr[9] >= monster_attr[9]) {
				damage = getDamage(player_attr[2], monster_attr[3]);
				monster_hp -= damage;
				CombatInterface.damage(player.name, monster.name, damage);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (monster_hp > 0) {
					damage = getDamage(monster_attr[2], player_attr[3]);
					player_hp -= damage;
					CombatInterface.damage(monster.name, player.name, damage);

				}

			}else {
				damage = getDamage(monster_attr[2], player_attr[3]);
				player_hp -= damage;
				CombatInterface.damage(monster.name, player.name, damage);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (player_hp > 0) {
					damage = getDamage(player_attr[2], monster_attr[3]);
					monster_hp -= damage;
					CombatInterface.damage(player.name, monster.name, damage);
				}
			}

			player_attr = player.stats.getArrayStats();
			monster_attr = monster.stats.getArrayStats();
			
			try {
				CombatInterface.currentLife(player.name, player_hp, monster.name, monster_hp);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Combat ends!");

	}
	
	
	private static int getDamage(int atk, int def) {
		int damage = (int) (atk *2 - def*1.5);
		if (damage>=0) {
			return damage;
		}
		return 0;
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
