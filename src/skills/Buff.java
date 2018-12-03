package skills;

import java.util.Map;

public class Buff extends Skill {

	int buff;
	String stat;
	int duration;
	int turn_used = 0;
	boolean active = false;
	
	
	public Buff(String name, int buff, int duration, String stat, int cooldown_sec) {
		super(name, cooldown_sec, 1);
		this.buff = buff;
		this.stat = stat;
		this.duration = duration;
		super.setType("passive");

	}

	public boolean useSkill(Map<String, Integer> attr, int current_turn) {
		if(active == true) {
			if(current_turn - turn_used > duration) {
				active = false;
				attr.put(this.stat, attr.get(stat) - buff);
				System.out.println(getName() + "weared off");
				return false;
			}
		}
		
		if(active == false) {
			if(current_turn - turn_used > duration + getCooldown()) {
				System.out.println(getName() + "has been used");
				attr.put(this.stat, attr.get(stat) + buff);
				this.turn_used = current_turn;
				active = true;
			}
		}
		return true;
	}

	public int getDuration(){
		return this.duration;
	}

	public void setTurnUsed(int x){
		this.turn_used = x;
	}

}
