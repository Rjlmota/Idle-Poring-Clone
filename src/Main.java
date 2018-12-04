import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import characters.Hero;
import phase.Level;
import pseudointerface.StartInterface;

public class Main {
	public static void main(String[] args) {


		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Map<Hero, Level> database = new HashMap<Hero, Level>();
		int op;
		
		while(true) {
			
			System.out.print("1-Select Hero\n2-Start New Game\n:> ");
			do {
				op = scan.nextInt();
			}while (op<0 || op>3);
			
			if (op==1) {
				StartInterface.selectHero(database);
			}else {
				StartInterface.createGame(database);
			}
			
		}
	}

}
