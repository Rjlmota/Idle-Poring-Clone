package combat;

import java.util.ArrayList;
import java.util.Map;
import characters.Entity;

public class Fighter {
	
	public String name;
	public Map<String,Integer> stats;
	
	public ArrayList <Skill> skillList = new ArrayList<Skill>(); 
	public ArrayList <Buff> buffList = new ArrayList<Buff>(); 
	public ArrayList <Buff> current_buffs = new ArrayList<Buff>(); 	
	public Fighter() { }
	
	public void setFighter(Entity fighter) {
		this.name = fighter.getName();
		this.stats = fighter.stats.getStats();
		this.skillList = fighter.skillList;
		this.buffList = fighter.buff_list;
	}
	
}
