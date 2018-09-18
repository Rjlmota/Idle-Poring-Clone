import characters.Personagem;
import items.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personagem player = new Personagem("Rjlmota", "Male");
		Item sword = new Sword("Longsword", "sword", "Just a sword that is long", 12, 10);
		player.mochila.adicionarItem(sword);
		//System.out.println(player.getStats().atkSpeed);
		player.mochila.listar();

		System.out.println(player.getName());
		
	}

}
