package characters;

public class HeroFactory {

	public static Hero getHero(String job, String name) {
		
		if (job.equalsIgnoreCase("Swordman"))
			return new Swordman(name);

		else if (job.equalsIgnoreCase("Archer"))
			return new Archer(name);

		else if (job.equalsIgnoreCase("Wizard"))
			return new Wizard(name);

		else
			throw new IllegalArgumentException();

	}
}
