import characters.Character;
import characters.Hero;
import characters.Monster;
import combat.Combat;
import items.*;

public class Main {
	//Teste
	//Teste 2
	//Teste 3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character player = new Hero("10", "Rjlmota");
		Item sword = new Sword("Longsword", "sword", "Just a sword that is long", 12, 10);
		player.bag.addItem(sword);
		//System.out.println(player.getStats().atkSpeed);
		player.bag.list();

		//System.out.println(player.attributes.hp);
		//player.updateHp(-100);
		//System.out.println(player.attributes.hp);
		
		Monster monster = new Monster("22", "Poring");
		//System.out.println(monster.level);
		//monster.upLevel(1);
		//System.out.println(monster.level);
		
		player.upLevel(6);
		monster.upLevel(4);
		
		Combat.turn(player, monster);
		
		
		
	}

}
