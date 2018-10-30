package combat;
import characters.Class;
import characters.Monster;

import java.util.Random;

public class Combat {
	
	Class player;
	Monster monster;
	
	String p_name;
	//int player.currentHp;
	int p_atkSpeed;
	
	String m_name;
	//int monster.currentHp;
	
	int m_atkSpeed;
	
	Boolean dealing_damage;
	
	public Combat(Class player, Monster monster) {
		this.p_name = player.name;
		//this.player.currentHp = player.maxHp;
		this.p_atkSpeed = player.atkSpeed;
		
		this.player = player;
		this.monster = monster;
		
		this.m_name = monster.name;
		//this.monster.currentHp = monster.maxHp;	
		this.m_atkSpeed = monster.atkSpeed;
		
		System.out.println("\nCombat Starts!");
		System.out.println(p_name + " - Hp: " + player.currentHp);
		System.out.println(m_name + " - Hp: " + monster.currentHp);
		
		startCombat();
	}
	
	public void startCombat() {
		
		new Thread(playerTurn).start();
		new Thread(monsterTurn).start();

	}
	
	public Boolean combatIsOn() {
		if ((player.currentHp > 0) && (monster.currentHp > 0)) {
			return true; 
		}
		return false;
	}
	
	public int getMyTurn(int my_atkSpeed, int enemy_atkSpeed) {
		int my_turn = (my_atkSpeed*10000)/(my_atkSpeed + enemy_atkSpeed);
		return my_turn;
	}
	
	private Runnable playerTurn = new Runnable() {
		public void run() {
			try {
				Random rand = new Random();
				int damage;
				while (combatIsOn()) {
					Thread.sleep(getMyTurn(p_atkSpeed, m_atkSpeed));
					damage = (int) (player.atk *2 - monster.def*1.5);
					if(damage < 0)
						damage = 0;
					if (combatIsOn()) {
						monster.currentHp -= damage;
						
						if(monster.currentHp < 0)
							monster.currentHp = 0;
						
						player.currentHp += player.vit;
						if(player.currentHp > player.maxHp)
							player.currentHp = player.maxHp;
						System.out.println("\n" + p_name + " dealt " + damage + " damage to " + m_name);
						System.out.println(p_name + " - Hp: " + player.currentHp);
						System.out.println(m_name + " - Hp: " + monster.currentHp);
					}
				}
			} catch (Exception e) {};
		}
	};
	
	private Runnable monsterTurn = new Runnable() {
		public void run() {
			try {
				Random rand = new Random();
				int damage;
				while (combatIsOn()) {
					Thread.sleep(getMyTurn(m_atkSpeed, p_atkSpeed));
					damage = (int) (monster.atk*2 - player.def*1.5);
					if(damage < 0)
						damage = 0;
					if (combatIsOn()) {
						player.currentHp -= damage;
						if(player.currentHp < 0)
							player.currentHp = 0;
						System.out.println("\n" + m_name + " dealt " + damage + " damage to " + p_name);
						System.out.println(p_name + " - Hp: " + player.currentHp);
						System.out.println(m_name + " - Hp: " + monster.currentHp);
					}
				}
			} catch (Exception e) {};
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
}
