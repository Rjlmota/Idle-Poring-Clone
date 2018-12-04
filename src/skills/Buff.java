package skills;

import java.util.Map;

import combat.Fighter;

public class Buff extends Skill {

	int buff;
	String stat;
	int duration;
	
	public Buff(String name, int buff, int duration, String stat, int cooldown_sec) {
		super(name, cooldown_sec, 1);
		this.buff = buff;
		this.stat = stat;
		this.duration = duration;
		super.setType("buff");

	}


	@Override
	public int useSkill(Fighter self, Fighter target) {
		System.out.println(getName() + "has been used");
		self.stats.put(this.stat, self.stats.get(stat) + buff);
		//self.current_buffs.add(this);
		System.out.println(self.name + "'s " + stat + " + " + buff);
		return 0;
	}
	
	public void removeBuff(Fighter self) {
		self.stats.put(this.stat, self.stats.get(stat) - buff);
	}

	
	
	public int getDuration(){
		return this.duration;
	}

	public boolean isActive(int current_turn){
		if(current_turn - this.turn_used < duration)
			return true;
		else
			return false;
	}
	
}
