package characters;

public class Stats {
	
	private int maxHp;
	private int maxSp;
	private int atk;
	private int def;
	private int atkM;
	private int defM;
	private int hit;
	private int evas;
	private int crit;
	private int speed;
	private int ten;
	private int cast;
	
	public Stats() {
		this.maxHp = 0;
		this.maxSp = 0;
		this.atk = 0;
		this.def = 0;
		this.atkM = 0;
		this.defM = 0;
		this.hit = 0;
		this.evas = 0;
		this.crit = 0;
		this.speed = 0;
		this.ten = 0;
		this.cast = 0;
	}

	public void setStats(int[] attr) {
		// str=0, agi=1, vit=2, inte=3, dex=4, luck=5;
		
		this.maxHp = 2*(attr[0]) + (16*attr[2]);			
		this.maxSp = (8*attr[3]);
		this.atk = (2*attr[0]) + (2*attr[4]);
		this.def = (2*attr[2]) + (attr[4]);
		this.atkM = (3*attr[3]);
		this.defM = (2*attr[2]) + (attr[3]);
		this.hit = (2*attr[4]) + (attr[5]);
		this.evas = (2*attr[1]) + (attr[5]);
		this.crit = (2*attr[5]) + (attr[4]);
		this.speed = (2*attr[1]);
		this.ten = (2*attr[2]);
		this.cast = 0;

	}
	
	public int[] getArrayStats() {
		int[] stats = {this.maxHp, this.maxSp, this.atk,
						this.def, this.atkM, this.defM,
						this.hit, this.evas, this.crit,
						this.speed, this.ten, this.cast};
		return stats;
		
	}
	
}