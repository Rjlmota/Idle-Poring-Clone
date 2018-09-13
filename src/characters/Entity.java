package characters;


//A Class designed to hold standard attributes for all characters from the game
public abstract class Entity {

	public class atributos{
		public int ataque = 2;
		public int vitalidade = 2;
		public int destreza = 2;
		public int inteligencia = 2;
		public int sorte = 2;
		public int agilidade = 2;
		public int poder = 2;
		
	}
	public class Stats{
		public int hp = 2;
		public int sp = 2;
		public int atq = 2;
		public int def = 2;
		public int atqM = 2;
		public int defM = 2;
		public int hit = 2;
		public int crit=  2;
		public int tenacity = 2;
		public int miss = 2;
		public int atkSpeed = 2;
	}
	
	Stats stats = new Stats();
	public String status = "Free";
	public String nome;
	public String race;
	int nivel = 1;
	
	
	public void attack(Character target) {
		
	}
	
	//This function returns the character's stats
	public Stats getStats() {
		return this.stats;
	}
	
	//This function returns the name of the character
	public String getName() {
		return this.nome;
	}
	//Constructor class
	public Entity(String name) {
		this.nome = name;
	}
	
}