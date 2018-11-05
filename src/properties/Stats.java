package properties;

import java.util.HashMap;
import java.util.Map;

public class Stats {
	
	private int maxHp; 	// 0
	private int maxSp; 	// 1
	private int atk; 	// 2
	private int def; 	// 3
	private int atkM; 	// 4
	private int defM; 	// 5
	private int hit; 	// 6
	private int eva; 	// 7
	private int crit; 	// 8
	private int spd; 	// 9
	private int ten; 	// 10
	private int cast; 	// 11
	
	public Stats() {
		this.maxHp = 0;
		this.maxSp = 0;
		this.atk = 0;
		this.def = 0;
		this.atkM = 0;
		this.defM = 0;
		this.hit = 0;
		this.eva = 0;
		this.crit = 0;
		this.spd = 0;
		this.ten = 0;
		this.cast = 0;
	}

	public void setStats(Map<String,Integer> attr) {
		
		this.maxHp = 2*(attr.get("str")) + (16*attr.get("vit"));			
		this.maxSp = (8*attr.get("int"));
		this.atk = (2*attr.get("str")) + (2*attr.get("dex"));
		this.def = (2*attr.get("vit")) + (attr.get("dex"));
		this.atkM = (3*attr.get("int"));
		this.defM = (2*attr.get("vit")) + (attr.get("int"));
		this.hit = (2*attr.get("dex")) + (attr.get("luk"));
		this.eva = (2*attr.get("agi")) + (attr.get("luk"));
		this.crit = (2*attr.get("luk")) + (attr.get("dex"));
		this.spd = (2*attr.get("agi"));
		this.ten = (2*attr.get("vit"));
		this.cast = 0;

	}
	
	public Map<String,Integer> getStats() {
		Map<String,Integer> stats = new HashMap<String,Integer>();
		stats.put("maxHp", this.maxHp);
		stats.put("maxSp", this.maxSp);
		stats.put("atk", this.atk);
	    stats.put("def", this.def);
	    stats.put("atkM", this.atkM);
	    stats.put("defM", this.defM);
	    stats.put("hit", this.hit);
		stats.put("eva", this.eva);
		stats.put("crit", this.crit);
		stats.put("spd", this.spd);
	    stats.put("ten", this.ten);
	    stats.put("cast", this.cast);
	    
		return stats;
		
	}
	
}