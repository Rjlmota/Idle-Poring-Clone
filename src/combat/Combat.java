package combat;

import characters.Entity;
public abstract class Combat {
	

	public static void turn(Entity player, Entity monster) {
		int turn_player = 0;
		int turn_monster = 0;
		int damage = 0;
		System.out.println(player.getName() + ": " + player.attributes.hp);
		System.out.println(monster.getName() + ": " + monster.attributes.hp);
		while((player.attributes.hp > 0)&&(monster.attributes.hp > 0)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			turn_player += player.attributes.atkSpeed;
			if (turn_player >= 5) {
				turn_player -= 5;
				if (hit(player, monster)) {
					damage = player.attack(monster);
					System.out.println("\t\t" + player.getName() + " deu " + damage + " de dano em " + monster.getName() + "!");
				}else {
					System.out.println("\t\t" + player.getName() + " errou!");
				}
			}
			turn_monster += player.attributes.atkSpeed;
			if (turn_monster >= 5) {
				turn_monster -= 5;
				if (hit(player, monster)) {
					damage = monster.attack(player);
					System.out.println("\t\t" + monster.getName() + " deu " + damage + " de dano em " + player.getName() + "!");
				}else {
					System.out.println("\t\t" + monster.getName() + " errou!");
				}
			}
			System.out.println(player.getName() + ": " + player.attributes.hp);
			System.out.println(monster.getName() + ": " + monster.attributes.hp);
		}
		if (player.attributes.hp > 0) {
			System.out.println(player.getName() + " ganhou!");
		}else {
			System.out.println(monster.getName() + " ganhou!");
		}
	}
	
	public static boolean hit(Entity attacker, Entity defender) {
		double chance = Math.random()*1 +0;
		//ATTACKERHIT - DEFENDERFLEE
		double precision = attacker.getAttributes().hit/defender.getAttributes().flee;
			
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
	
	public static int physDamage(Entity Atacante, Entity Atacado) {
		/*Code to determine the amount of damage to be removed of reciever's health pool */
		int damage;
		if(hit(Atacante, Atacado)) {
		}
		
		return 200;
	}
	
	
	

}
