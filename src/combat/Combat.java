package combat;

import characters.Entity;
public abstract class Combat {
	

	public static void turn(Entity player, Entity monster) {
		int turn_player = 0;
		int turn_monster = 0;
		int damage = 0;
		while((player.attributes.hp > 0)||(monster.attributes.hp > 0)) {
			System.out.println(player.getName() + ": " + player.attributes.hp);
			System.out.println(monster.getName() + ": " + monster.attributes.hp);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			turn_player += player.attributes.atkSpeed;
			if (turn_player >= 10) {
				turn_player -= 10;
				if (hit(player, monster)) {
					damage = (int)Math.random()*100 +0;
					System.out.println(player.getName() + " deu " + damage + " de dano em " + monster.getName() + "!");
					monster.updateHp(-damage);
				}else {
					System.out.println(player.getName() + "errou!");
				}
			}
			turn_monster += player.attributes.atkSpeed;
			if (turn_monster >= 10) {
				turn_monster -= 10;
				if (hit(player, monster)) {
					damage = (int)Math.random()*100 +0;
					System.out.println(monster.getName() + " deu " + damage + " de dano em " + player.getName() + "!");
					player.updateHp(-damage);
				}else {
					System.out.println(player.getName() + "errou!");
				}
			}
		}
	}
	
	public static boolean hit(Entity attacker, Entity defender) {
		double chance = Math.random()*1 +0;
		//ATTACKERHIT - DEFENDERFLEE
		int precision = attacker.getAttributes().hit - defender.getAttributes().flee;
		int pool = attacker.getAttributes().hit + defender.getAttributes().flee;
		double bet = precision/(double)pool;
		if (bet >= 0.95) bet = 0.95;
		else if (bet <0) bet = 0;
	
		if(chance <= bet){
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
