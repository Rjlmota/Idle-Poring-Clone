import characters.Character;
import items.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character player = new Character("Rjlmota", "Male");
		Item sword = new Sword("Longsword", "sword", "Just a sword that is long", 12, 10);
		player.bag.addItem(sword);
		//System.out.println(player.getStats().atkSpeed);
		player.bag.list();

		
	}

}
