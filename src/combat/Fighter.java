package combat;

import java.util.ArrayList;
import java.util.Map;
import properties.Entity;
import skills.Buff;
import skills.Skill;

public class Fighter {
	
	public String name;
	public Map<String,Integer> stats;
	
	
	public ArrayList <Skill> skillList = new ArrayList<Skill>();
	public ArrayList <Buff> current_buffs = new ArrayList<Buff>();
	public ArrayList <Skill> actions = new ArrayList <Skill>();
	
	public Skill auto_attack;
	
	public Fighter() { }
	
	public void setFighter(Entity fighter) {
		this.name = fighter.getName();
		this.stats = fighter.stats.getStats();
		this.skillList = fighter.skillList;
		this.auto_attack = fighter.auto_attack;
		
		this.setActions();
		
	}
	
	private void setActions() {
		for(Skill skill : skillList) {
			actions.add(skill);
			for(int i = 0; i < skill.getCooldown(); i++)
				actions.add(auto_attack);
		actions.add(skillList.get(skillList.size()-1));
		}
		
		if(skillList.isEmpty()) {
			for(int i = 0; i < 100; i++)
				actions.add(auto_attack);
			}
		
	}
	
}
