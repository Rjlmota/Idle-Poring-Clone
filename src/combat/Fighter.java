package combat;

import java.util.Map;
import characters.Entity;

public class Fighter {
	
	public String name;
	public Map<String,Integer> stats;
	
	public Fighter() { }
	
	public void setFighter(Entity fighter) {
		this.name = fighter.getName();
		this.stats = fighter.stats.getStats();
	}
	
}
